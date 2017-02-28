package com.kingofneurons.esport.dota2.dto.match_history;

import java.util.List;

public class MatchHistory {

    private int status;
    private int num_results;
    private int total_results;
    private int results_remaining;
    private List<Match> matches;

    public int getStatus() {
        return status;
    }

    public int getNum_results() {
        return num_results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getResults_remaining() {
        return results_remaining;
    }

    public List<Match> getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        return "MatchHistory{" +
                "status=" + status +
                ", num_results=" + num_results +
                ", total_results=" + total_results +
                ", results_remaining=" + results_remaining +
                ", matches=" + matches +
                '}';
    }
}
