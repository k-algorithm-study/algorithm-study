package org.example.hcu55.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

// 호텔 대실, Programmers(Level 2)
public class 호텔대실 {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];        // 시간 배정을 위한 이차원 배열

        for (int i = 0; i < book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));

            endTime += 10;      // 끝내는 시간에 10분(청소시간) 더해줌
            if (endTime % 100 >= 60) {      // 뒷자리가 60분이 넘는다면
                endTime += 40;      // 시간 단위 올려줌
            }
            bookTime[i][0] = startTime;
            bookTime[i][1] = endTime;
        }

        Arrays.sort(bookTime, (o1, o2) -> {
            if (o1[0] > o2[0]) {           // 시작 시간이 빠른 순으로 정렬
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                if (o1[1] > o2[1]) {       // 시작 시간이 같다면 종료 시간 빠른 순으로 정렬
                    return 1;
                } else
                    return -1;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] Time : bookTime) {
            if (queue.size() == 0) {    // 방에 예약이 없는 경우
                queue.add(Time[1]);     // 종료 시간 저장
                continue;
            }
            if ((queue.peek()) <= Time[0]) {    // 방에 다음 시작시간이 가능한 경우
                queue.poll();
                queue.add(Time[1]);
            } else {
                queue.add(Time[1]);     // 새방 배정
            }
        }
        return queue.size();
    }
}
