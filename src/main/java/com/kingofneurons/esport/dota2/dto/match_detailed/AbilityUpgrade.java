package com.kingofneurons.esport.dota2.dto.match_detailed;

public class AbilityUpgrade {

    private int ability;
    private long time;
    private int level;

    public int getAbility() {
        return ability;
    }

    public long getTime() {
        return time;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "AbilityUpgrade{" +
                "ability=" + ability +
                ", time=" + time +
                ", level=" + level +
                '}';
    }
}
