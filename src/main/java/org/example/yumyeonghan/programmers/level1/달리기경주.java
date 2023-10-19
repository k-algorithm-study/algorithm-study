package org.example.yumyeonghan.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class 달리기경주 {

    private static Map<String, Integer> playerInfo = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        for (int i = 0; i < players.length; i++) {
            playerInfo.put(players[i], i);
        }
        for (String calling : callings) {
            int overtakingPersonRank = playerInfo.get(calling) - 1;
            String overtakingPerson = players[overtakingPersonRank];

            playerInfo.put(overtakingPerson, playerInfo.get(overtakingPerson) + 1);
            playerInfo.put(calling, playerInfo.get(calling) - 1);

            players[playerInfo.get(calling)] = calling;
            players[playerInfo.get(overtakingPerson)] = overtakingPerson;
        }
        return players;
    }

}
