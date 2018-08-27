package by.dlb.timetable.dao;

import by.dlb.timetable.entity.BusEntry;

import java.util.List;

public interface BusEntryDAO {

    List<BusEntry> createTimeTable() throws DAOException;

}
