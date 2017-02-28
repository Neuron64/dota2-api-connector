package com.kingofneurons.esport.dota2.dto.live_leadue;

public class Player {

    private long account_id;
    private String name;
    private int hero_id;
    private int team;

    public long getAccount_id() {
        return account_id;
    }

    public String getName() {
        return name;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "PlayerDetailed{" +
                "account_id=" + account_id +
                ", name='" + name + '\'' +
                ", hero_id=" + hero_id +
                ", team=" + team +
                '}';
    }
}
