package org.example.kw99j10.programmers.lv2;

/**
 *  피로도, programmers:Level 2
 */
public class 피로도 {
    static int answer = 0;
    static boolean[] visit; //방문을 확인할 배열
    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];
        dfs(k, dungeons); //최대 던전 수를 구하기 위한 완전탐색 수행

        return answer;
    }
    private void dfs(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0]; //던전을 돌기 위해 필요한 피로도
            int consume = dungeons[i][1]; //던전을 돌기 위해 소모하는 피로도

            if (!visit[i] && k >= need) {
                visit[i] = true;
                dfs(k - consume, dungeons);
                visit[i] = false;
            }
        }

        int count = 0; //방문한 던전의 수
        for (boolean dungeon : visit) {
            if (dungeon) {
                count += 1;
            }
        }
        answer = Math.max(answer, count);
    }
}
