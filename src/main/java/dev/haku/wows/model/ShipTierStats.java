package dev.haku.wows.model;

public class ShipTierStats extends Stats {

    private final String tier;

    public ShipTierStats(int battles, double winRate, int personalRating, double avgFrags, int avgDMG, double avgShootDown, int maxFrags, int maxDMG, int maxShootDown, String tier) {
        super(battles, winRate, personalRating, avgFrags, avgDMG, avgShootDown, maxFrags, maxDMG, maxShootDown);
        this.tier = tier;
    }

    public String getTier() {
        return tier;
    }
}
