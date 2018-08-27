package by.dlb.timetable.entity;

import java.io.Serializable;
import java.util.Date;

public class BusEntry implements Serializable {

    private BusCompany busCompany;

    private Date dateArrives;

    private Date dateReaches;

    public BusEntry() {
    }

    public BusEntry(BusCompany busCompany, Date dateArrives, Date dateReaches) {
        this.busCompany = busCompany;
        this.dateArrives = dateArrives;
        this.dateReaches = dateReaches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusEntry busEntry = (BusEntry) o;
        return busCompany == busEntry.busCompany &&
                dateArrives.equals(busEntry.dateArrives) &&
                dateReaches.equals(busEntry.dateReaches);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + busCompany.hashCode();
        result = prime * result + dateReaches.hashCode();
        result = prime * result + dateArrives.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "BusEntry{" +
                "busCompany=" + busCompany +
                ", dateArrives=" + dateArrives +
                ", dateReaches=" + dateReaches +
                '}';
    }

    public BusCompany getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(BusCompany busCompany) {
        this.busCompany = busCompany;
    }

    public Date getDateArrives() {
        return dateArrives;
    }

    public void setDateArrives(Date dateArrives) {
        this.dateArrives = dateArrives;
    }

    public Date getDateReaches() {
        return dateReaches;
    }

    public void setDateReaches(Date dateReaches) {
        this.dateReaches = dateReaches;
    }
}
