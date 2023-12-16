package org.example.kw99j10.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 국영수 - Silver IV
 */
public class Sort07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] arr = new String[n][4];

        //이름, 국어, 영어, 수학
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
            arr[i][2] = sc.next();
            arr[i][3] = sc.next();
        }
        Arrays.sort(arr, (o1, o2) -> {

            //국어 점수가 같으면 영어 점수 오름차순 정렬
            if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {

                //영어 점수도 같다면 수학 점수 내림차순 정렬
                if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {

                    //수학 점수도 같다면 이름 오름차순 정렬
                    if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                        return o1[0].compareTo(o2[0]);
                    }
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }

            //국어 내림차순 정렬
            else{
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });
        for (String[] strings : arr) {
            System.out.println(strings[0]);
        }
    }
}
