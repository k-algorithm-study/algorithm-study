package org.example.hcu55.baekjoon.impl;

import java.util.LinkedList;
import java.util.Scanner;

// 프린터 큐, 실버 III
public class 프린터큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCase = sc.nextInt();    // 테스트 케이스

        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            LinkedList<int[]> queue = new LinkedList<>();    // Queue로 활용 할 연결리스트

            for (int j = 0; j < N; j++) {
                queue.offer(new int[]{j, sc.nextInt()});    // {초기 위치, 중요도}
            }

            int count = 0;

            while (!queue.isEmpty()) {

                int[] first = queue.poll();     // 가장 첫 원소
                boolean isMax = true;           // 맨 앞 원소가 가장 중요도가 원소인지를 판단하는 변수

                for (int k = 0; k < queue.size(); k++) {    // 큐에 남아있는 원소들과 중요도를 비교
                    if (first[1] < queue.get(k)[1]) {       // 처음 뽑은 원소보다 큐에 있는 k번째 원소가 중요도가 클 경우

                        queue.offer(first);
                        for (int j = 0; j < k; j++) {       // 뽑은 원소 및 k 이전의 원소들을 뒤로
                            queue.offer(queue.poll());
                        }

                        isMax = false;       // 첫 원소가 중요도가 안크므로
                        break;
                    }
                }

                if (isMax == false) {       // 첫 원소가 가장 큰 원소가 아니면 while문 반복
                    continue;
                }

                count++;                // 중요도가 최고였다면 카운트 증가
                if (first[0] == M) {    // 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}