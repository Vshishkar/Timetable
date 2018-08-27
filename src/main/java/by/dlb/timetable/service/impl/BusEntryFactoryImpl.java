package by.dlb.timetable.service.impl;

import by.dlb.timetable.entity.BusCompany;
import by.dlb.timetable.entity.BusEntry;
import by.dlb.timetable.service.BusEntryFactory;
import by.dlb.timetable.utill.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static by.dlb.timetable.utill.Constant.HOURS_MINUTES_PATTERN;

public class BusEntryFactoryImpl implements BusEntryFactory {

    public BusEntry createBusEntry(String source) {

        String[] values = source.split(" ");

        BusEntry busEntry = new BusEntry();

        busEntry.setBusCompany(BusCompany.valueOf(values[0].toUpperCase()));

        DateFormat format = new SimpleDateFormat(HOURS_MINUTES_PATTERN,Locale.ENGLISH);

        try {
            Date dateArrives = format.parse(values[1]);
            Date dateReaches = format.parse(values[2]);

            if(dateArrives.after(dateReaches)){
                dateReaches = DateUtil.addDays(dateReaches,1);
            }

            busEntry.setDateArrives(dateArrives);
            busEntry.setDateReaches(dateReaches);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return busEntry;
    }
}
