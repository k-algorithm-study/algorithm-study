package org.example.hcu55.programmers.level2;

// 숫자 카드 나누기, Programmers(Level 2)
public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);    // 최대 공약수 구하기
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (notDivisble(arrayB, gcdA))
            if (answer < gcdA)
                answer = gcdA;

        if (notDivisble(arrayA, gcdB))
            if (answer < gcdA)
                answer = gcdB;

        return answer;
    }

    public boolean notDivisble(int[] arr, int num) {    // 배열에서 상대 최대 공약수 중에 나눠지는게 있는 지 확인
        for (int n : arr) {
            if (n % num == 0) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int a, int b) {  // 최대공약수 구하는 공식
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
