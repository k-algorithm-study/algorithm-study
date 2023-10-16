package org.example.kw99j10.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 달리기 경주, programmers:Level 1
 */
public class 달리기경주 {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        var rank = new HashMap<String, Integer>(); //선수, 현재 등수
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {

            int player_rank = rank.get(callings[i]); //부른 선수의 순위
            String current = players[player_rank]; //현재 선수
            String before = players[player_rank - 1]; //그 앞에 있는 선수

            rank.put(current, rank.get(current) - 1);//현재 선수 순위 상승
            rank.put(before, rank.get(before) + 1); //이전 선수 순위

            //순위 변경
            players[player_rank - 1] = current;
            players[player_rank] = before;
        }

        //배열 복사(뽁사 배열, 시작점, 복사할 배열, 시작점, 배열 길이)
        System.arraycopy(players, 0, answer, 0, answer.length);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] players = new String[5];
        String[] callings = new String[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = sc.next();
        }
        for (int i = 0; i < callings.length; i++) {
            callings[i] = sc.next();
        }
        System.out.println(Arrays.toString(solution(players, callings)));
    }
}
