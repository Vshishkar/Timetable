package by.dlb.timetable.utill;

import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.service.BusEntryFactory;
import by.dlb.timetable.service.ServiceFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusEntryParserImpl implements BusEntryParser {

    public List<BusEntry> parse(String filePath) {

        List<BusEntry> result = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))){

            BusEntryFactory busEntryFactory = ServiceFactory.getInstance().getBusEntryFactory();

            while (bf.ready()){
                String source = bf.readLine();
                if(!source.isEmpty()){
                    result.add(busEntryFactory.createBusEntry(source));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
