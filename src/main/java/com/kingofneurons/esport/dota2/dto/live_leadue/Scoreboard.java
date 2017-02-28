package com.kingofneurons.esport.dota2.dto.live_leadue;

public class Scoreboard {

    private Double duration;
    private long roshan_respawn_timer;
    private TeamStatistics radiant;
    private TeamStatistics dire;

    public Double getDuration() {
        return duration;
    }

    public long getRoshan_respawn_timer() {
        return roshan_respawn_timer;
    }

    public TeamStatistics getRadiant() {
        return radiant;
    }

    public TeamStatistics getDire() {
        return dire;
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "duration=" + duration +
                ", roshan_respawn_timer=" + roshan_respawn_timer +
                ", radiant=" + radiant +
                ", dire=" + dire +
                '}';
    }
}
