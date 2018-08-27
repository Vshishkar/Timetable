package by.dlb.timetable.runner;

import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.service.BusEntryService;
import by.dlb.timetable.service.ServiceException;
import by.dlb.timetable.service.ServiceFactory;
import by.dlb.timetable.utill.BusEntryFormatter;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        BusEntryService  service = ServiceFactory.getInstance().getBusEntryService();

        List<BusEntry> busEntries = null;
        try {
            busEntries = service.createTimeTable();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        for (BusEntry busEntry: busEntries){
            BusEntryFormatter.print(busEntry);
        }

    }
}
