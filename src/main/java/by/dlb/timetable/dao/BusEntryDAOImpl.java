package by.dlb.timetable.dao;

import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.entity.BusEntryDateArrivesComparator;
import by.dlb.timetable.utill.BusEntryParser;
import by.dlb.timetable.utill.BusEntryParserImpl;
import by.dlb.timetable.utill.TimetableUtil;
import static by.dlb.timetable.utill.Constant.INPUT_FILE_NAME;
import static by.dlb.timetable.utill.Constant.OUTPUT_FILE_NAME;

import java.util.Collections;
import java.util.List;

public class BusEntryDAOImpl implements BusEntryDAO {


    public List<BusEntry> createTimeTable() {

        BusEntryParser parser = new BusEntryParserImpl();
        ClassLoader classLoader = getClass().getClassLoader();

        List<BusEntry> timetable =  parser.parse(classLoader.getResource(INPUT_FILE_NAME).getFile());

        List<BusEntry> flexibleTimetable = TimetableUtil.createFlexibleTimetable(timetable);

        TimetableUtil.timetableToFile(flexibleTimetable,OUTPUT_FILE_NAME);

        return flexibleTimetable;
    }
}
