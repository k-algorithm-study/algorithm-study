package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호 - Silver II
 */
public class Greedy04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.next(); //주어진 식

        //식은 유지하되 괄호의 위치를 통해 식을 최소 값으로 만듦

        //"-" 기준으로 token을 나눔 -> "+"를 기준으로 token을 나눔

        StringTokenizer st = new StringTokenizer(expression, "-");

        int sum = Integer.MAX_VALUE; //'-'를 통해 분리된 문자열의 합
        while (st.hasMoreTokens()) {

            int sum2 = 0; //'+'로 분리된 문자열의 합
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                sum2 += Integer.parseInt(st2.nextToken());
            }
            System.out.println(sum + " " + sum2);
            if (sum == Integer.MAX_VALUE) {
                sum = sum2;
            }
            //min: '-'를 통해 분리된 문자열의 합 - '+'를 통해 분리된 문자열의 합
            else{
                sum -= sum2;
            }
        }
        System.out.println(sum);
    }
}
