package com.kingofneurons.esport.dota2.dto.live_leadue;

public class Abilities {

    private int ability_id;
    private int ability_level;

    public int getAbility_id() {
        return ability_id;
    }

    public int getAbility_level() {
        return ability_level;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "ability_id=" + ability_id +
                ", ability_level=" + ability_level +
                '}';
    }
}
