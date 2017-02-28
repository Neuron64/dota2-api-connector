package com.kingofneurons.esport.dota2.util;

public class Convert {

    public static long convert32To64(int variable32){return variable32 + 76561197960265728L;}
    public static int convert64To32(long variable64){
        return (int) (variable64 - 76561197960265728L);
    }
}
