package com.kingofneurons.esport.dota2.dto.player_summaries;


public class Player {

     private transient int account_id;
    private transient boolean boolFullInfo;
    private transient String realPhoto;
    private transient int rating;

    private String steamid;
    private int communityvisibilitystate;
    private int profilestate;
   private String personaname;
    private String lastlogoff;
    private int commentpermission;
    private String profileurl;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private int personastate;
     private String realname;
    private long timecreated;
    private String loccountrycode;

    public Player(int account_id, String personaname) {
        this.account_id = account_id;
        this.personaname = personaname;
        this.boolFullInfo = false;
    }
    
    public Player() {}

    public String getSteamid() {
        return steamid;
    }

    public int getCommunityvisibilitystate() {
        return communityvisibilitystate;
    }

    public int getProfilestate() {
        return profilestate;
    }

    public String getPersonaname() {
        return personaname;
    }

    public String getLastlogoff() {
        return lastlogoff;
    }

    public int getCommentpermission() {
        return commentpermission;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public String getRealPhoto() {
        return realPhoto;
    }

    public int getPersonastate() {
        return personastate;
    }

    public String getRealname() {
        return realname;
    }

    public long getTimecreated() {
        return timecreated;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public boolean isBoolfullInfo() {
        return boolFullInfo;
    }

    public void setBoolfullInfo(boolean boolFullInfo) {
        this.boolFullInfo = boolFullInfo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "account_id=" + account_id +
                ", boolFullInfo=" + boolFullInfo +
                ", steamid='" + steamid + '\'' +
                ", communityvisibilitystate=" + communityvisibilitystate +
                ", profilestate=" + profilestate +
                ", personaname='" + personaname + '\'' +
                ", lastlogoff='" + lastlogoff + '\'' +
                ", commentpermission=" + commentpermission +
                ", profileurl='" + profileurl + '\'' +
                ", avatar='" + avatar + '\'' +
                ", avatarmedium='" + avatarmedium + '\'' +
                ", avatarfull='" + avatarfull + '\'' +
                ", personastate=" + personastate +
                ", realname='" + realname + '\'' +
                ", timecreated=" + timecreated +
                ", loccountrycode='" + loccountrycode + '\'' +
                ", realPhoto='" + realPhoto + '\'' +
                '}';
    }
}
