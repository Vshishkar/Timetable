package by.dlb.timetable.entity;

import java.util.Comparator;

public class BusEntryDateArrivesComparator implements Comparator<BusEntry> {
    @Override
    public int compare(BusEntry o1, BusEntry o2) {

        int result;

        if (o1.getDateArrives().after(o2.getDateArrives())){
            result = 1;
        }
        else if(o2.getDateArrives().equals(o1.getDateArrives())){
            result = 0;
        }
        else {
            result = -1;
        }

        return result;
    }
}
