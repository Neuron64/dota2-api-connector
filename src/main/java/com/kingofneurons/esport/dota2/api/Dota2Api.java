/*
 * Copyright 2016 Neuron64
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
import com.kingofneurons.esport.dota2.api.Filter.QueueFilter;
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
import java.util.*;
import java.util.logging.Logger;

public class Dota2Api {

    private static Logger log = Logger.getLogger(Dota2Api.class.getName());

    private String API_DOTA2_KEY = null;

    private BlockingQueueSteamApi queueSteamApi;
    private EndpointsPathManager endpointsPathManager;

    public Dota2Api(String apiDota2Key) {
        Objects.requireNonNull(apiDota2Key);

        API_DOTA2_KEY = apiDota2Key;
        this.queueSteamApi = new BlockingQueueSteamApi(new QueueFilter());
        this.endpointsPathManager = new EndpointsPathManager();
    }

    public Dota2Api(String apiDota2Key, QueueFilter queryFilter) {
        Objects.requireNonNull(queryFilter);
        Objects.requireNonNull(apiDota2Key);

        API_DOTA2_KEY = apiDota2Key;
        this.queueSteamApi = new BlockingQueueSteamApi(queryFilter);
        this.endpointsPathManager = new EndpointsPathManager();
    }

    public Dota2Api(String apiDota2Key, QueueFilter queryFilter, EndpointsPathManager endpointsPathManager) {
        Objects.requireNonNull(queryFilter);
        Objects.requireNonNull(apiDota2Key);
        Objects.requireNonNull(endpointsPathManager);

        API_DOTA2_KEY = apiDota2Key;
        this.endpointsPathManager = endpointsPathManager;
        this.queueSteamApi = new BlockingQueueSteamApi(queryFilter);
    }

    /**
     * Get the details the match.
     */
    @SuppressWarnings("unchecked")
    public MatchDetailed getMatchDetailed(long idMatch) throws Exception {
        String apiUrl = endpointsPathManager.getPathDota2MatchDetails()
                + "?key=" + API_DOTA2_KEY +
                "&match_id=" + idMatch;
        Type type = new TypeToken<Result<MatchDetailed>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DeserializeDate()).create();

        return ((Result<MatchDetailed>) gson.fromJson(queueSteamApi.getJson(apiUrl), type)).getResult();
    }

    /**
     * Get the full list of tournaments.
     */
    @SuppressWarnings("unchecked")
    public List<League> getLeagueListing() throws Exception {
        String apiUrl = endpointsPathManager.getDota2LeagueListing()
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Leagues>>(){}.getType();
        return ((Result<Leagues>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getLeagues();
    }

    /**
     * Get the current tournaments games and detailed statistics.
     */
    @SuppressWarnings("unchecked")
    public List<LiveLeague> getLiveLeague() throws Exception {
        String apiUrl = endpointsPathManager.getDota2LiveLeagueGames()
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Games>>(){}.getType();
        return ((Result<Games>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getGames();
    }

    /**
     * Get the information about the team.
     */
    @SuppressWarnings("unchecked")
    public Team getTeamInfoByID(long idTeam) throws Exception {
        String apiUrl = endpointsPathManager.getDota2TeamInfoById()
                + "?key=" + API_DOTA2_KEY
                + "&start_at_team_id=" + idTeam
                + "&teams_requested=1";
        Type type = new TypeToken<Result<Team>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(Team.class, new DeserializeTeam()).create();
        return ((Result<Team>) gson.fromJson(queueSteamApi.getJson(apiUrl), type)).getResult();
    }

    /**
     * Get the a list of items Dota2.
     */
    @SuppressWarnings("unchecked")
    public List<Item> getGameItems() throws Exception {
        String apiUrl = endpointsPathManager.getDota2GameItems()
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Items>>(){}.getType();
        return ((Result<Items>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getItems();
    }

    /**
     * Get a list of heroes Dota2.
     */
    @SuppressWarnings("unchecked")
    public List<Hero> getGameHero() throws Exception {
        String apiUrl = endpointsPathManager.getDota2GameHero()
                + "?key=" + API_DOTA2_KEY;
        Type type = new TypeToken<Result<Heroes>>(){}.getType();
        return ((Result<Heroes>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getHeroes();
    }

    /**
     * Get the information about player.
     */
    @SuppressWarnings("unchecked")
    public Player getPlayerSummaries(int player32Id) throws Exception {
        String apiUrl = endpointsPathManager.getDotaPlayerSummaries()
                + "?key=" + API_DOTA2_KEY
                + "&steamids=" + Convert.convert32To64(player32Id);
        Type type = new TypeToken<Response<PlayerSummaries>>(){}.getType();
        return ((Response<PlayerSummaries>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResponse().getPlayers().get(0);
    }

    /**
     * Get link from steam repository for images by ugcid
     * It can be used for:
     * team_logo_id
     */
    @SuppressWarnings("unchecked")
    public SteamRemoteStorage getSteamRemoteStorage(String id) throws Exception {
        String apiUrl = endpointsPathManager.getDotaSteamRemoteStorage()
                + "?key=" + API_DOTA2_KEY
                + "&appid=" + 570
                + "&ugcid=" + id;
        Type type = new TypeToken<Data<SteamRemoteStorage>>(){}.getType();
        return ((Data<SteamRemoteStorage>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getData();
    }

    /**
     * json page from github.com/dotabuff/d2vpkr
     * TODO: Change the page to api.steampowered.com/IEconItems_570/GetSchemaURL/v1/ and and make parser to Json.
     * TODO: Move to permanent storage resources.
     * Get a map of objects Dota2. (Use care: file weighs > 20мб)
     */
    @SuppressWarnings("unchecked")
    public String getSchema() throws Exception {
        return DownloadJson.readUrl(endpointsPathManager.getDotaSchema());
    }

    /**
     * Get parsed Map from objects Dota2.
     */
    @SuppressWarnings("unchecked")
    public Map<String, JsonObject> getItemsSchema() throws Exception {
        Type type = new TypeToken<SchemaPath>(){}.getType();
        SchemaPath schemaPath = new Gson().fromJson(getSchema(), type);
        return schemaPath.getItems_game().getItems();
    }

    /**
     * Get a link to the picture from the description of scheme.
     */
    @SuppressWarnings("unchecked")
    public String getItemIconPath(String iconName) throws Exception {
        String apiUrl = endpointsPathManager.getDotaItemIconPath()
                + "?key=" + API_DOTA2_KEY
                + "&format=json"
                + "&iconname=" + iconName;
        Type type = new TypeToken<Result<Path>>(){}.getType();
        return "http://cdn.dota2.com/apps/570/" + ((Result<Path>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getPath();
    }

    /**
     * Get a collection of tournaments logo links.
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
     * Get Map references tournament logos .
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
     * Get Map descriptions logos to receive further references to them.
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
     * Get not a detailed list of the history of the matches.
     */
    @SuppressWarnings("unchecked")
    public List<Match> getMatchHistory(MatchHistoryFilter filter) throws Exception {
        String apiUrl = endpointsPathManager.getDota2MatchHistory()
                + "?key=" + API_DOTA2_KEY
                + new QueryFilter().buildFilterHistoryMatch(filter);

        Type type = new TypeToken<Result<MatchHistory>>(){}.getType();
        return ((Result<MatchHistory>) new Gson().fromJson(queueSteamApi.getJson(apiUrl), type)).getResult().getMatches();
    }

    /**
     * Get pictures Доты2.
     * ID:{
     * ID_DOWNLOAD_MINMAP = 1
     * ID_DOWNLOAD_ITEMS_IMAGE = 2
     * ID_DOWNLOAD_HERO_IMAGE = 3
     * ID_DOWNLOAD_ABILITIES_IMAGE = 4
     * }
     * Patch : where to save the image.
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
