package com.kingofneurons.esport.dota2.dto.player_summaries;

import java.util.List;

public class PlayerSummaries {
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "player_summaries{" +
                "players=" + players +
                '}';
    }
}
