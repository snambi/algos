package org.github.code.algos.questions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeamSelectorTest {


    public List<TeamSelector.Vote> generetsVotes(){
        List<TeamSelector.Vote> votes = new ArrayList<>();

        Random random = new Random();

        for( int i=0; i<5; i++ ){
            TeamSelector.Vote v = new TeamSelector.Vote();

            int num = random.nextInt(10 - 1);
            String team1 = "TEAM_"+ random.nextInt(10 - 1);
            v.getVotes().add(team1);
            String team2 = "TEAM_"+ random.nextInt(10 - 1);
            v.getVotes().add(team2);
            String team3 = "TEAM_"+ random.nextInt(10 - 1);
            v.getVotes().add(team3);

            votes.add(v);
        }

        return votes;
    }


    @Test
    public void test(){

        List<TeamSelector.Vote> votes = generetsVotes();

        TeamSelector teamSelector = new TeamSelector();

        List<String> winners = teamSelector.computeWinners(votes);

        assertNotNull(winners);
    }
}
