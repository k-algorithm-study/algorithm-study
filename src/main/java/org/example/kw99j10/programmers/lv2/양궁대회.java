package org.example.kw99j10.programmers.lv2;

/**
 * 양궁 대회, programmers:Level 2
 */
public class 양궁대회 {
    static int[] answer; //출력할 결과 배열
    static int[] lion = new int[11];
    static int score_dif = Integer.MIN_VALUE; //두 선수의 스코어 차이

    public int[] solution(int n, int[] info) {

        dfs(info, 0, n); //어피치의 정보, 시작 인덱스, 화살의 개수

        if (score_dif <= 0) {
            return new int[]{-1};
        }
        return answer;
    }

    private void dfs(int[] info, int i, int count) {
        if (checkCount(info, i, count))
            return;

        for (int s = 0; s <= 10 && lion[s] <= info[s]; s++) {
            lion[s] += 1;
            dfs(info, i + 1, count);
            lion[s] -= 1;
        }
    }
    static boolean checkCount(int[] info, int i, int count) {
        if (i == count) {
            int peachScore = 0;
            int lionScore = 0;

            //배열은 10점부터 0점 순서로 저장되어있음
            for (int s = 0; s <= 10; s++) {
                if (info[s] != 0 || lion[s] != 0) {
                    if (lion[s] > info[s]) {
                        lionScore += 10 - s;
                    }
                    else{
                        peachScore += 10 - s;
                    }
                }
            }

            if (lionScore > peachScore && lionScore - peachScore >= score_dif) {
                answer = lion.clone();
                score_dif = Math.max(score_dif, lionScore - peachScore);
            }
            return true;
        }
        return false;
    }
}
