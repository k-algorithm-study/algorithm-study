package org.example.hcu55.programmers.level1;

// 바탕화면 정리, Programmers(Level 1)
public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int minX = 51;      // 초기화
        int minY = 51;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < wallpaper.length; i++) {      // x좌표
            for (int j = 0; j < wallpaper[i].length(); j++) {    // y좌표
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int[] answer = {minX, minY, maxX + 1, maxY + 1};

        return answer;
    }
}
