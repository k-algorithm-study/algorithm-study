package org.example.yumyeonghan.programmers.level2;

import java.util.Map;
import java.util.TreeMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class 주차요금계산 {

  public int[] solution(int[] fees, String[] records) {

    // init TreeMap (key 값인 차량 번호로 오름차순 정렬을 하기위해)
    // `출차 - 입차` 하기 위함
    Map<String, Integer> map = new TreeMap<>();
    for (String record : records) {
      String[] splitRecord = record.split(" ");
      String[] splitTime = splitRecord[0].split(":");
      int time = (splitRecord[2].equals("IN") ? -1 : 1) * ((Integer.parseInt(splitTime[0]) * 60)
          + Integer.parseInt(splitTime[1]));
      String carNumber = splitRecord[1];
      map.put(carNumber, map.getOrDefault(carNumber, 0) + time);
    }

    int lastTime = 1439; // `23:59` = (23 * 60) + 59
    int[] answer = new int[map.size()];
    int answerIndex = 0;

    for (String carNum : map.keySet()) {
      int time = map.get(carNum);
      // 시간이 음수면, 입차만 했다라는 의미이므로 lastTime(23:59)을 더해줘야함
      time = time <= 0 ? time + lastTime : time;

      // 기본 시간보다 작으면, 0
      // 기본 시간보다 크면 그대로 사용
      double cumulativeTime = time - fees[0] < 0 ? 0 : time - fees[0];
      int price = fees[1] + (int) Math.ceil(cumulativeTime / fees[2]) * fees[3];
      answer[answerIndex++] = price;
    }
    return answer;
  }

}
