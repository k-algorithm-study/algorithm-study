package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/150369
public class 택배배달과수거하기 {

  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    // 배달과 수거를 마지막 집부터 해야 최소 이동거리를 구할 수 있음
    int deliveryStart = n - 1;
    int pickupStart = n - 1;

    int deliverySum = Arrays.stream(deliveries).sum();
    int pickupSum = Arrays.stream(pickups).sum();

    while (true) {
      int deliveryCap = cap;
      int pickupCap = cap;
      int index = -1; // 가장 마지막 집 위치 이며, (index + 1) * 2를 통해 왔다 갔다를 계산

      // 배달
      for (int i = deliveryStart; i >= 0; i--) {
        if (deliveries[i] > 0) {
          index = Math.max(index, i);
          if (deliveries[i] <= deliveryCap) {
            deliveryCap -= deliveries[i];
            deliverySum -= deliveries[i];
            deliveries[i] = 0;
          } else {
            deliveries[i] -= deliveryCap;
            deliveryStart = i;
            deliverySum -= deliveryCap;
            break;
          }
        }
      }
      // 수거
      for (int i = pickupStart; i >= 0; i--) {
        if (pickups[i] > 0) {
          index = Math.max(index, i);
          if (pickups[i] <= pickupCap) {
            pickupCap -= pickups[i];
            pickupSum -= pickups[i];
            pickups[i] = 0;
          } else {
            pickups[i] -= pickupCap;
            pickupStart = i;
            pickupSum -= pickupCap;
            break;
          }
        }
      }

      if (index >= 0) {
        answer += (index + 1) * 2;
      }
      if (deliverySum == 0 && pickupSum == 0) {
        break;
      }
    }
    return answer;
  }

}
