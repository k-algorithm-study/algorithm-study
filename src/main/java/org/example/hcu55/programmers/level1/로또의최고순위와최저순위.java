package org.example.hcu55.programmers.level1;

// 로또의 최고 순위와 최저 순위, Programmers(Level 1)
public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];      // 최고 순위, 최저 순위 담는 배열
        int[] rank = {6, 6, 5, 4, 3, 2, 1};     // 당첨 개수에 따른 순위 배열

        for (int i = 0; i < lottos.length; i ++) {
            if (lottos[i] == 0) {       // 0인 경우 당첨 됐다고 생각하고 당첨 추가
                answer[0]++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {     // 일치하면 최고 순위, 최저 순위 모두 증가
                    answer[0]++;
                    answer[1]++;
                }
            }
        }

        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];

        return answer;
    }
}
