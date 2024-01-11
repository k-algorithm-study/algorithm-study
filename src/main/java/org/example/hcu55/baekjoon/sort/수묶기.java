package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 수 묶기, 골드 IV
public class 수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int minus = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] <= 0) {   // 음수의 개수 세기
                minus++;
            }
        }

        Arrays.sort(arr);       // 정렬

        int result = 0;

        for (int i = 1; i < minus; i += 2) {      // 음수 두개 일때 곱하는 것이 최댓값
            result += arr[i - 1] * arr[i];
        }

        if (minus % 2 == 1) {                     // 음수의 개수가 홀수개일 경우 양수와 곱해주면 X -> 음수를 그냥 더해주는 것이 최댓값
            result += arr[minus - 1];
        }

        if ((N - minus) % 2 == 1) {               // 양수의 개수가 홀수개일 경우 가장 작은 양수를 더함
            result += arr[minus];
        }

        for (int i = N - 1; i > minus; i -= 2) {    // 나머지 양수를 그냥 더하는 것과 두 수를 묶어 곱한 값 중 큰 값을 누적
            int sum = arr[i] + arr[i - 1];
            int mul = arr[i] * arr[i - 1];

            if (sum > mul)
                result += sum;
            else
                result += mul;
        }
        System.out.println(result);
    }
}
