package by.dlb.timetable.utill;

import by.dlb.timetable.entity.BusEntry;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static by.dlb.timetable.utill.Constant.HOURS_MINUTES_PATTERN;

public class BusEntryFormatter {

    private BusEntryFormatter(){}

    public static void print(BusEntry busEntry){
        System.out.println(busEntry.getBusCompany() + " " + busEntry.getDateArrives() + " " + busEntry.getDateReaches());
    }

    public static String format(BusEntry busEntry){

        String companyName = capitalize(busEntry.getBusCompany().toString().toLowerCase());

        Format format = new SimpleDateFormat(HOURS_MINUTES_PATTERN);

        String dateArrives = format.format(busEntry.getDateArrives());
        String dateReaches = format.format(busEntry.getDateReaches());

        return companyName + " " + dateArrives +  " " + dateReaches;
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
