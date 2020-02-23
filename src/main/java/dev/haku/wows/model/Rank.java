package dev.haku.wows.model;

public class Rank {
    private final String season;
    private final int rank;
    private final int bestRank;
    private final int battles;
    private final double winRate;

    public Rank(String season, int rank, int bestRank, int battles, double winRate) {
        this.season = season;
        this.rank = rank;
        this.bestRank = bestRank;
        this.battles = battles;
        this.winRate = winRate;
    }

    public String getSeason() {
        return season;
    }

    public int getRank() {
        return rank;
    }

    public int getBestRank() {
        return bestRank;
    }

    public int getBattles() {
        return battles;
    }

    public double getWinRate() {
        return winRate;
    }
}
