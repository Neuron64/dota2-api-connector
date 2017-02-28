package com.kingofneurons.esport.dota2.dto.live_leadue;

public class Team {

    private transient String team_url_logo;

    private String team_name;
    private long team_id;
    private String team_logo;
    private boolean complete;

    public String getTeam_name() {
        return team_name;
    }

    public long getTeam_id() {
        return team_id;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public boolean isComplete() {
        return complete;
    }

    public String getTeam_url_logo() {
        return team_url_logo;
    }

    public void setTeam_url_logo(String team_url_logo) {
        this.team_url_logo = team_url_logo;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_name='" + team_name + '\'' +
                ", team_id=" + team_id +
                ", team_logo='" + team_logo + '\'' +
                ", complete=" + complete +
                ", team_url_logo='" + team_url_logo + '\'' +
                '}';
    }
}
