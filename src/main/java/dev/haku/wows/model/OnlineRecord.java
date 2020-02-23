package dev.haku.wows.model;

public class OnlineRecord implements Comparable<OnlineRecord> {
    private final int year;
    private final int month;
    private final int battles;

    public OnlineRecord(int year, int month, int battles) {
        this.year = year;
        this.month = month;
        this.battles = battles;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getBattles() {
        return battles;
    }

    @Override
    public int compareTo(OnlineRecord o) {
        int compareYear = Integer.compare(this.year, o.getYear());
        return compareYear != 0 ? compareYear : Integer.compare(this.month, o.getMonth());
    }
}
