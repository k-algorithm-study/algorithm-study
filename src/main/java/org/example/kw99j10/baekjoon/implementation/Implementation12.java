package org.example.kw99j10.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * AC - Gold V
 */
public class Implementation12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //R: 뒤집는 함수, D: 첫 번째 수를 버리는 함수
        for (int i = 0; i < t; i++) {
            String s = br.readLine(); //수행할 함수
            int n = Integer.parseInt(br.readLine()); //배열의 수

            String array = br.readLine();
            st = new StringTokenizer(array, "[],");

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            while (st.hasMoreElements()) {
                queue.add(Integer.valueOf(st.nextToken()));
            }

            boolean reverse = false; //문자열을 뒤집었는가
            boolean remove = true; //문자를 제거할 수 있는가

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'R') {
                    reverse = !reverse;
                }
                if (c == 'D') {
                    if (queue.isEmpty()) {
                        remove = false;
                        break;
                    }

                    if (reverse) {
                        queue.removeLast();
                    } else {
                        queue.removeFirst();
                    }
                }
            }

            if (remove) {
                sb.append("["); //제거할 수 있다면 배열 출력

                if (queue.isEmpty()) {
                    sb.append("]").append("\n");
                    continue;
                }

                if (reverse) {
                    sb.append(queue.pollLast());

                    while (!queue.isEmpty()) {
                        sb.append(",").append(queue.pollLast());
                    }
                }
                else{
                    sb.append(queue.pollFirst());

                    while (!queue.isEmpty()) {
                        sb.append(",").append(queue.pollFirst());
                    }
                }
                sb.append("]").append("\n");
            }
            else{
                sb.append("error").append("\n"); //제거할 수 없으면 error 출력
            }
        }
        System.out.print(sb);
    }
}
