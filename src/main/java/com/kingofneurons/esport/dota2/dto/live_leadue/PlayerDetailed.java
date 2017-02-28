package com.kingofneurons.esport.dota2.dto.live_leadue;

public class PlayerDetailed {

    private int player_slot;
    private long account_id;
    private int hero_id;
    private int kills;
    private int death;
    private int assists;
    private int last_hits;
    private int denies;
    private int gold;
    private int level;
    private int gold_per_min;
    private int xp_per_min;
    private int ultimate_state;
    private int ultimate_cooldown;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int respawn_timer;
    private double position_x;
    private double position_y;
    private long net_worth;

    public int getPlayer_slot() {
        return player_slot;
    }

    public long getAccount_id() {
        return account_id;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getKills() {
        return kills;
    }

    public int getDeath() {
        return death;
    }

    public int getAssists() {
        return assists;
    }

    public int getLast_hits() {
        return last_hits;
    }

    public int getDenies() {
        return denies;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public int getUltimate_state() {
        return ultimate_state;
    }

    public int getUltimate_cooldown() {
        return ultimate_cooldown;
    }

    public int getItem0() {
        return item0;
    }

    public int getItem1() {
        return item1;
    }

    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem4() {
        return item4;
    }

    public int getItem5() {
        return item5;
    }

    public int getRespawn_timer() {
        return respawn_timer;
    }

    public double getPosition_x() {
        return position_x;
    }

    public double getPosition_y() {
        return position_y;
    }

    public long getNet_worth() {
        return net_worth;
    }

    @Override
    public String toString() {
        return "PlayerDetailed{" +
                "player_slot=" + player_slot +
                ", account_id=" + account_id +
                ", hero_id=" + hero_id +
                ", kills=" + kills +
                ", death=" + death +
                ", assists=" + assists +
                ", last_hits=" + last_hits +
                ", denies=" + denies +
                ", gold=" + gold +
                ", level=" + level +
                ", gold_per_min=" + gold_per_min +
                ", xp_per_min=" + xp_per_min +
                ", ultimate_state=" + ultimate_state +
                ", ultimate_cooldown=" + ultimate_cooldown +
                ", item0=" + item0 +
                ", item1=" + item1 +
                ", item2=" + item2 +
                ", item3=" + item3 +
                ", item4=" + item4 +
                ", item5=" + item5 +
                ", respawn_timer=" + respawn_timer +
                ", position_x=" + position_x +
                ", position_y=" + position_y +
                ", net_worth=" + net_worth +
                '}';
    }
}
