package org.example.hcu55.swea.D3;

import java.util.*;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = sc.nextInt();        // 건물의 개수(좌우 2칸씩은 건물 없음)
            int[] tower = new int[N];    // 건물 높이 저장할 배열

            for (int i = 0; i < tower.length; i++) {     // 건물 높이 입력받기
                tower[i] = sc.nextInt();
            }

            int sum = 0;        // 조망권 확보된 세대 수 합

            for (int i = 2; i < N - 2; i++) {
                int left = Math.min(tower[i] - tower[i - 1], tower[i] - tower[i - 2]);      // 좌측 조망권 확보
                int right = Math.min(tower[i] - tower[i + 1], tower[i] - tower[i + 2]);     // 우측 조망권 확보
                int result = Math.min(left, right);     // 좌,우 중에 작은 값이 조망권이 확보됐는지 확인 가능

                if (result > 0) {           // 음수가 아닌 경우만 조망권 확보 된 것임
                    sum += result;
                }
            }
            System.out.println("#" + testCase + " " + sum);
        }
    }
}
