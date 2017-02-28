package com.kingofneurons.esport.dota2.api.Deserialize.team_info;

import com.google.gson.*;
import com.kingofneurons.esport.dota2.dto.team_info.Team;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DeserializeTeam implements JsonDeserializer<Team> {

    private Logger log = Logger.getLogger(DeserializeTeam.class.getName());

    public Team deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray array = json.getAsJsonObject().get("teams").getAsJsonArray();

        JsonObject object = array.get(0).getAsJsonObject();

        String name = object.has("name")? object.get("name").getAsString() : null;
        String tag = object.has("tag")? object.get("tag").getAsString() : null;
        long time_created = object.has("time_created")? object.get("time_created").getAsLong() : 0;
        int calibration_games_remaining = object.has("calibration_games_remaining")? object.get("calibration_games_remaining").getAsInt() : 0;
        String logo = object.has("logo")? object.get("logo").getAsString() : null;
        String logo_sponsor = object.has("logo_sponsor")? object.get("logo_sponsor").getAsString() : null;
        String country_code = object.has("country_code")? object.get("country_code").getAsString() : null;
        String url = object.has("country_code")? object.get("country_code").getAsString() : null;
        long games_played = object.has("games_played")? object.get("games_played").getAsLong() : 0;
        long admin_account_id = object.has("admin_account_id")? object.get("admin_account_id").getAsLong() : 0;
        List<Integer> league_id = new ArrayList<Integer>();
        List<Long> player_account_id = new ArrayList<Long>();

        int i = 0;
        do{
            if(object.has("league_id_" + i)){
                league_id.add(object.get("league_id_" + i).getAsInt());
                i++;
            }else break;
        }while (true);
        i = 0;
        do{
            if(object.has("player_" + i + "_account_id")){
                player_account_id.add(object.get("player_" + i + "_account_id").getAsLong());
                i++;
            }else break;
        }while (true);

        return new Team(name, tag, time_created, calibration_games_remaining, logo, logo_sponsor, country_code, url, games_played, admin_account_id, league_id, player_account_id);
    }
}
