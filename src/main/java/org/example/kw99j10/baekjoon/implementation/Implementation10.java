package org.example.kw99j10.baekjoon.implementation;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 프린터 큐 - Silver III
 */
public class Implementation10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt(); //테스트케이스 수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test_case; i++) {
            int n = sc.nextInt(); //문서의 개수
            int m = sc.nextInt(); //궁금한 문서의 위치

            var queue = new LinkedList<int[]>(); //문서와 그 중요도를 담을 큐
            for (int j = 0; j < n; j++) {
                queue.add(new int[]{j, sc.nextInt()}); //해당 문서, 중요도
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                int doc = current[0];
                int importance = current[1];

                boolean b = true; //가장 큰 중요도를 가진 문서를 판단

                for (int j = 0; j < queue.size(); j++) {

                    //현재 주어진 문서보다 중요도가 높다면
                    if (queue.get(j)[1] > importance) {
                        queue.add(current);

                        //이전까지의 문서를 뒤로 재배치 후 반복문 종료
                        for (int k = 0; k < j; k++) {
                            queue.add(queue.poll());
                        }

                        b = false;
                        break;
                    }
                }

                if (!b) {
                    continue;
                }
                count += 1;

                if (doc == m) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
