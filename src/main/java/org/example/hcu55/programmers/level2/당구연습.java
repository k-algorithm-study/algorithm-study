package org.example.hcu55.programmers.level2;

// 당구 연습, Programmers(Level 2)
// https://velog.io/@hiyoojeong/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%B9%EA%B5%AC-%EC%97%B0%EC%8A%B5-JAVA
public class 당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int curlen, len = Integer.MAX_VALUE;

            // 좌
            if (!(startY == targetY && startX >= targetX)) {
                curlen = getDistance(startX, startY, targetX * (-1), targetY);
                len = curlen < len ? curlen : len;
            }

            // 우
            if (!(startY == targetY && startX <= targetX)) {
                curlen = getDistance(startX, startY, m + (m - targetX), targetY);
                len = curlen < len ? curlen : len;
            }

            // 상
            if (!(startX == targetX && startY <= targetY)) {
                curlen = getDistance(startX, startY, targetX, n + (n - targetY));
                len = curlen < len ? curlen : len;
            }

            // 하
            if (!(startX == targetX && startY >= targetY)) {
                curlen = getDistance(startX, startY, targetX, targetY * (-1));
                len = curlen < len ? curlen : len;
            }

            answer[i] = len;
        }
        return answer;
    }

    public int getDistance(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }
}
