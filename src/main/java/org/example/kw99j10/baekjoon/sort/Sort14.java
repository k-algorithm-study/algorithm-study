package org.example.kw99j10.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  N번째 큰 수 - Silver II
 */
public class Sort14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.add(Integer.valueOf(st.nextToken()));
            }
        }
        for (int i = 1; i < n; i++) {
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
