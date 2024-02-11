package org.example.hcu55.baekjoon.sort;

import java.util.*;

// 강의실 배정, 골드 V
public class 강의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Lesson> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();   // 시작시간
            int end = sc.nextInt();     // 종료시간

            list.add(new Lesson(start, end));
        }

        Collections.sort(list);                           // 시작 시간으로 정렬

        Queue<Integer> queue = new PriorityQueue<>();     // 수업 종료 시간을 입력하기 위한 우선순위 큐

        for (Lesson l : list) {

            int endTime = l.end;

            if (!queue.isEmpty() && queue.peek() <= l.start) {    // 큐에 있는 종료 시간이 현재 시작 시간보다 작으면
                queue.poll();                                     // 큐에서 제거
            }
            queue.add(endTime);                                   // 아니면 큐에 추가
        }
        System.out.println(queue.size());
    }

    public static class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            if (this.start == o.start) {            // 시작 시간이 같다면
                return this.end - o.end;            // 종료 시간이 빠른 순으로 정렬
            } else return this.start - o.start;
        }
    }
}
