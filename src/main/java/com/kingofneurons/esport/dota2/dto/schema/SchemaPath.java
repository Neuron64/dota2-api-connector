package com.kingofneurons.esport.dota2.dto.schema;

import com.google.gson.JsonObject;

import java.util.Map;

public class SchemaPath {

    private Items items_game;

    public Items getItems_game() {
        return items_game;
    }

    public class Items{

        private Map<String, JsonObject> items;

        public Map<String, JsonObject> getItems() {
            return items;
        }
    }
}
