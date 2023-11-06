package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 무인도 여행, programmers:Level 2
 */

public class 무인도여행 {

    static int[][] island; //무인도의 좌표를 담을 배열
    static int day_count; //무인도에서 버틸 수 있는 날짜

    public int[] solution(String[] maps) {

        island = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'X') {
                    island[i][j] = 0; // X -> 0으로 치환
                }
                else{
                    island[i][j] = Integer.parseInt(String.valueOf(c));
                }
            }
        }
        var days = new ArrayList<Integer>(); //머무를 수 있는 총 날짜 list

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {

                if (island[i][j] != 0) {
                    day_count = 0;
                    dfs(i, j); //0이아니면 버틸 수 있으므로 dfs 실행
                    days.add(day_count); //인접한 섬까지의 dfs 결과를 list에 더함
                }
            }
        }
        Collections.sort(days); //오름차순 정렬
        int[] answer = new int[days.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = days.get(i);
        }
        //지낼 수 있는 무인도가 없다면 -1 리턴
        return days.size() != 0 ? answer : new int[]{-1};
    }

    private void dfs(int i, int j) {

        day_count += island[i][j];
        island[i][j] = 0;

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];

            // 이동한 좌표가 미로 안에 있어야 하며,
            // 그 좌표는 1(이동할 수 있는 칸)이어야 함
            if (distance_x >= 0 && distance_x <= island[0].length - 1 &&
                    distance_y >= 0 && distance_y <= island.length - 1) {
                if (island[distance_y][distance_x] != 0) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}
