package com.kingofneurons.esport.dota2.dto.match_history;

public class Player {

    private long account_id;
    private int player_slot;
    private int hero_id;

    public long getAccount_id() {
        return account_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public int getHero_id() {
        return hero_id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "account_id=" + account_id +
                ", player_slot=" + player_slot +
                ", hero_id=" + hero_id +
                '}';
    }
}
