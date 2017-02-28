package com.kingofneurons.esport.dota2.dto.match_detailed;


import java.util.Date;
import java.util.List;

public class MatchDetailed {

    private long match_id;
    private boolean radiant_win;
    private long duration;
    private long pre_game_duration;
    private Date start_time;
    private long match_seq_num;
    private int tower_status_radiant;
    private int tower_status_dire;
    private int barracks_status_radiant;
    private int barracks_status_dire;
    private int cluster;
    private int first_blood_time;
    private int lobby_type;
    private int human_players;
    private int leagueid;
    private int positive_votes;
    private int negative_votes;
    private int game_mode;
    private int flags;
    private int engine;
    private int radiant_score;
    private int dire_score;
    private long radiant_team_id;
    private String radiant_name;
    private String radiant_logo;
    private int radiant_team_complete;
    private long dire_team_id;
    private String dire_name;
    private String dire_logo;
    private int dire_team_complete;
    private long radiant_captain;
    private long dire_captain;
    private List<PickAndBan> picks_bans;
    private List<PlayerDetailed> players;

    public void setPicks_bans(List<PickAndBan> picks_bans) {
        this.picks_bans = picks_bans;
    }

    public void setPlayers(List<PlayerDetailed> players) {
        this.players = players;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public long getDuration() {
        return duration;
    }

    public long getPre_game_duration() {
        return pre_game_duration;
    }

    public Date getStart_time() {
        return start_time;
    }

    public long getMatch_id() {
        return match_id;
    }

    public long getMatch_seq_num() {
        return match_seq_num;
    }

    public int getTower_status_radiant() {
        return tower_status_radiant;
    }

    public int getTower_status_dire() {
        return tower_status_dire;
    }

    public int getBarracks_status_radiant() {
        return barracks_status_radiant;
    }

    public int getBarracks_status_dire() {
        return barracks_status_dire;
    }

    public int getCluster() {
        return cluster;
    }

    public int getFirst_blood_time() {
        return first_blood_time;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public int getHuman_players() {
        return human_players;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public int getPositive_votes() {
        return positive_votes;
    }

    public int getNegative_votes() {
        return negative_votes;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public int getFlags() {
        return flags;
    }

    public int getEngine() {
        return engine;
    }

    public int getRadiant_score() {
        return radiant_score;
    }

    public int getDire_score() {
        return dire_score;
    }

    public long getRadiant_team_id() {
        return radiant_team_id;
    }

    public String getRadiant_name() {
        return radiant_name;
    }

    public String getRadiant_logo() {
        return radiant_logo;
    }

    public int getRadiant_team_complete() {
        return radiant_team_complete;
    }

    public long getDire_team_id() {
        return dire_team_id;
    }

    public String getDire_name() {
        return dire_name;
    }

    public String getDire_logo() {
        return dire_logo;
    }

    public int getDire_team_complete() {
        return dire_team_complete;
    }

    public long getRadiant_captain() {
        return radiant_captain;
    }

    public long getDire_captain() {
        return dire_captain;
    }

    public List<PickAndBan> getPicks_bans() {
        return picks_bans;
    }

    public List<PlayerDetailed> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "match_detailed{" +
                "radiant_win=" + radiant_win +
                ", duration=" + duration +
                ", pre_game_duration=" + pre_game_duration +
                ", start_time=" + start_time +
                ", match_id=" + match_id +
                ", match_seq_num=" + match_seq_num +
                ", tower_status_radiant=" + tower_status_radiant +
                ", tower_status_dire=" + tower_status_dire +
                ", barracks_status_radiant=" + barracks_status_radiant +
                ", barracks_status_dire=" + barracks_status_dire +
                ", cluster=" + cluster +
                ", first_blood_time=" + first_blood_time +
                ", lobby_type=" + lobby_type +
                ", human_players=" + human_players +
                ", leagueid=" + leagueid +
                ", positive_votes=" + positive_votes +
                ", negative_votes=" + negative_votes +
                ", game_mode=" + game_mode +
                ", flags=" + flags +
                ", engine=" + engine +
                ", radiant_score=" + radiant_score +
                ", dire_score=" + dire_score +
                ", radiant_team_id=" + radiant_team_id +
                ", radiant_name='" + radiant_name + '\'' +
                ", radiant_logo='" + radiant_logo + '\'' +
                ", radiant_team_complete=" + radiant_team_complete +
                ", dire_team_id=" + dire_team_id +
                ", dire_name='" + dire_name + '\'' +
                ", dire_logo='" + dire_logo + '\'' +
                ", dire_team_complete=" + dire_team_complete +
                ", radiant_captain=" + radiant_captain +
                ", dire_captain=" + dire_captain +
                ", picks_bans=" + picks_bans +
                ", players=" + players +
                '}';
    }
}
