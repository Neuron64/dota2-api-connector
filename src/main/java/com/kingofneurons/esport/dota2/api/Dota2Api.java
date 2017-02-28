/*
 * Copyright 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kingofneurons.esport.dota2.api;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.kingofneurons.esport.dota2.api.Deserialize.team_info.DeserializeDate;
import com.kingofneurons.esport.dota2.api.Deserialize.team_info.DeserializeTeam;
import com.kingofneurons.esport.dota2.api.Filter.MatchHistoryFilter;
import com.kingofneurons.esport.dota2.api.Filter.QueryFilter;
import com.kingofneurons.esport.dota2.dto.Data;
import com.kingofneurons.esport.dota2.dto.Response;
import com.kingofneurons.esport.dota2.dto.Result;
import com.kingofneurons.esport.dota2.dto.game_hero.Hero;
import com.kingofneurons.esport.dota2.dto.game_hero.Heroes;
import com.kingofneurons.esport.dota2.dto.game_items.Item;
import com.kingofneurons.esport.dota2.dto.game_items.Items;
import com.kingofneurons.esport.dota2.dto.item_icon_path.Path;
import com.kingofneurons.esport.dota2.dto.league.League;
import com.kingofneurons.esport.dota2.dto.league.Leagues;
import com.kingofneurons.esport.dota2.dto.live_leadue.Games;
import com.kingofneurons.esport.dota2.dto.live_leadue.LiveLeague;
import com.kingofneurons.esport.dota2.dto.match_detailed.MatchDetailed;
import com.kingofneurons.esport.dota2.dto.match_history.Match;
import com.kingofneurons.esport.dota2.dto.match_history.MatchHistory;
import com.kingofneurons.esport.dota2.dto.player_summaries.Player;
import com.kingofneurons.esport.dota2.dto.player_summaries.PlayerSummaries;
import com.kingofneurons.esport.dota2.dto.schema.SchemaPath;
import com.kingofneurons.esport.dota2.dto.steam_remote_storage.SteamRemoteStorage;
import com.kingofneurons.esport.dota2.dto.team_info.Team;
import com.kingofneurons.esport.dota2.util.Convert;
import com.kingofneurons.esport.dota2.util.DownloadJson;
import com.kingofneurons.esport.dota2.util.LoadResourceDota2;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @version 1.0.0 alpha
 */
public class Dota2Api {

    private static Logger log = Logger.getLogger(Dota2Api.class.getName());

    private String API_DOTA2_KEY = "YOUR-API-KEY-HERE";

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


    public Dota2Api(String apiDota2Key) {
        API_DOTA2_KEY = apiDota2Key;
    }

    /**
     * Получаем детали матча.
     */
    @SuppressWarnings("unchecked")
    public MatchDetailed getMatchDetailed(long idMatch) throws Exception {
        String apiUrl = API_DOTA2_MATCH_DETAILS
                + "?key=" + API_DOTA2_KEY +
                "&match_id=" + idMatch;
        Type type = new TypeToken<Result<MatchDetailed>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DeserializeDate()).create();

        return ((Result<MatchDetailed>) gson.fromJson(DownloadJson.readUrl(apiUrl), type)).getResult();
    }

    /**
     * Получаем весь список турниров.
     */
    @SuppressWarnings("unchecked")
    public List<League> getLeagueListing() throws Exception {
        String apiUrl = API_DOTA2_LEAGUE_LISTING
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Leagues>>(){}.getType();
        return ((Result<Leagues>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getLeagues();
    }

    /**
     * Получаем текущие турнирные игры и их детальную стастистику.
     */
    @SuppressWarnings("unchecked")
    public List<LiveLeague> getLiveLeague() throws Exception {
        String apiUrl = API_DOTA2_LIVE_LEAGUE_GAMES
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Games>>(){}.getType();
        return ((Result<Games>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getGames();
    }

    /**
     * Получаем информацию о команде.
     */
    @SuppressWarnings("unchecked")
    public Team getTeamInfoByID(long idTeam) throws Exception {
        String apiUrl = API_DOTA2_TEAM_INFO_BY_ID
                + "?key=" + API_DOTA2_KEY
                + "&start_at_team_id=" + idTeam
                + "&teams_requested=1";
        Type type = new TypeToken<Result<Team>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(Team.class, new DeserializeTeam()).create();
        return ((Result<Team>) gson.fromJson(DownloadJson.readUrl(apiUrl), type)).getResult();
    }

    /**
     * Получаем список предметов Доты2.
     */
    @SuppressWarnings("unchecked")
    public List<Item> getGameItems() throws Exception {
        String apiUrl = API_DOTA2_GAME_ITEMS
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Items>>(){}.getType();
        return ((Result<Items>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getItems();
    }

    /**
     * Получаем список героев Доты2.
     */
    @SuppressWarnings("unchecked")
    public List<Hero> getGameHero() throws Exception {
        String apiUrl = API_DOTA2_GAME_HERO
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Heroes>>(){}.getType();
        return ((Result<Heroes>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getHeroes();
    }

    /**
     * Получаем информацию о игроке.
     */
    @SuppressWarnings("unchecked")
    public Player getPlayerSummaries(int player32Id) throws Exception {
        String apiUrl = API_DOTA_PLAYER_SUMMARIES
                + "?key=" + API_DOTA2_KEY
                + "&steamids=" + Convert.convert32To64(player32Id);
        Type type = new TypeToken<Response<PlayerSummaries>>(){}.getType();
        return ((Response<PlayerSummaries>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResponse().getPlayers().get(0);
    }

    /**
     * Получаем ссылку по ugcid из хранилища стима для картинок.
     * Можно использовать для:
     * team_logo_id
     */
    @SuppressWarnings("unchecked")
    public SteamRemoteStorage getSteamRemoteStorage(String id) throws Exception {
        String apiUrl = API_DOTA_STEAM_REMOTE_STORAGE
                + "?key=" + API_DOTA2_KEY
                + "&appid=" + 570
                + "&ugcid=" + id;
        Type type = new TypeToken<Data<SteamRemoteStorage>>(){}.getType();
        return ((Data<SteamRemoteStorage>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getData();
    }

    /**
     * json page from github.com/dotabuff/d2vpkr
     * TODO: Change the page to api.steampowered.com/IEconItems_570/GetSchemaURL/v1/ and and make parser to Json.
     * TODO: Переместить на постоянное хранение в ресурсы.
     * Получаем карту объектов Доты2.(Использовать аккуратно: файл весит > 20мб)
     */
    @SuppressWarnings("unchecked")
    public String getSchema() throws Exception {
        return DownloadJson.readUrl(API_DOTA_SCHEMA);
    }

    /**
     * Получаем пропарсенный Map из объектов Доты2.
     */
    @SuppressWarnings("unchecked")
    public Map<String, JsonObject> getItemsSchema() throws Exception {
        Type type = new TypeToken<SchemaPath>(){}.getType();
        SchemaPath schemaPath = new Gson().fromJson(getSchema(), type);
        return schemaPath.getItems_game().getItems();
    }

    /**
     * Получаем ссылку на картинку по description из schema.
     */
    @SuppressWarnings("unchecked")
    public String getItemIconPath(String iconName) throws Exception {
        String apiUrl = API_DOTA_ITEM_ICON_PATH
                + "?key=" + API_DOTA2_KEY
                + "&format=json"
                + "&iconname=" + iconName;
        Type type = new TypeToken<Result<Path>>(){}.getType();
        return "http://cdn.dota2.com/apps/570/" + ((Result<Path>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getPath();
    }

    /**
     * Получаем коллекцию ссылок логотопов турниров.
     */
    @SuppressWarnings("unchecked")
    public List<League> getUrlLogoLeague(List<League> leagueList) throws Exception {
        Map<String, JsonObject> map = getItemsSchema();

        for(League league : leagueList){
            try {
                league.setUrlLogo(getItemIconPath(getPathTournamentLogo(map.get(String.valueOf(league.getItemdef())))));
            }catch (Exception e){
                league.setUrlLogo(null);
            }
        }
        return leagueList;
    }

    /**
     * Получаем Map ссылок логотопов турниров .
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, String> getUrlLogoLeague(int... itemDef) throws Exception {
        Map<String, JsonObject> map = getItemsSchema();
        Map<Integer, String> icons = new HashMap<Integer, String>();

        for(int id : itemDef){
            try {
                icons.put(id, getItemIconPath(getPathTournamentLogo(map.get(String.valueOf(id)))));
            }catch (Exception e){
                icons.put(id, null);
            }
        }
        return icons;
    }

    /**
     * Получаем Map описаний логотипов для дальнейшего получения ссылок на них.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, String> getPathLeagueLogo(int[] itemsDef) throws Exception {
        Map<String, JsonObject> map = getItemsSchema();
        Map<Integer, String> icons = new HashMap<Integer, String>();

        for(int id : itemsDef){
            try {
                icons.put(id, getPathTournamentLogo(map.get(String.valueOf(id))));
            }catch (Exception e){
                icons.put(id, null);
            }
        }
        return icons;
    }

    /**
     * TODO: Add error, status and lobby_type response from Valve
     * Получаем недетальный список истории матчей.
     */
    @SuppressWarnings("unchecked")
    public List<Match> getMatchHistory(MatchHistoryFilter filter) throws Exception {
        String apiUrl = API_DOTA2_MATCH_HISTORY
                + "?key=" + API_DOTA2_KEY
                + new QueryFilter().buildFilterHistoryMatch(filter);

        Type type = new TypeToken<Result<MatchHistory>>(){}.getType();
        return ((Result<MatchHistory>) new Gson().fromJson(DownloadJson.readUrl(apiUrl), type)).getResult().getMatches();
    }

    /**
     * Получаем картинки Доты2.
     * ID:{
     * ID_DOWNLOAD_MINMAP = 1
     * ID_DOWNLOAD_ITEMS_IMAGE = 2
     * ID_DOWNLOAD_HERO_IMAGE = 3
     * ID_DOWNLOAD_ABILITIES_IMAGE = 4
     * }
     * Patch : путь куда сохранять картинки.
     */
    @SuppressWarnings("unchecked")
    public void loadResourceDota2(int id, String path) throws Exception {
        new LoadResourceDota2(id, path).run();
    }

    public void setDota2Key(String apiDota2Key){
        API_DOTA2_KEY = apiDota2Key;
    }

    private String getPathTournamentLogo(JsonObject object) {
        return object.get("image_inventory")
                .getAsString()
                .replace("econ/leagues/", "")
                .replace("econ/tools/", "");
    }
}
