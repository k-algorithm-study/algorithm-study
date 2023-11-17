package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;

/**
 * 분수찾기 - Silver V
 */
public class Implementation05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int i = 0; //1,2,3,4,5....
        int count = 0; //1,3,6,10,15....: 대각선 배열의 합

        while (true) {
            i += 1;
            count += i;

            if (count >= x) {

                //대각선: 짝수 줄의 경우
                if (i % 2 == 0) {
                    System.out.println((i - (count - x)) + "/" + (1 + (count - x)));
                }
                //대각선: 홀수 줄의 경우
                else{
                    System.out.println((1 + (count - x)) + "/" + (i - (count - x)));
                }
                break;
            }
        }
    }
}
