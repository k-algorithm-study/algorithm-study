package org.example.kw99j10.programmers.lv2;

import java.util.LinkedList;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        var deliver = new LinkedList<int[]>();
        var pickup = new LinkedList<int[]>();

        //배달 or 수거할 택배가 있는 집의 상자 개수와 위치를 담음
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deliver.add(new int[]{deliveries[i], i + 1});
            }
            if (pickups[i] != 0) {
                pickup.add(new int[]{pickups[i], i + 1});
            }
        }
        int sum; //택배 상자의 합
        int dist; //이동 거리

        while (!deliver.isEmpty() || !pickup.isEmpty()) {

            sum = 0;
            dist = 0;

            while (!deliver.isEmpty()) {
                if (sum >= cap) {
                    break;
                }
                int[] poll = deliver.pollLast(); //마지막 요소(거리가 가장 긴 집)

                dist = Math.max(dist, poll[1]);

                //cap(최대 개수)까지 상자를 담음
                if (cap >= sum + poll[0]) {
                    sum += poll[0];
                }

                //해당 집에 배달할 상자가 남았다면 다시 리스트에 더한 후 반복문 종료
                else {
                    poll[0] -= (cap - sum);
                    deliver.add(poll);
                    break;
                }
            }
            System.out.println(dist);

            sum = 0;
            while (!pickup.isEmpty()) {
                if (sum >= cap) {
                    break;
                }
                int[] poll = pickup.pollLast(); //마지막 요소(거리가 가장 긴 집)

                dist = Math.max(dist, poll[1]);

                if (cap >= sum + poll[0]) {
                    sum += poll[0];
                }

                //해당 집에 수거할 상자가 남았다면 다시 리스트에 더한 후 반복문 종료
                else {
                    poll[0] -= (cap - sum);
                    pickup.add(poll);
                    break;
                }
            }
            answer += dist * 2L; //최소 거리 까지의 왕복
        }
        return answer;
    }
}
