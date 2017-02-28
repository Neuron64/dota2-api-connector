package com.kingofneurons.esport.dota2.dto.live_leadue;

import java.util.List;

public class Games {

    private List<LiveLeague> games;

    public List<LiveLeague> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Games{" +
                "games=" + games +
                '}';
    }
}
