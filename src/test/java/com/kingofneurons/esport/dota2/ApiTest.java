package com.kingofneurons.esport.dota2;

import com.kingofneurons.esport.dota2.api.Dota2Api;
import com.kingofneurons.esport.dota2.api.Filter.MatchHistoryFilter;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApiTest {

    private final String API_KEY = "4B1BE6B76C2B63E978962E2B38EC219E";

    @Test
    public void TestMatchDetailed() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("MatchDetailed must be not null (idMatch:2569227952L)", dota2Api.getMatchDetailed(2569227952L));
    }

    @Test
    public void TestLeagueListing() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("LeagueListing must be not null", dota2Api.getLeagueListing());
    }

    @Test
    public void TestLiveLeague() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("LiveLeague must be not null", dota2Api.getLiveLeague());
    }

    @Test
    public void TestTeamInfoByID() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("TeamInfoByID must be not null (idTeam:36)", dota2Api.getTeamInfoByID(36));
    }

    @Test
    public void TestGameItems() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("TeamInfoByID must be not null", dota2Api.getGameItems());
    }

    @Test
    public void TestGameHero() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("GameHero must be not null", dota2Api.getGameHero());
    }

    @Test
    public void TestPlayerSummaries() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("PlayerSummaries must be not null (playerId:70388657)", dota2Api.getPlayerSummaries(70388657));
    }

    @Test
    public void TestSteamRemoteStorage() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("SteamRemoteStorage must be not null (id:46499322609643214)", dota2Api.getSteamRemoteStorage("46499322609643214"));
    }

    @Test
    public void TestSchema() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("Schema must be not null", dota2Api.getSchema());
    }

    @Test
    public void TestUrlLogoLeagueByLeagueListing() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("UrlLogoLeague must be not null", dota2Api.getUrlLogoLeague(dota2Api.getLeagueListing()));
    }

    @Test
    public void TestUrlLogoLeagueById() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("UrlLogoLeague must be not null (id:{17129, 15421, 15422})", dota2Api.getUrlLogoLeague(17129, 15421, 15422));
    }

    @Test
    public void TestItemIconPath() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("ItemIconPath must be not null (id:{subscriptions_latincup_summer_2016})", dota2Api.getItemIconPath("subscriptions_latincup_summer_2016"));
    }

    @Test
    public void TestMatchHistory() throws Exception {
        Dota2Api dota2Api = new Dota2Api(API_KEY);
        assertNotNull("MatchHistory must be not null)", dota2Api.getMatchHistory(new MatchHistoryFilter().addLeagueID(4664).addHeroID(20)));
    }
}
