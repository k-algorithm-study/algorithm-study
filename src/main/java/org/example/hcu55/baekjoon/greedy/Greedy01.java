package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

//설탕 배달, 실버 IV
public class Greedy01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        while (true) {
            if (N % 5 == 0) {       // 5로 나누어 떨어지면 몫과 count 더해서 출력
                System.out.println(N / 5 + count);
                break;
            } else if (N < 0) {     // 먼저 5로도 안나눠지고 3씩 빼서 나눠도 안나눠 진다면 3과 5로 만들수 없는 수 -1 출력
                System.out.println(-1);
                break;
            }
            N -= 3;                 // 5로도 안나눠지고 0보다는 크다면 3씩 빼서 다시 반복
            count++;                // 3씩 빼는 건 3kg 설탕을 선택한 것 count 하나 증가
        }
    }
}
