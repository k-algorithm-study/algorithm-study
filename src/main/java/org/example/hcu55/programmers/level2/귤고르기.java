package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 귤 고르기, Programmers(Level 2)
public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;     // 최솟값 카운트
        int mandarinSum = 0;        // 고를 귤의 개수
        HashMap<Integer, Integer> map = new HashMap<>();    // 귤 크기, 개수 저장 맵

        for (int mandarin : tangerine) {
            map.put(mandarin, map.getOrDefault(mandarin, 0) + 1);
        }

        ArrayList<Integer> mandarinCnt = new ArrayList<>(map.values());   // 귤 개수 리스트
        Collections.sort(mandarinCnt, Collections.reverseOrder());        // 귤 개수 큰거부터 정렬

        for (int count : mandarinCnt) {
            if (mandarinSum + count >= k) {     // 귤 개수가 k보다 크거나 같아질때까지 종류 증가 시킴
                answer++;
                break;
            } else {
                mandarinSum += count;
                answer++;
            }
        }
        return answer;
    }
}