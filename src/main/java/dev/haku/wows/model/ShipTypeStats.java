package dev.haku.wows.model;

public class ShipTypeStats extends Stats {

    private final String type;

    public ShipTypeStats(int battles, double winRate, int personalRating, double avgFrags, int avgDMG, double avgShootDown, int maxFrags, int maxDMG, int maxShootDown, String type) {
        super(battles, winRate, personalRating, avgFrags, avgDMG, avgShootDown, maxFrags, maxDMG, maxShootDown);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
