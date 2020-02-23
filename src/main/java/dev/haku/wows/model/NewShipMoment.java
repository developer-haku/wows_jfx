package dev.haku.wows.model;

public class NewShipMoment extends ImportantMoment {
    private String momentType;
    private String moment;

    public NewShipMoment(int year, int month, int day, String ship) {
        super(year, month, day, ship);
        this.moment = "New Ship <" + getShip() + ">";
        this.momentType = "New Ship";
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
