package by.dlb.timetable.service;

import by.dlb.timetable.entity.BusEntry;

public interface BusEntryFactory {

    /***
     * Creates BusEntry object using line at file timetable_in.txt ( company_name hh:mm(arrives) hh:mm(reaches))
     *
     * @param source
     * @return
     */
    BusEntry createBusEntry(String source);

}
