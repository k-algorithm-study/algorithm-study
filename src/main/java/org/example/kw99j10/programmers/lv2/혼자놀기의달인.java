package org.example.kw99j10.programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {

        boolean[] visit = new boolean[cards.length + 1]; //상자의 방문을 확인할 배열

        //그룹 점수를 내림차순으로 저장
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {

            int count = 0; //그룹을 이루는 상자의 개수
            int tmp = i; //임의의 상자

            //방문 확인
            while (!visit[tmp]) {
                count += 1;
                visit[tmp] = true;
                tmp = cards[tmp] - 1;
            }
            queue.add(count);
        }

        //1번 상자 그룹을 제외하고 남는 상자가 없으면 0점
        return queue.size() < 2 ? 0 : queue.poll() * queue.element();
    }
}
