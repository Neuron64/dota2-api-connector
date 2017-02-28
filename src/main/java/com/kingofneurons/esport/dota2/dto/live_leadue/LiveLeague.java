package com.kingofneurons.esport.dota2.dto.live_leadue;


import java.util.Date;
import java.util.List;

public class LiveLeague {

     private long match_id;
    private String lobby_id;
    private int spectators;
    private int series_id;
    private int game_number;
    private int league_id;
    private int stream_delay_s;
    private int radiant_series_wins;
    private int dire_series_wins;
    private int series_type;
    private int league_series_id;
    private int league_game_id;
    private String stage_name;
    private int league_tier;
    private Team radiant_team;
    private Team dire_team;
    private Scoreboard scoreboard;

    private List<Player> players;

    private transient Date updateTime;

    public String getLobby_id() {
        return lobby_id;
    }

    public long getMatch_id() {
        return match_id;
    }

    public int getSpectators() {
        return spectators;
    }

    public int getSeries_id() {
        return series_id;
    }

    public int getGame_number() {
        return game_number;
    }

    public int getLeague_id() {
        return league_id;
    }

    public int getStream_delay_s() {
        return stream_delay_s;
    }

    public int getRadiant_series_wins() {
        return radiant_series_wins;
    }

    public int getDire_series_wins() {
        return dire_series_wins;
    }

    public int getSeries_type() {
        return series_type;
    }

    public int getLeague_series_id() {
        return league_series_id;
    }

    public int getLeague_game_id() {
        return league_game_id;
    }

    public String getStage_name() {
        return stage_name;
    }

    public int getLeague_tier() {
        return league_tier;
    }

    public Team getRadiant_team() {
        return radiant_team;
    }

    public Team getDire_team() {
        return dire_team;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "LiveLeague{" +
                "lobby_id='" + lobby_id + '\'' +
                ", match_id=" + match_id +
                ", spectators=" + spectators +
                ", series_id=" + series_id +
                ", game_number=" + game_number +
                ", league_id=" + league_id +
                ", stream_delay_s=" + stream_delay_s +
                ", radiant_series_wins=" + radiant_series_wins +
                ", dire_series_wins=" + dire_series_wins +
                ", series_type=" + series_type +
                ", league_series_id=" + league_series_id +
                ", league_game_id=" + league_game_id +
                ", stage_name='" + stage_name + '\'' +
                ", league_tier=" + league_tier +
                ", radiant_team=" + radiant_team +
                ", dire_team=" + dire_team +
                ", scoreboard=" + scoreboard +
                ", players=" + players +
                ", updateTime=" + updateTime +
                '}';
    }
}
