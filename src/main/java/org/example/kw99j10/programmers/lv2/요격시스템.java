package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  요격 시스템, programmers:Level 2
 */
public class 요격시스템 {
    static int solution(int[][] targets) {
        int answer = 0;

        //구간 범위 끝 값(e)이 큰 순서대로 정렬
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int max = 0; //구간 값 비교 변수

        for (int[] target : targets) {

            /**
             * s: 개구간 시작 값, e: 개구간 끝 값
             * s와 e 부분에서 발사하는 요격 미사일로는 요격할 수 없기 때문에
             * s(target[0])부분보다 크거나 같으면 변수에 e(target[1])를 대입
             */
            if (target[0] >= max) {
                max = target[1];
                answer += 1;
            }
        }
        return answer;
    }

    //test를 위한 psvm문
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] targets = new int[7][2];
        for (int i = 0; i < targets.length; i++) {
            targets[i][0] = sc.nextInt();
            targets[i][1] = sc.nextInt();
        }
        System.out.println(solution(targets));
    }
}
