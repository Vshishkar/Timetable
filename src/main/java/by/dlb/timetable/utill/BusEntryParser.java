package by.dlb.timetable.utill;

import by.dlb.timetable.entity.BusEntry;

import java.util.List;

public interface BusEntryParser {

    List<BusEntry> parse(String filePath);

}
