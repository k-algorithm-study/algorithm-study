package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 한번 사용한 객실은 퇴실 시간 기준 10분간 청소 (손님 이용x)
// book_time 손님들의 예약시간
// return -> 필요한 최소 객실 수
public class 호텔대실 {

  public int solution(String[][] book_time) {
    Integer[][] bookTime = new Integer[book_time.length][2];
    for (int i = 0; i < book_time.length; i++) {
      Integer startTime = Integer.valueOf(book_time[i][0].replace(":", ""));
      Integer endTime = Integer.valueOf(book_time[i][1].replace(":", ""));
      // 10분 청소 시간 추가
      endTime += 10;
      if (endTime % 100 >= 60) {
        endTime += 40; // 15 : 56 => 1556 => 1556 + 40 = 1606 => 16 : 06
      }
      bookTime[i][0] = startTime;
      bookTime[i][1] = endTime;
    }
    // 시작 시간이 빠른 순 => 같다면, 종료 시간이 빠른 순 정렬
    Arrays.sort(bookTime, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    // 종료 시간이 가장 빠른 방부터 꺼내는 순서를 보장 하기 위해 우선 순위 큐 사용
    PriorityQueue<Integer> room = new PriorityQueue<>((Comparator.comparing(o -> o)));
    for (int i = 0; i < bookTime.length; i++) {
      if (room.isEmpty()) {
        room.add(bookTime[i][1]); // 종료 시간 저장
        continue;
      }
      Integer existedRoom = room.peek();
      if (bookTime[i][0] >= existedRoom) {
        room.poll();
        room.add(bookTime[i][1]);
      } else {
        room.add(bookTime[i][1]);
      }
    }
    return room.size();
  }

}
