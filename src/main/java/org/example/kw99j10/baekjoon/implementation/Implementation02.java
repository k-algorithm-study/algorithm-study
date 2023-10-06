package org.example.kw99j10.baekjoon.implementation;

import java.util.HashSet;

/**
 * 셀프 넘버 - Silver V
 */
public class Implementation02 {
    public static void main(String[] args) {

        var h = new HashSet<Integer>(); //셀프 넘버가 아닌 수를 담을 Set 자료 구조

        //범위: 1~10000
        for (int i = 1; i <= 10000; i++) {

            //양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하기 위함
            String v = String.valueOf(i);

            int sum = i;
            for (int j = 0; j < v.length(); j++) {
                sum += Integer.parseInt(String.valueOf(v.charAt(j)));
            }
            h.add(sum);
        }
        for (int i = 1; i <= 10000; i++) {
            if (!h.contains(i)) {
                System.out.println(i); //Set 에 없으면 셀프 넘버
            }
        }
    }
}
