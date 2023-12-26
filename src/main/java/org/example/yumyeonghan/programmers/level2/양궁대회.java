package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/92342
public class 양궁대회 {

  private static int[] answer = {-1};
  private static int[] lion = new int[11];
  private static int maxScoreDifference = -(int) 1e9;

  public int[] solution(int n, int[] info) {
    dfs(info, 0, n);
    return answer;
  }

  private void dfs(int[] info, int count, int n) {

    // 화살을 다 쐇으면, 라이온과 어피치의 점수를 각각 계산
    if (count == n) {
      int peachPoint = 0;
      int lionPoint = 0;
      for (int i = 0; i <= 10; i++) {
        if (info[i] != 0 || lion[i] != 0) {
          if (lion[i] > info[i]) {
            lionPoint += 10 - i;
          } else {
            peachPoint += 10 - i;
          }
        }
      }

      //  라이온의 점수가 더 크고, 최댓값을 갱신할 수 있다면 배열과 최댓값을 갱신
      if (lionPoint > peachPoint && lionPoint - peachPoint >= maxScoreDifference) {
        answer = lion.clone();
        maxScoreDifference = Math.max(maxScoreDifference, lionPoint - peachPoint);
      }
      return;
    }

    // 화살을 다 쏘는 시점 (count == n) 찾기
    for (int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
      lion[i] += 1;
      dfs(info, count + 1, n);
      lion[i] -= 1;
    }
  }

}
