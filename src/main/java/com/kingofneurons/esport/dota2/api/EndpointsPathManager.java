package com.kingofneurons.esport.dota2.api;

public class EndpointsPathManager {

    private String API_DOTA2_MATCH_DETAILS = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v001/";
    private String API_DOTA2_LEAGUE_LISTING = "https://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v0001/";
    private String API_DOTA2_LIVE_LEAGUE_GAMES = "https://api.steampowered.com/IDOTA2Match_570/GetLiveLeagueGames/v0001/";
    private String API_DOTA2_TEAM_INFO_BY_ID = "http://api.steampowered.com/IDOTA2Match_570/GetTeamInfoByTeamID/v1/";
    private String API_DOTA2_GAME_ITEMS = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/v0001/";
    private String API_DOTA2_GAME_HERO = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/";
    private String API_DOTA_PLAYER_SUMMARIES = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/";
    private String API_DOTA_STEAM_REMOTE_STORAGE = "http://api.steampowered.com/ISteamRemoteStorage/GetUGCFileDetails/v1/";
    private String API_DOTA_ITEM_ICON_PATH = "https://api.steampowered.com/IEconDOTA2_570/GetItemIconPath/v1/";
    private String API_DOTA2_MATCH_HISTORY = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1/";
    private String API_DOTA_SCHEMA = "https://raw.githubusercontent.com/dotabuff/d2vpkr/master/dota/scripts/items/items_game.json";

    public String getPathDota2MatchDetails() {
        return API_DOTA2_MATCH_DETAILS;
    }

    public void setDota2MatchDetails(String API_DOTA2_MATCH_DETAILS) {
        this.API_DOTA2_MATCH_DETAILS = API_DOTA2_MATCH_DETAILS;
    }

    public String getDota2LeagueListing() {
        return API_DOTA2_LEAGUE_LISTING;
    }

    public void setDota2LeagueListing(String API_DOTA2_LEAGUE_LISTING) {
        this.API_DOTA2_LEAGUE_LISTING = API_DOTA2_LEAGUE_LISTING;
    }

    public String getDota2LiveLeagueGames() {
        return API_DOTA2_LIVE_LEAGUE_GAMES;
    }

    public void setDota2LiveLeagueGames(String API_DOTA2_LIVE_LEAGUE_GAMES) {
        this.API_DOTA2_LIVE_LEAGUE_GAMES = API_DOTA2_LIVE_LEAGUE_GAMES;
    }

    public String getDota2TeamInfoById() {
        return API_DOTA2_TEAM_INFO_BY_ID;
    }

    public void setDota2TeamInfoById(String API_DOTA2_TEAM_INFO_BY_ID) {
        this.API_DOTA2_TEAM_INFO_BY_ID = API_DOTA2_TEAM_INFO_BY_ID;
    }

    public String getDota2GameItems() {
        return API_DOTA2_GAME_ITEMS;
    }

    public void setDota2GameItems(String API_DOTA2_GAME_ITEMS) {
        this.API_DOTA2_GAME_ITEMS = API_DOTA2_GAME_ITEMS;
    }

    public String getDota2GameHero() {
        return API_DOTA2_GAME_HERO;
    }

    public void setDota2GameHero(String API_DOTA2_GAME_HERO) {
        this.API_DOTA2_GAME_HERO = API_DOTA2_GAME_HERO;
    }

    public String getDotaPlayerSummaries() {
        return API_DOTA_PLAYER_SUMMARIES;
    }

    public void setDotaPlayerSummaries(String API_DOTA_PLAYER_SUMMARIES) {
        this.API_DOTA_PLAYER_SUMMARIES = API_DOTA_PLAYER_SUMMARIES;
    }

    public String getDotaSteamRemoteStorage() {
        return API_DOTA_STEAM_REMOTE_STORAGE;
    }

    public void setDotaSteamRemoteStorage(String API_DOTA_STEAM_REMOTE_STORAGE) {
        this.API_DOTA_STEAM_REMOTE_STORAGE = API_DOTA_STEAM_REMOTE_STORAGE;
    }

    public String getDotaItemIconPath() {
        return API_DOTA_ITEM_ICON_PATH;
    }

    public void setDotaItemIconPath(String API_DOTA_ITEM_ICON_PATH) {
        this.API_DOTA_ITEM_ICON_PATH = API_DOTA_ITEM_ICON_PATH;
    }

    public String getDota2MatchHistory() {
        return API_DOTA2_MATCH_HISTORY;
    }

    public void setDota2MatchHistory(String API_DOTA2_MATCH_HISTORY) {
        this.API_DOTA2_MATCH_HISTORY = API_DOTA2_MATCH_HISTORY;
    }

    public String getDotaSchema() {
        return API_DOTA_SCHEMA;
    }

    public void setDotaSchema(String API_DOTA_SCHEMA) {
        this.API_DOTA_SCHEMA = API_DOTA_SCHEMA;
    }
}
