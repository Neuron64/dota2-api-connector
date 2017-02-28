package com.kingofneurons.esport.dota2.dto.parameter;

public enum  GameMode {

    None (0),
    AllPick (1),
    CaptainsMode (2),
    RandomDraft (3),
    SingleDraft (4),
    AllRandom (5),
    Intro (6),
    Diretide (7),
    ReverseCaptainsMode (8),
    TheGreeviling (9),
    Tutorial (10),
    MidOnly (11),
    LeastPlayed (12),
    NewPlayerPool (13),
    CompendiumMatchmaking (14),
    CaptainsDraft (16);

    private final int id;

    GameMode(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
