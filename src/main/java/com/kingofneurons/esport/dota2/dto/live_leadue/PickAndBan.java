package com.kingofneurons.esport.dota2.dto.live_leadue;

public class PickAndBan {

    private int hero_id;

    public int getHero_id() {
        return hero_id;
    }

    @Override
    public String toString() {
        return "PickAndBan{" +
                "hero_id=" + hero_id +
                '}';
    }
}
