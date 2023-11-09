package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538
public class 숫자변환하기 {

  public int solution(int x, int y, int n) {
    int[] dp = new int[y + 1];
    for (int i = x; i < y + 1; i++) {
      // 해당 수로 갈 수 없다면 -1
      if (i != x && dp[i] == 0) {
        dp[i] = -1;
        continue;
      }
      if (i + n <= y) {
        dp[i + n] = (dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i + n], dp[i] + 1));
      }
      if (i * 2 <= y) {
        dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i * 2], dp[i] + 1);
      }
      if (i * 3 <= y) {
        dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i * 3], dp[i] + 1);
      }
    }
    return dp[y];
  }

}
