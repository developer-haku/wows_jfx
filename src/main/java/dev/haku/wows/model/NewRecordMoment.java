package dev.haku.wows.model;

public class NewRecordMoment extends ImportantMoment {
    private String momentType;
    private final int number;
    private final String type;
    private String moment;

    public NewRecordMoment(int year, int month, int day, String ship, int number, String type) {
        super(year, month, day, ship);
        this.number = number;
        this.type = type;
        this.moment = getShip() + " - " + getNumber() + " " + getType();
        this.momentType = "New Record";
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getMomentType() {
        return momentType;
    }

    @Override
    public String getMoment() {
        return moment;
    }
}
