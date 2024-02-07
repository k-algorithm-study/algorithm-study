package org.example.kw99j10.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실 배정 - Gold V
 * <p>
 * cf)
 * 강의실 배정 -> 최소 강의장 개수
 * 회의실 배정 -> 하나의 회의실에 사용할 수 있는 최대 회의 개수
 */
public class Sort12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //시작 시간
            int end = Integer.parseInt(st.nextToken()); //종료 시간
            queue.offer(new int[]{start, end});
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>(); //필요한 방의 개수를 담을 큐
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int s = current[0];
            int p = current[1];
            if (!rooms.isEmpty() && s >= rooms.peek()) {
                rooms.poll(); //수업이 끝난 직후 다음 수업 시작 가능
            }
            rooms.add(p); //강의실이 더 필요
        }
        System.out.println(rooms.size()); //필요한 강의실 수
    }
}
