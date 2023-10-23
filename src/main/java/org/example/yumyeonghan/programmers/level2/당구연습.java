package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/169198
public class 당구연습 {

  public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    int[] answer = new int[balls.length];
    for (int i = 0; i < balls.length; i++) {
      int[] ball = balls[i];
      int[] transBall = SymmetryMove(m, n, startX, startY, ball);
      int minDistance = Integer.MAX_VALUE;
      for (int j = 0; j < transBall.length; j += 2) {
        int dis = calculateDistance(startX, startY, transBall[j], transBall[j + 1]);
        minDistance = Math.min(minDistance, dis);
      }
      answer[i] = minDistance;
    }
    return answer;
  }

  private static int[] SymmetryMove(int m, int n, int startX, int startY, int[] ball) {
    List<Integer> movedBalls = new ArrayList<>();

    // 4 개의 방향으로 대칭이동
    // 선 대칭일 때, 벽보다 공에 먼저 맞는 경우 제외
    if (!(startX == ball[0] && startY > ball[1])) {
      movedBalls.add(ball[0]);
      movedBalls.add(ball[1] * -1);
    }
    if (!(startX == ball[0] && startY < ball[1])) {
      movedBalls.add(ball[0]);
      movedBalls.add(n + (n - ball[1]));
    }
    if (!(startY == ball[1] && startX < ball[0])) {
      movedBalls.add(m + (m - ball[0]));
      movedBalls.add(ball[1]);
    }
    if (!(startY == ball[1] && startX > ball[0])) {
      movedBalls.add(ball[0] * -1);
      movedBalls.add(ball[1]);
    }

    int[] result = new int[movedBalls.size()];
    for (int i = 0; i < movedBalls.size(); i++) {
      result[i] = movedBalls.get(i);
    }
    return result;
  }

  private static int calculateDistance(int startX, int startY, int ballX, int ballY) {
    int deltaX = Math.abs(startX - ballX);
    int deltaY = Math.abs(startY - ballY);
    return deltaX * deltaX + deltaY * deltaY;
  }

}
