package org.example.hcu55.programmers.level2;

// 피로도, Programmers(Level 2)
public class 피로도 {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];         // 던전 길이 만큼 방문 배열
        dfs(0, k, dungeons);                      // 완전 탐색 dfs
        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {   // 방문하지 않고 k가 필요 피로도보다 이상일 때
                visited[i] = true;                      // 방문 처리
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;                     // 방문 초기화
            }
        }
        answer = Math.max(answer, depth);
    }
}
