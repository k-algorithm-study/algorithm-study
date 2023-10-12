package org.example.kw99j10.baekjoon.search.binary;

import java.util.HashMap;
import java.util.Scanner;

public class Binary01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        var has = new HashMap<Integer, Integer>(); //예시 중 몇개를 갖고 있는 지
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            has.put(tmp, has.getOrDefault(tmp, 0) + 1);
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if (!has.containsKey(tmp)) {
                sb.append(0).append(" ");
            }
            else{
                sb.append(has.get(tmp)).append(" ");
            }
        }
        System.out.println(sb);
    }
}
