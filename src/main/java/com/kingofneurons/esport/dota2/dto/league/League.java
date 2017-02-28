package com.kingofneurons.esport.dota2.dto.league;


public class League {

     private String name;
     private int leagueid;
    private String description;
    private String tournament_url;
    private int itemdef;
    private transient String urlLogo;
    /* 2 - topLvl, 1 - medium, 0 - don't read and write*/
    private transient int rating;

    public String getName() {
        return name;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public String getDescription() {
        return description;
    }

    public String getTournament_url() {
        return tournament_url;
    }

    public int getItemdef() {
        return itemdef;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeagueid(int leagueid) {
        this.leagueid = leagueid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTournament_url(String tournament_url) {
        this.tournament_url = tournament_url;
    }

    public void setItemdef(int itemdef) {
        this.itemdef = itemdef;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", leagueid=" + leagueid +
                ", description='" + description + '\'' +
                ", tournament_url='" + tournament_url + '\'' +
                ", itemdef=" + itemdef +
                ", urlLogo='" + urlLogo + '\'' +
                ", rating=" + rating +
                '}';
    }
}
