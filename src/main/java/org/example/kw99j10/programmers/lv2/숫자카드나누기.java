package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;

/**
 * 숫자 카드 나누기, programmers:Level 2
 */
public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int length = arrayA.length; //배열의 길이

        int t1 = 0; //배열 A의 최대 공약수
        int t2 = 0; //배열 B의 최대 공약수

        //해당 배열의 모든 숫자를 나눌 수 있다 -> 최대 공약수를 구하는 문제

        for (int i = 0; i < length; i++) {
            t1 = gcd(t1, arrayA[i]);
            t2 = gcd(t2, arrayB[i]);
        }

        boolean b1 = true;
        boolean b2 = true;

        for (int i = 0; i < length; i++) {

            if (!b1 && !b2) {
                return 0; //조건 1,2를 모두 만족 X
            }

            //A의 최대 공약수로 B 요소가 나눠지면 X
            if (arrayA[i] % t2 == 0) {
                b2 = false;
            }

            //B의 최대 공약수로 A 요소가 나눠지면 X
            if (arrayB[i] % t1 == 0) {
                b1 = false;
            }
        }

        if (b1 && b2) {
            answer = Math.max(t1, t2);
        } else if (b1) {
            answer = t1;
        } else if (b2) {
            answer = t2;
        }
        return answer;
    }

    static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}
