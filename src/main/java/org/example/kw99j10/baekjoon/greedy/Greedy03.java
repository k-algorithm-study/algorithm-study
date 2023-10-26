package org.example.kw99j10.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  회의실 배정 - Silver I
 */
public class Greedy03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //회의의 수

        int[][] room = new int[n][2]; //시작시간, 종료시간을 담을 배열

        for (int i = 0; i < n; i++) {
            room[i][0] = sc.nextInt(); //start_time
            room[i][1] = sc.nextInt(); //end_time
        }

        //최대한 많은 회의가 진행될 수 있도록 종료 시간을 기준으로 정렬함
        //이 때, 종료 시간이 같다면 시작 시간이 더 빠른 순으로 정렬
        // -> greedy 성질(최대한 많은 회의 배정 위함)
        Arrays.sort(room, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0; //시작할 수 있는 회의 수

        int meeting = room[0][1]; //첫 회의의 종료 시간을 기준으로 시작
        count += 1;
        for (int i = 1; i < room.length; i++) {
            int start = room[i][0]; //회의 종료 -> 회의 시작
            int end = room[i][1];

            if (meeting > start) {
                continue;
            }
            count += 1;
            meeting = end; //종료 시간을 갱신
        }
        System.out.println(count);
    }
}
