package com.kingofneurons.esport.dota2.dto.match_history;

import java.util.List;

public class Match {

    private long series_id;
    private int series_type;
    private long match_id;
    private long match_seq_num;
    private long start_time;
    private int lobby_type;
    private long radiant_team_id;
    private long dire_team_id;
    private List<Player> players;

    public long getSeries_id() {
        return series_id;
    }

    public int getSeries_type() {
        return series_type;
    }

    public long getMatch_id() {
        return match_id;
    }

    public long getMatch_seq_num() {
        return match_seq_num;
    }

    public long getStart_time() {
        return start_time;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public long getRadiant_team_id() {
        return radiant_team_id;
    }

    public long getDire_team_id() {
        return dire_team_id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Match{" +
                "series_id=" + series_id +
                ", series_type=" + series_type +
                ", match_id=" + match_id +
                ", match_seq_num=" + match_seq_num +
                ", start_time=" + start_time +
                ", lobby_type=" + lobby_type +
                ", radiant_team_id=" + radiant_team_id +
                ", dire_team_id=" + dire_team_id +
                ", players=" + players +
                '}';
    }
}
