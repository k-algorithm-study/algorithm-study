package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;
/**
 * 수들의 합 - Silver V
 */
public class Greedy06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong(); //n개의 자연수의 합

        int n = 1;
        long sum = 0L; //자연수 S의 범위가 int 범위를 넘어감

        //n의 최대 개수 -> 작은 수부터 더해나감
        while (true) {

            sum += n;
            n += 1;

            if (sum > s) {
                n -= 1; //주어진 S를 넘어가면 n을 -1한 후 break
                break;
            }
        }
        System.out.println(n - 1); //n에 대한 sum의 차이가 1만큼 나므로 n을 한번 더 -1
    }
}
