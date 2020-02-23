package dev.haku.wows.model;

import java.util.List;

public class Player {
    private int playerID;
    private String playerName;
    private String clan;

    private int battles;
    private double winRate;
    private int personalRating;
    private double battlesSurvived;

    private int avgDMG;
    private double avgFrags;
    private double avgShootDown;
    private int avgEXP;
    private double avgKD;
    private double avgSpot;
    private int avgSpotDMG;
    private double avgTier;

    private List<ShipTypeStats> shipTypeStats;
    private List<ShipTierStats> shipTierStats;
    private List<WeaponStats> weaponStats;
    private List<Record> records;
    private List<ImportantMoment> importantMoments;
    private List<OnlineRecord> onlineHistory;
    private List<ShipStats> shipStats;
    private List<Rank> rankHistory;

    public Player() {
    }

    public Player(int playerID, String playerName, String clan, int battles, double winRate, int personalRating, double battlesSurvived, int avgDMG, double avgFrags, double avgShootDown, int avgEXP, double avgKD, double avgSpot, int avgSpotDMG, double avgTier, List<ShipTypeStats> shipTypeStats, List<ShipTierStats> shipTierStats, List<WeaponStats> weaponStats, List<Record> records, List<ImportantMoment> importantMoments, List<OnlineRecord> onlineHistory, List<ShipStats> shipStats, List<Rank> rankHistory) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.clan = clan;
        this.battles = battles;
        this.winRate = winRate;
        this.personalRating = personalRating;
        this.battlesSurvived = battlesSurvived;
        this.avgDMG = avgDMG;
        this.avgFrags = avgFrags;
        this.avgShootDown = avgShootDown;
        this.avgEXP = avgEXP;
        this.avgKD = avgKD;
        this.avgSpot = avgSpot;
        this.avgSpotDMG = avgSpotDMG;
        this.avgTier = avgTier;
        this.shipTypeStats = shipTypeStats;
        this.shipTierStats = shipTierStats;
        this.weaponStats = weaponStats;
        this.records = records;
        this.importantMoments = importantMoments;
        this.onlineHistory = onlineHistory;
        this.shipStats = shipStats;
        this.rankHistory = rankHistory;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public int getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(int personalRating) {
        this.personalRating = personalRating;
    }

    public double getBattlesSurvived() {
        return battlesSurvived;
    }

    public void setBattlesSurvived(double battlesSurvived) {
        this.battlesSurvived = battlesSurvived;
    }

    public int getAvgDMG() {
        return avgDMG;
    }

    public void setAvgDMG(int avgDMG) {
        this.avgDMG = avgDMG;
    }

    public double getAvgFrags() {
        return avgFrags;
    }

    public void setAvgFrags(double avgFrags) {
        this.avgFrags = avgFrags;
    }

    public double getAvgShootDown() {
        return avgShootDown;
    }

    public void setAvgShootDown(double avgShootDown) {
        this.avgShootDown = avgShootDown;
    }

    public int getAvgEXP() {
        return avgEXP;
    }

    public void setAvgEXP(int avgEXP) {
        this.avgEXP = avgEXP;
    }

    public double getAvgKD() {
        return avgKD;
    }

    public void setAvgKD(double avgKD) {
        this.avgKD = avgKD;
    }

    public double getAvgSpot() {
        return avgSpot;
    }

    public void setAvgSpot(double avgSpot) {
        this.avgSpot = avgSpot;
    }

    public int getAvgSpotDMG() {
        return avgSpotDMG;
    }

    public void setAvgSpotDMG(int avgSpotDMG) {
        this.avgSpotDMG = avgSpotDMG;
    }

    public double getAvgTier() {
        return avgTier;
    }

    public void setAvgTier(double avgTier) {
        this.avgTier = avgTier;
    }

    public List<ShipTypeStats> getShipTypeStats() {
        return shipTypeStats;
    }

    public void setShipTypeStats(List<ShipTypeStats> shipTypeStats) {
        this.shipTypeStats = shipTypeStats;
    }

    public List<ShipTierStats> getShipTierStats() {
        return shipTierStats;
    }

    public void setShipTierStats(List<ShipTierStats> shipTierStats) {
        this.shipTierStats = shipTierStats;
    }

    public List<WeaponStats> getWeaponStats() {
        return weaponStats;
    }

    public void setWeaponStats(List<WeaponStats> weaponStats) {
        this.weaponStats = weaponStats;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<ImportantMoment> getImportantMoments() {
        return importantMoments;
    }

    public void setImportantMoments(List<ImportantMoment> importantMoments) {
        this.importantMoments = importantMoments;
    }

    public List<OnlineRecord> getOnlineHistory() {
        return onlineHistory;
    }

    public void setOnlineHistory(List<OnlineRecord> onlineHistory) {
        this.onlineHistory = onlineHistory;
    }

    public List<ShipStats> getShipStats() {
        return shipStats;
    }

    public void setShipStats(List<ShipStats> shipStats) {
        this.shipStats = shipStats;
    }

    public List<Rank> getRankHistory() {
        return rankHistory;
    }

    public void setRankHistory(List<Rank> rankHistory) {
        this.rankHistory = rankHistory;
    }

    @Override
    public String toString() {
        return "Player{" + '\n' +
                "\tplayerID=" + playerID + '\n' +
                "\tplayerName='" + playerName + '\'' + '\n' +
                "\tclan='" + clan + '\'' + '\n' +
                "\tbattles=" + battles + '\n' +
                "\twinRate=" + winRate + '\n' +
                "\tpersonalRating=" + personalRating + '\n' +
                "\tbattlesSurvived=" + battlesSurvived + '\n' +
                "\tavgDMG=" + avgDMG + '\n' +
                "\tavgFrags=" + avgFrags + '\n' +
                "\tavgShootDown=" + avgShootDown + '\n' +
                "\tavgEXP=" + avgEXP + '\n' +
                "\tavgKD=" + avgKD + '\n' +
                "\tavgSpot=" + avgSpot + '\n' +
                "\tavgSpotDMG=" + avgSpotDMG + '\n' +
                "\tavgTier=" + avgTier + '\n' +
                "\tshipTypeStats=" + shipTypeStats + '\n' +
                "\tshipTierStats=" + shipTierStats + '\n' +
                "\tweaponStats=" + weaponStats + '\n' +
                "\trecords=" + records + '\n' +
                "\timportantMoments=" + importantMoments + '\n' +
                "\tonlineHistory=" + onlineHistory + '\n' +
                "\tshipStats=" + shipStats + '\n' +
                "\trankHistory=" + rankHistory + '\n' +
                '}';
    }
}
