package com.kingofneurons.esport.dota2.dto.live_leadue;

import java.util.List;

public class TeamStatistics {

    private int score;
    private int tower_state;
    private int barracks_state;
    private List<PickAndBan> picks;
    private List<PickAndBan> bans;
    private List<PlayerDetailed> players;
    private List<Abilities> abilities;

    public int getScore() {
        return score;
    }

    public int getTower_state() {
        return tower_state;
    }

    public int getBarracks_state() {
        return barracks_state;
    }

    public List<PickAndBan> getPicks() {
        return picks;
    }

    public List<PickAndBan> getBans() {
        return bans;
    }

    public List<PlayerDetailed> getPlayers() {
        return players;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "TeamStatistics{" +
                "score=" + score +
                ", tower_state=" + tower_state +
                ", barracks_state=" + barracks_state +
                ", picks=" + picks +
                ", bans=" + bans +
                ", players=" + players +
                ", abilities=" + abilities +
                '}';
    }
}
