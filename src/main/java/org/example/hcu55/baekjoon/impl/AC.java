package org.example.hcu55.baekjoon.impl;

import java.util.ArrayDeque;
import java.util.Scanner;

// AC, 골드 V
public class AC {
    static String[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            String p = sc.next();       // 수행할 함수
            int n = sc.nextInt();       // 배열안 수 개수
            String s = sc.next();    // 배열 모양 문자열

            s = s.replace("[", "");     // "[" 문자 제거
            s = s.replace("]", "");     // "]" 문자 제거

            arr = s.split(",");                    // "," 스플릿

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(arr[j]));     // 덱에 넣기
            }

            AC(p, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String commands, ArrayDeque<Integer> deque) {
        boolean isReverse = false;         // 방향 상태

        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                isReverse = !isReverse;     // 방향 전환
                continue;
            }

            if (command == 'D') {
                if (deque.size() == 0) {
                    sb.append("error\n");
                    return;
                }
                if (isReverse) {        // 반대로 뒤집힘
                    deque.pollLast();
                } else {                // 정방향
                    deque.pollFirst();
                }
            }
        }

        sb.append("[");                 // 남은 문자 출력
        while (!deque.isEmpty()) {
            if (isReverse) {
                sb.append(deque.pollLast());
            } else {
                sb.append(deque.pollFirst());
            }

            if (deque.size() != 0) {
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}
