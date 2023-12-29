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
            return new int[]{-1}; //라이언이 어피치를 이길 수 없는 경우의 수
        }
        return answer;
    }

    private void dfs(int[] info, int i, int count) {
        if (checkCount(info, i, count))
            return; //화살에 따른 점수 차를 체크

        //현재 화살 인덱스에서 라이언의 점수가 더 낮다면 dfs 수행 후 화살을 다시 뺌
        //시간 초과 문제로 for문에 조건을 설정
        for (int s = 0; s <= 10 && info[s] >= lion[s]; s++) {
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

                //조건에 따른 화살 점수 (k)점만을 분배
                if (info[s] != 0 || lion[s] != 0) {
                    if (lion[s] > info[s]) {
                        lionScore += 10 - s;
                    }
                    else{
                        peachScore += 10 - s;
                    }
                }
            }

            //가장 큰 점수 차이를 갱신하기 위함
            // ">="인 이유: 가장 낮은 점수를 더 많이 맞힌 경우를 고려하기 위해
            if (lionScore > peachScore && lionScore - peachScore >= score_dif) {
                answer = lion.clone();
                score_dif = Math.max(score_dif, lionScore - peachScore);
            }
            return true;
        }
        return false;
    }
}
