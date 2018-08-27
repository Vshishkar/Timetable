package by.dlb.timetable.service;

import by.dlb.timetable.service.impl.BusEntryFactoryImpl;
import by.dlb.timetable.service.impl.BusEntryServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){};

    private final BusEntryService busEntryService = new BusEntryServiceImpl();

    private final BusEntryFactory busEntryFactory = new BusEntryFactoryImpl();

    public BusEntryFactory getBusEntryFactory() {
        return busEntryFactory;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public  BusEntryService getBusEntryService() {
        return busEntryService;
    }


}
