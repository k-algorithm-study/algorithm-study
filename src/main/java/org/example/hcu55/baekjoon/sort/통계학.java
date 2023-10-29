package org.example.hcu55.baekjoon.sort;

import java.util.*;

// 통계학, 실버III
public class 통계학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numList = new int[N];

        double sum = 0;    // 산술평균

        for (int i = 0; i < N; i++) {
            numList[i] = sc.nextInt();
            sum += numList[i];
        }

        Arrays.sort(numList);   // 정렬

        // 최빈값 찾기
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numList) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int mode = 0;

        // 최빈값과 빈도수를 찾음
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        List<Integer> secondModeList = new ArrayList<>();

        // 최빈값과 동일한 빈도수를 갖는 원소들을 추려냄
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) == maxFrequency) {
                secondModeList.add(entry.getKey());
            }
        }
        Collections.sort(secondModeList);
        mode = secondModeList.get(secondModeList.size() == 1 ? 0 : 1);

        System.out.println(Math.round(sum / N));    // 산술평균
        System.out.println(numList[(N - 1) / 2]);   // 중앙값
        System.out.println(mode);  // 최빈값
        System.out.println(numList[N - 1] - numList[0]);    // 범위
    }
}
