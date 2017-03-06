package com.kingofneurons.esport.dota2.example;

import com.kingofneurons.esport.dota2.api.Dota2Api;
import com.kingofneurons.esport.dota2.api.Filter.MatchHistoryFilter;
import com.kingofneurons.esport.dota2.api.Filter.QueueFilter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String []args) throws Exception {

        final Dota2Api dota2Api = new Dota2Api("API-KEY", new QueueFilter(1000, 1, 3000));

        log.log(Level.INFO, dota2Api.getMatchDetailed(2569227952L).toString());
        log.log(Level.INFO, dota2Api.getLeagueListing().toString());
        log.log(Level.INFO, dota2Api.getLiveLeague().toString());
        log.log(Level.INFO, dota2Api.getTeamInfoByID(36).toString());
        log.log(Level.INFO, dota2Api.getGameItems().toString());
        log.log(Level.INFO, dota2Api.getGameHero().toString());
        log.log(Level.INFO, dota2Api.getPlayerSummaries(70388657).toString());
        log.log(Level.INFO, dota2Api.getSteamRemoteStorage("46499322609643214").toString());
        log.log(Level.INFO, dota2Api.getSchema());
        log.log(Level.INFO, dota2Api.getUrlLogoLeague(dota2Api.getLeagueListing()).toString());
        log.log(Level.INFO, dota2Api.getUrlLogoLeague(17129, 15421, 15422).toString());
        log.log(Level.INFO, dota2Api.getItemIconPath("subscriptions_latincup_summer_2016"));
        log.log(Level.INFO, dota2Api.getItemsSchema().toString());
        log.log(Level.INFO, dota2Api.getMatchHistory(new MatchHistoryFilter().addLeagueID(4664).addHeroID(20)).toString());
    }
}
