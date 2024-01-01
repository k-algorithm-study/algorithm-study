package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class 피로도 {

  private static boolean[] isVisited;
  private static int count;

  public int solution(int k, int[][] dungeons) {
    isVisited = new boolean[dungeons.length];
    dfs(k, dungeons, 0);
    return count;
  }

  private void dfs(int k, int[][] dungeons, int depth) {
    count = Math.max(count, depth);
    for (int i = 0; i < dungeons.length; i++) {
      if (k >= dungeons[i][0] && !isVisited[i]) {
        isVisited[i] = true;
        dfs(k - dungeons[i][1], dungeons, depth + 1);
        isVisited[i] = false;
      }
    }
  }

}
