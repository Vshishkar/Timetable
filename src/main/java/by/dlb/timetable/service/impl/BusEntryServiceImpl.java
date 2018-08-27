package by.dlb.timetable.service.impl;

import by.dlb.timetable.dao.BusEntryDAO;
import by.dlb.timetable.dao.DAOException;
import by.dlb.timetable.dao.DAOFactory;
import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.service.BusEntryService;
import by.dlb.timetable.service.ServiceException;

import java.util.List;

public class BusEntryServiceImpl implements BusEntryService {

    public List<BusEntry> createTimeTable() throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        BusEntryDAO busEntryDAO = daoFactory.getBusEntryDAO();

        List<BusEntry> entries = null;
        try {
            entries = busEntryDAO.createTimeTable();
        } catch (DAOException e) {
            throw new ServiceException("Service exception",e);
        }

        return entries;
    }
}
