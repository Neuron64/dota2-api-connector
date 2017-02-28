package com.kingofneurons.esport.dota2.dto.match_detailed;

import java.util.List;

public class PlayerDetailed {

    private Long account_id;
    private int player_slot;
    private int hero_id;
    private int item_0;
    private int item_1;
    private int item_2;
    private int item_3;
    private int item_4;
    private int item_5;
    private int kills;
    private int deaths;
    private int assists;
    private int leaver_status;
    private int last_hits;
    private int denies;
    private int gold_per_min;
    private int xp_per_min;
    private int level;
    private int gold;
    private int gold_spent;
    private int hero_damage;
    private int tower_damage;
    private int hero_healing;
    private List<AbilityUpgrade> ability_upgrades;

    public Long getAccount_id() {
        return account_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getItem_0() {
        return item_0;
    }

    public int getItem_1() {
        return item_1;
    }

    public int getItem_2() {
        return item_2;
    }

    public int getItem_3() {
        return item_3;
    }

    public int getItem_4() {
        return item_4;
    }

    public int getItem_5() {
        return item_5;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getLeaver_status() {
        return leaver_status;
    }

    public int getLast_hits() {
        return last_hits;
    }

    public int getDenies() {
        return denies;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public int getGold_spent() {
        return gold_spent;
    }

    public int getHero_damage() {
        return hero_damage;
    }

    public int getTower_damage() {
        return tower_damage;
    }

    public int getHero_healing() {
        return hero_healing;
    }

    public List<AbilityUpgrade> getAbility_upgrades() {
        return ability_upgrades;
    }

    @Override
    public String toString() {
        return "PlayerDetailed{" +
                "account_id=" + account_id +
                ", player_slot=" + player_slot +
                ", hero_id=" + hero_id +
                ", item_0=" + item_0 +
                ", item_1=" + item_1 +
                ", item_2=" + item_2 +
                ", item_3=" + item_3 +
                ", item_4=" + item_4 +
                ", item_5=" + item_5 +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", leaver_status=" + leaver_status +
                ", last_hits=" + last_hits +
                ", denies=" + denies +
                ", gold_per_min=" + gold_per_min +
                ", xp_per_min=" + xp_per_min +
                ", level=" + level +
                ", gold=" + gold +
                ", gold_spent=" + gold_spent +
                ", hero_damage=" + hero_damage +
                ", tower_damage=" + tower_damage +
                ", hero_healing=" + hero_healing +
                ", ability_upgrades=" + ability_upgrades +
                '}';
    }
}
