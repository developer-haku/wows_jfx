package dev.haku.wows.model;

public class Stats {
    private final int battles;
    private final double winRate;
    private final int personalRating;
    private final double avgFrags;
    private final int avgDMG;
    private final double avgShootDown;
    private final int maxFrags;
    private final int maxDMG;
    private final int maxShootDown;

    public Stats(int battles, double winRate, int personalRating, double avgFrags, int avgDMG, double avgShootDown, int maxFrags, int maxDMG, int maxShootDown) {
        this.battles = battles;
        this.winRate = winRate;
        this.personalRating = personalRating;
        this.avgFrags = avgFrags;
        this.avgDMG = avgDMG;
        this.avgShootDown = avgShootDown;
        this.maxFrags = maxFrags;
        this.maxDMG = maxDMG;
        this.maxShootDown = maxShootDown;
    }

    public int getBattles() {
        return battles;
    }

    public double getWinRate() {
        return winRate;
    }

    public int getPersonalRating() {
        return personalRating;
    }

    public double getAvgFrags() {
        return avgFrags;
    }

    public int getAvgDMG() {
        return avgDMG;
    }

    public double getAvgShootDown() {
        return avgShootDown;
    }

    public int getMaxFrags() {
        return maxFrags;
    }

    public int getMaxDMG() {
        return maxDMG;
    }

    public int getMaxShootDown() {
        return maxShootDown;
    }
}
