package com.kingofneurons.esport.dota2.dto.league;

import java.util.List;

public class Leagues {

    private List<League> leagues;

    public List<League> getLeagues() {
        return leagues;
    }

    @Override
    public String toString() {
        return "Leagues{" +
                "leagues=" + leagues +
                '}';
    }
}
