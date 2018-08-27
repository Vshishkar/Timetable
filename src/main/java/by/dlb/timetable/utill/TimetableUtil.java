package by.dlb.timetable.utill;

import by.dlb.timetable.entity.BusCompany;
import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.entity.BusEntryDateArrivesComparator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static by.dlb.timetable.utill.Constant.HOUR;

public class TimetableUtil {

    private TimetableUtil(){}

    public static List<BusEntry> createFlexibleTimetable(List<BusEntry> entries){

        Collections.sort(entries,new BusEntryDateArrivesComparator());
        entries = TimetableUtil.removeEntriesByDuration(entries,HOUR);

        Stack<BusEntry> busEntryStack = new Stack<>();
        busEntryStack.push(entries.get(0));

        int i = 1;
        while (i < entries.size()){

            BusEntry busEntryCurrent = entries.get(i);
            BusEntry busEntryPrevious = busEntryStack.peek();

            Date currentArrives = busEntryCurrent.getDateArrives();
            Date currentReaches = busEntryCurrent.getDateReaches();
            Date previousArrives = busEntryPrevious.getDateArrives();
            Date previousReaches = busEntryPrevious.getDateReaches();

            // TODO Refactoring
            if(currentArrives.equals(previousArrives)){
                if(currentReaches.equals(previousReaches)){
                    if(busEntryCurrent.getBusCompany().equals(BusCompany.POSH)
                            && busEntryPrevious.getBusCompany().equals(BusCompany.GROTTY)){
                        busEntryStack.pop();
                        busEntryStack.push(busEntryCurrent);
                    }
                } else if(currentReaches.before(previousReaches)){
                    busEntryStack.pop();
                    busEntryStack.push(busEntryCurrent);
                }
            } else {
                if(currentReaches.equals(previousReaches) || currentReaches.before(previousArrives)){
                    busEntryStack.pop();
                }
                busEntryStack.push(busEntryCurrent);
            }
            i++;
        }

        return busEntryStack;
    }

    public static void timetableToFile(List<BusEntry> entries,String filename){

        Map<BusCompany,List<BusEntry>> timetableByCompany = divideTimetableByCompany(entries);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){

            for (BusCompany company: timetableByCompany.keySet()){
                appendTimetableToFile(timetableByCompany.get(company),filename);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void appendTimetableToFile(List<BusEntry> entries,String filename) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));

        for (BusEntry entry:entries){
            writer.append(BusEntryFormatter.format(entry));
            writer.append("\n");
        }
        writer.append("\n");

        writer.close();

    }

    private static Map<BusCompany,List<BusEntry>> divideTimetableByCompany(List<BusEntry> entries){

        Map<BusCompany,List<BusEntry>> timetableByCompany = new HashMap<>();

        List<BusEntry> poshList = new ArrayList<>();
        List<BusEntry> grottyList = new ArrayList<>();

        for (BusEntry entry:entries){
            if(entry.getBusCompany().equals(BusCompany.GROTTY)){
                grottyList.add(entry);
            }else {
                poshList.add(entry);
            }
        }

        timetableByCompany.put(BusCompany.POSH,poshList);
        timetableByCompany.put(BusCompany.GROTTY,grottyList);

        return timetableByCompany;
    }

    private static List<BusEntry> removeEntriesByDuration(List<BusEntry> entries,long duration){

        for (BusEntry entry:entries){
            if (entry.getDateReaches().getTime() - entry.getDateArrives().getTime() > duration){
                entries.remove(entry);
            }
        }
        return entries;
    }

}
