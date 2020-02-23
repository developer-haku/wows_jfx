package dev.haku.wows.model;

public class ImportantMoment implements Comparable {
    private String momentType;
    private final int year;
    private final int month;
    private final int day;
    private final String ship;
    private String moment;

    public ImportantMoment(int year, int month, int day, String ship) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.ship = ship;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getShip() {
        return ship;
    }

    public String getMomentType() {
        return momentType;
    }

    public void setMomentType(String momentType) {
        this.momentType = momentType;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
