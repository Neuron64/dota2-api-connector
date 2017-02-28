package com.kingofneurons.esport.dota2.api.Filter;

import com.kingofneurons.esport.dota2.dto.parameter.Skill;
import com.kingofneurons.esport.dota2.dto.parameter.GameMode;

import java.util.HashMap;
import java.util.Map;

public class MatchHistoryFilter {

    Map<String, String> filterFields = new HashMap<String, String>();

    public MatchHistoryFilter addGameMode(GameMode gameMode){
        filterFields.put("game_mode", String.valueOf(gameMode.getID()));
        return this;
    }

    /* A list of hero IDs can be found via the GetHeroes method */
    public MatchHistoryFilter addHeroID(int heroID){
        filterFields.put("hero_id", String.valueOf(heroID));
        return this;
    }

    /* Skill bracket for the matches (Ignored if an account ID is specified) */
    public MatchHistoryFilter addSkill(Skill skill){
        filterFields.put("skill", String.valueOf(skill.getId()));
        return this;
    }

    /* Minimum date range for returned matches (unix timestamp, rounded to the nearest day) */
    public MatchHistoryFilter addDateMin(long timestamp){
        filterFields.put("date_min", String.valueOf(timestamp));
        return this;
    }

    /* Maximum date range for returned matches (unix timestamp, rounded to the nearest day) */
    public MatchHistoryFilter addDateMax(long timestamp){
        filterFields.put("date_max", String.valueOf(timestamp));
        return this;
    }

    /* Minimum amount of players in a match for the match to be returned */
    public MatchHistoryFilter addMinPlayers(int count){
        filterFields.put("min_players", String.valueOf(count));
        return this;
    }

    /* 32-bit account ID */
    public MatchHistoryFilter addAccount32ID(long accountID){
        filterFields.put("account_id", String.valueOf(accountID));
        return this;
    }

    /* Only return matches from this league. A list of league IDs can be found via the GetLeagueListing method */
    public MatchHistoryFilter addLeagueID(long accountID){
        filterFields.put("league_id", String.valueOf(accountID));
        return this;
    }

    /* Start searching for matches equal to or older than this match ID */
    public MatchHistoryFilter addStartMatchID(long matchID){
        filterFields.put("start_at_match_id", String.valueOf(matchID));
        return this;
    }

    /* Amount of matches to include in results (default: 25) */
    public MatchHistoryFilter addAmountRequested(int requestAmount){
        filterFields.put("matches_requested", String.valueOf(requestAmount));
        return this;
    }

    /* Whether to limit results to tournament matches. (0 = false, 1 = true) */
    public MatchHistoryFilter addTournamentGamesOnly(boolean tournamentOnly){
        if(tournamentOnly) filterFields.put("tournament_games_only", String.valueOf(1));
        else filterFields.put("tournament_games_only", String.valueOf(0));
        return this;
    }
}
