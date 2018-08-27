package by.dlb.timetable.dao;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final BusEntryDAO busEntryDAO = new BusEntryDAOImpl();

    private  DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public BusEntryDAO getBusEntryDAO() {
        return busEntryDAO;
    }
}
