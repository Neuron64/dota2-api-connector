package com.kingofneurons.esport.dota2.dto.team_info;


import java.util.List;

public class Team {

    private transient long team_id;
    private transient boolean boolFullInfo;
    private transient String team_logo;
    private transient int rating;

    private String name;
    private String tag;
    private long time_created;
    private int calibration_games_remaining;
    private String logo;
    private String logo_sponsor;
    private String country_code;
    private String url;
    private long games_played;
    private long admin_account_id;
    private List<Integer> league_id;
    private List<Long> player_account_id;

    public Team(String name,
                String tag,
                long time_created,
                int calibration_games_remaining,
                String logo, String logo_sponsor,
                String country_code,
                String url,
                long games_played,
                long admin_account_id,
                List<Integer> league_id,
                List<Long> player_account_id) {

        this.name = name;
        this.tag = tag;
        this.time_created = time_created;
        this.calibration_games_remaining = calibration_games_remaining;
        this.logo = logo;
        this.logo_sponsor = logo_sponsor;
        this.country_code = country_code;
        this.url = url;
        this.games_played = games_played;
        this.admin_account_id = admin_account_id;
        this.league_id = league_id;
        this.player_account_id = player_account_id;
    }

    public Team(long team_id, String name, String logo) {
        this.team_id = team_id;
        this.boolFullInfo = false;
        this.name = name;
        this.logo = logo;
    }

    public Team(long team_id){
        this.team_id = team_id;
    }

    public Team() {}

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public long getTime_created() {
        return time_created;
    }

    public int getCalibration_games_remaining() {
        return calibration_games_remaining;
    }

    public String getLogo() {
        return logo;
    }

    public String getLogo_sponsor() {
        return logo_sponsor;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getUrl() {
        return url;
    }

    public long getGames_played() {
        return games_played;
    }

    public long getAdmin_account_id() {
        return admin_account_id;
    }

    public List<Integer> getLeague_id() {
        return league_id;
    }

    public List<Long> getPlayer_account_id() {
        return player_account_id;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public boolean isBoolFullInfo() {
        return boolFullInfo;
    }

    public void setBoolFullInfo(boolean boolFullInfo) {
        this.boolFullInfo = boolFullInfo;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public void setTeam_logo(String team_logo) {
        this.team_logo = team_logo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", boolFullInfo=" + boolFullInfo +
                ", team_logo='" + team_logo + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", time_created=" + time_created +
                ", calibration_games_remaining=" + calibration_games_remaining +
                ", logo='" + logo + '\'' +
                ", logo_sponsor='" + logo_sponsor + '\'' +
                ", country_code='" + country_code + '\'' +
                ", url='" + url + '\'' +
                ", games_played=" + games_played +
                ", admin_account_id=" + admin_account_id +
                ", league_id=" + league_id +
                ", player_account_id=" + player_account_id +
                '}';
    }
}
