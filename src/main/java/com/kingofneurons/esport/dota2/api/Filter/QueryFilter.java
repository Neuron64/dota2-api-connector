package com.kingofneurons.esport.dota2.api.Filter;

import java.util.Map;

public class QueryFilter {

    public String buildFilterHistoryMatch(MatchHistoryFilter filter){
        String queryHistoryMatch = "";
        for(Map.Entry<String, String> ll : filter.filterFields.entrySet()){
            queryHistoryMatch += "&"
                    + ll.getKey()
                    + "="
                    + ll.getValue();
        }
        return queryHistoryMatch;
    }
}
