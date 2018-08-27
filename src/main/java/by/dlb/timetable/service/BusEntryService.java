package by.dlb.timetable.service;

import by.dlb.timetable.entity.BusEntry;

import java.util.List;

public interface BusEntryService {

        List<BusEntry> createTimeTable() throws ServiceException;

}
