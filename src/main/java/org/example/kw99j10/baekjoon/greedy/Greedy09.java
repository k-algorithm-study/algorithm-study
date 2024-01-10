package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * A->B - Silver II
 */
public class Greedy09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0; //필요한 연산 횟수

        //b->a가 될 수 있는 지를 판단
        while (true) {

            if (a == b) {
                count += 1; //b가 a가 되면 a를 b로 바꿀 수 있음
                break;
            }

            if (a > b) {
                count = -1; //만들 수 없는 경우
                break;
            }

            if (b % 10 == 1) {
                b = b / 10; //1을 추가 -> 나머지가 1인 경우를 구함
            }
            else if (b % 2 == 0) {
                b = b / 2; //2를 곱함 -> 2를 나눔
            }
            else{
                count = -1; //그 외는 나올 수 없는 경우의 수
                break;
            }
            count += 1;
        }
        System.out.println(count);
    }
}
