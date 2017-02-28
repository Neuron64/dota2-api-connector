package com.kingofneurons.esport.dota2.dto.game_hero;

import java.util.List;

public class Heroes {

    private List<Hero> heroes;
    private int status;
    private int count;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "heroes=" + heroes +
                ", status=" + status +
                ", count=" + count +
                '}';
    }
}
