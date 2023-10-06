package org.example.hcu55.baekjoon.impl;

//셀프 넘버, 실버 V
public class impl02 {
    public static void main(String[] args) {
        boolean[] notSelfNum = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {      // 셀프 넘버 아닌 것을 찾아서 true로 바꿈
            int n = d(i);

            if (n <= 10000) notSelfNum[n] = true;
        }

        for (int j = 1; j <= 10000; j++) {      // 셀프 넘버를 출력
            if (!notSelfNum[j])
                System.out.println(j);
        }
    }

    public static int d(int number) {
        int sum = number;       // 입력 받은 수

        while (number != 0) {
            sum += (number % 10);       // 맨 뒤 한자리수 더해주기
            number = number / 10;       // 맨 뒤 자리수 빼고 다시 number에 넣기
        }
        return sum;
    }
}
