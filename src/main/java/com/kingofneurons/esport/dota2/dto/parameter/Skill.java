package com.kingofneurons.esport.dota2.dto.parameter;

public enum  Skill {

    Any (0),
    Normal (1),
    High (2),
    VeryHigh (3);

    private final int id;

    Skill(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
