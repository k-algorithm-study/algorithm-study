package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 달리기 경주, Programmers(Level 1)
// 처음 for문 스위치로 했더니 시간 초과 발생함
public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            map.put(player, i);     // map에 이름과 등수 넣기
        }

        for (String calling : callings) {
            int grade = map.get(calling);   // 불린 선수 등수 불러오기

            String forwardPlayer = players[grade - 1];     // 앞 선수 이름 가져오기

            players[grade - 1] = calling;   // 추월한 선수 등수 올려서 넣기
            map.put(calling, grade - 1);    // Map에 추월한 선수 이름과 역전한 등수 넣기

            players[grade] = forwardPlayer; // 추월 당한 선수 등수 내리기
            map.put(forwardPlayer, grade);  // Map에 역전 당한 선수 이름과 등수 넣기
        }

        return players;
    }
}
