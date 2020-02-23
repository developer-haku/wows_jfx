package dev.haku.wows.model;

public class WeaponStats {
    private final String weaponType;
    private final int totalFrags;
    private final double hitRatio;
    private final int maxKillNumber;
    private final String maxKillShip;

    public WeaponStats(String weaponType, int totalFrags, double hitRatio, int maxKillNumber, String maxKillShip) {
        this.weaponType = weaponType;
        this.totalFrags = totalFrags;
        this.hitRatio = hitRatio;
        this.maxKillNumber = maxKillNumber;
        this.maxKillShip = maxKillShip;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getTotalFrags() {
        return totalFrags;
    }

    public double getHitRatio() {
        return hitRatio;
    }

    public int getMaxKillNumber() {
        return maxKillNumber;
    }

    public String getMaxKillShip() {
        return maxKillShip;
    }
}
