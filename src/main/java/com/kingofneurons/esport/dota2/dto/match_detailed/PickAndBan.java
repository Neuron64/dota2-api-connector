package com.kingofneurons.esport.dota2.dto.match_detailed;

public class PickAndBan {

    private boolean is_pick;
    private int hero_id;
    private int team;
    private int order;

    public boolean getIs_pick() {
        return is_pick;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getTeam() {
        return team;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "PickAndBan{" +
                "is_pick=" + is_pick +
                ", hero_id=" + hero_id +
                ", team=" + team +
                ", order=" + order +
                '}';
    }
}
