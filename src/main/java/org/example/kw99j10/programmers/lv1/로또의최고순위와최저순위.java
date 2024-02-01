package org.example.kw99j10.programmers.lv1;

import java.util.HashSet;

/**
 * 로또의 최고 순위와 최저 순위, programmers:Level 1
 */
public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        var lotto = new HashSet<Integer>(); //당첨 번호를 담을 집합

        for (int i = 0; i < lottos.length; i++) {
            lotto.add(win_nums[i]);
        }

        int rank = 1; //현재 순위
        int zeroCount = 0; //0의 개수
        for (int i = 0; i < lottos.length; i++) {
            if (!lotto.contains(lottos[i])) {
                rank += 1;
            }
            if (lottos[i] == 0) {
                zeroCount += 1;
            }
        }

        int max = rank - zeroCount;
        int min = rank;

        //번호가 다 틀리면 7등이므로 이 경우에는 rank를 1단계 낮춤
        answer[0] = max == 7 ? max - 1 : max;
        answer[1] = min == 7 ? min - 1 : min;

        return answer;
    }
}
