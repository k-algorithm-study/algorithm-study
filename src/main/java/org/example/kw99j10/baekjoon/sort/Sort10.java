package org.example.kw99j10.baekjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 수 묶기 - Gold IV
 */
public class Sort10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        var plus_list = new ArrayList<Integer>(); //양의 수열
        var minus_list = new ArrayList<Integer>(); //음의 수열

        int zero = 0;
        int sum = 0; //주어진 수열의 최대 합

        for (int i = 0; i < n; i++) {

            int k = sc.nextInt();

            if (k == 0) {
                zero += 1; //0의 개수
            }
            else if (k == 1) {
                sum += k; //1은 더하는게 더 큼
            }
            else if (k > 0) {
                plus_list.add(k); //양의 정수를 더함
            }
            else {
                minus_list.add(k); //음의 정수를 더함
            }
        }
        Collections.sort(plus_list);
        Collections.reverse(plus_list); //정렬 후 뒤집음(for 최대)
        Collections.sort(minus_list);

        //리스트가 홀수이면 1을 더함(1을 더해도 값이 똑같음)
        //ex) 2,1,-1 : 1+(2x1) = 1+2, +(-1) = +(-1 x 1)
        if (plus_list.size() % 2 == 1) {
            plus_list.add(1);
        }

        if (minus_list.size() % 2 == 1) {
            minus_list.add(zero > 0 ? 0 : 1);
        }

        for (int i = 0; i < plus_list.size(); i += 2) {
            sum += plus_list.get(i) * plus_list.get(i + 1);
        }

        for (int i = 0; i < minus_list.size(); i += 2) {
            sum += minus_list.get(i) * minus_list.get(i + 1);
        }
        System.out.println(sum);
    }
}
