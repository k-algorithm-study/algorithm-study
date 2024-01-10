package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 교점에 별 만들기, Programmers(Level 2)
public class 교점에별만들기 {

    public class Point {        // 좌표 클래스 Point
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public Point intersection(long A, long B, long E, long C, long D, long F) {       // 교점 구하는 클래스
        double x = (double) (B * F - E * D) / (A * D - B * C);
        double y = (double) (E * C - A * F) / (A * D - B * C);

        if ((x % 1 != 0) || (y % 1 != 0)) {         // 정수가 아니면 null 반환
            return null;
        }
        return new Point((long) x, (long) y);       // 정수이면 Point 클래스 반환
    }

    public String[] solution(int[][] line) {

        List<Point> points = new ArrayList<>();     // 교점을 저장할 리스트

        for (int i = 0; i < line.length; i++) {     // 본인을 제외한 다른 직선끼리 모두 비교
            for (int j = i + 1; j < line.length; j++) {
                Point pointIntersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (pointIntersection != null) {
                    points.add(pointIntersection);      // 정수인 교점이 있으면 리스트에 저장
                }
            }
        }

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (Point point : points) {              // 최소 사각형을 그리기 위해 최대 최소 좌표 구하기
            maxX = Math.max(maxX, point.x);
            minX = Math.min(minX, point.x);
            maxY = Math.max(maxY, point.y);
            minY = Math.min(minY, point.y);
        }


        int xLength = (int) (maxX - minX + 1);      // 가로축 길이
        int yLength = (int) (maxY - minY + 1);      // 세로축 길이

        char[][] starMap = new char[yLength][xLength];      // 세로길이, 가로길이 순임


        for (int i = 0; i < yLength; i++) {         // 일단 .으로 채워넣기
            for (int j = 0; j < xLength; j++) {
                starMap[i][j] = '.';
            }
        }

        for (Point point : points) {
            int x = (int) (point.x - minX);     // 교점에서 최소 x값을 빼서 x 교점 위치 찾음 (가로축)
            int y = (int) (maxY - point.y);     // 최대 y좌표 값에서 교점 y좌표를 빼서 위치 찾음 (세로축)
            starMap[y][x] = '*';                // 교점에 별 찍기
        }


        String[] answer = new String[starMap.length];
        for (int i = 0; i < answer.length; i++) {       // 정답 출력
            answer[i] = new String(starMap[i]);
        }
        return answer;
    }
}
