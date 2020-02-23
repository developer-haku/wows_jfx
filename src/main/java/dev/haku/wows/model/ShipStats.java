package dev.haku.wows.model;

public class ShipStats extends Ship {
    private final int totalBattles;
    private final double winRate;
    private final double avgDMG;
    private final double avgFrags;
    private final double avgShootDown;

    public ShipStats(String name, String tier, boolean isPremium, boolean isSteel, int totalBattles, double winRate, double avgDMG, double avgFrags, double avgShootDown) {
        super(name, tier, isPremium, isSteel);
        this.totalBattles = totalBattles;
        this.winRate = winRate;
        this.avgDMG = avgDMG;
        this.avgFrags = avgFrags;
        this.avgShootDown = avgShootDown;
    }

    public int getTotalBattles() {
        return totalBattles;
    }

    public double getWinRate() {
        return winRate;
    }

    public double getAvgDMG() {
        return avgDMG;
    }

    public double getAvgFrags() {
        return avgFrags;
    }

    public double getAvgShootDown() {
        return avgShootDown;
    }
}


