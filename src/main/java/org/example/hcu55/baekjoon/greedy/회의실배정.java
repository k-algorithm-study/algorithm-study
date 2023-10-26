package org.example.hcu55.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 회의실 배정, 실버 I
public class 회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] meetingArr = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetingArr[i][0] = sc.nextInt();    // 회의 시작 시간 저장
            meetingArr[i][1] = sc.nextInt();    // 회의 종료 시간 저장
        }

        Arrays.sort(meetingArr, ((o1, o2) -> {  // 끝나는 시간이 빠른거 부터 정렬을 하는데
            if (o1[1] == o2[1]) {               // 끝나는 시간이 같아 버리면
                return o1[0] - o2[0];           // 시작 시간이 더 빠른거로 정렬을 한다.
            }
            return o1[1] - o2[1];               // https://charliezip.tistory.com/2
        }));

        int meetingCnt = 0;
        int meetingEndTime = 0;

        for (int i = 0; i < N; i++) {
            if (meetingEndTime <= meetingArr[i][0]) {   // 전 미팅 종료 시간이 다음 미팅 시작 시간보다 같거나 크면
                meetingEndTime = meetingArr[i][1];      // 갱신한다.
                meetingCnt++;
            }
        }
        System.out.println(meetingCnt);
    }
}
