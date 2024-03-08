package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기, programmers:Level 2
 **/
public class 쿼드압축후개수세기 {
    static int zeroCount, oneCount;
    static int[][] tmp;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        tmp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = Arrays.copyOf(arr[i], arr.length);
        }

        divideArea(0, 0, tmp.length);
        answer[0] = zeroCount;
        answer[1] = oneCount;
        return answer;
    }

    static void divideArea(int x, int y, int len) {
        if (isSameNumber(x, y, len)) {
            if (tmp[x][y] == 0) {
                zeroCount++;
                return;
            } else {
                oneCount++;
                return;
            }
        }
        divideArea(x, y, len / 2);
        divideArea(x + len / 2, y, len / 2);
        divideArea(x, y + len / 2, len / 2);
        divideArea(x + len / 2, y + len / 2, len / 2);
    }

    static boolean isSameNumber(int x, int y, int len) {

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (tmp[i][j] != tmp[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
