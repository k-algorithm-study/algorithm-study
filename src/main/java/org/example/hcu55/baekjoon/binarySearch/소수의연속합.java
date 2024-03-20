package org.example.hcu55.baekjoon.binarySearch;

import java.util.*;

// 소수의 연속합, 골드 III
public class 소수의연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 1. 소수 구하기 (에라토스테네스의 체)
        boolean[] prime = new boolean[N + 1];
        ArrayList<Integer> prime_numbers = new ArrayList<>();

        prime[0] = prime[1] = true;             // 소수 아니면 true

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!prime[i]) {
                prime_numbers.add(i);           // 소수 저장
            }
        }

        // 2. 연속합으로 주어진 정수 구할 수 있는지 판별
        int r = 0, l = 0; //투 포인터
        int count = 0, sum = 0;
        int size = prime_numbers.size();

        while (r < size) {          // 오른쪽 포인터가 끝에 도달할 때 까지
            if (sum > N) {          // 누적합이 N보다 클 경우 왼쪽 값 빼고 포인터 옮기기
                sum -= prime_numbers.get(l++);

            } else if (sum < N) {   // 누적합이 N보다 작을 경우 오른쪽 값 더하고 포인터 옮기기
                sum += prime_numbers.get(r++);

            } else {                // 누적합과 N이 같을 경우 count 증가 후 왼쪽 값 빼고 포인터 옮기기
                count++;
                sum -= prime_numbers.get(l++);
            }
        }

        // 마지막 소수의 값이 N과 같을 경우 count 증가
        // size > 0 => N이 1일 경우
        if (size > 0 && prime_numbers.get(--r) == N) {
            count++;
        }

        System.out.println(count);
    }
}