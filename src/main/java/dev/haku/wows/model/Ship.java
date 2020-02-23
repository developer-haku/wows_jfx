package dev.haku.wows.model;

public class Ship {
    private final String name;
    private final String tier;
    private final boolean isPremium;
    private final boolean isSteel;

    public Ship(String name, String tier, boolean isPremium, boolean isSteel) {
        this.name = name;
        this.tier = tier;
        this.isPremium = isPremium;
        this.isSteel = isSteel;
    }

    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isSteel() {
        return isSteel;
    }
}
