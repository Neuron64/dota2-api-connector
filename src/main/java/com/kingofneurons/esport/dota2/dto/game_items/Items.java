package com.kingofneurons.esport.dota2.dto.game_items;

import java.util.List;

public class Items {

    private List<Item> items;
    private String status;

    public List<Item> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "Items{" +
                "items=" + items +
                ", status='" + status + '\'' +
                '}';
    }
}
