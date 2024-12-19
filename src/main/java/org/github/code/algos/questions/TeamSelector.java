package org.github.code.algos.questions;

import lombok.Data;

import java.util.*;

public class TeamSelector {

    public List<String> computeWinners( List<Vote> votes ){

        HashMap<String,Integer> teamvotes = new HashMap<>();

        for( Vote v : votes ){
            int vote =3;
            for(String team : v.getVotes() ){
                if(teamvotes.containsKey(team)){
                    int t = teamvotes.get(team);
                    t = t + vote;
                    teamvotes.put(team, t);
                }else{
                    teamvotes.put(team, vote);
                }
                vote--;
            }
        }

        // extract the votes
        Set<Integer> v2 = new HashSet<>();
        for( String key : teamvotes.keySet()){
            int v = teamvotes.get(key);
            v2.add(v);
        }

        List<Integer> v3 = new ArrayList<>(v2);
        // sort the values
        Collections.sort(v3);

        // Identify the winner
        List<String> winners = new ArrayList<>();
        for( int j= ( v3.size()-1 ) ; j>=0 ; j-- ){
            int votevalue = v3.get(j);
            List<String> teams = new ArrayList<>();
            for( String team : teamvotes.keySet() ){
                int gvote = teamvotes.get(team);
                if( votevalue == gvote ){
                    winners.add(team);
                }
            }
        }

        return winners;
    }

    @Data
    public static class Vote{
        List<String> votes = new ArrayList<>(3);
    }
}
