package org.example.kw99j10.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/**
 *  이차원 배열과 연산 - Gold IV
 */
public class Sort15 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rCount = 3;
        int cCount = 3;
        int time = 0;
        while (true) {
            if (arr[r][c] == k) {
                break;
            }
            if (time == 101) {
                time = -1;
                break;
            }

            time++;
            if (rCount >= cCount) {
                cCount = rCalculation(rCount, cCount);
            } else {
                rCount = cCalculation(rCount, cCount);
            }
        }
        System.out.println(time);
    }

    static int rCalculation(int rCount, int cCount) {
        int count = 0;
        HashMap<Integer, Integer> h; //수와 수의 빈도
        for (int i = 0; i < rCount; i++) {
            h = new HashMap<>();
            for (int j = 0; j < cCount; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                h.put(arr[i][j], h.getOrDefault(arr[i][j], 0) + 1);
                arr[i][j] = 0;
            }
            ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(h.entrySet());
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }); //수 빈도 오름차순 -> 같다면 그 수도 오름차순

            int size = list.size() * 2; //정렬 시 배열 크기가 2배
            size = Math.min(size, 100);
            for (int j = 0; j < size; j += 2) {
                arr[i][j] = list.get(j / 2).getKey();
                arr[i][j + 1] = list.get(j / 2).getValue();
            }
            count = Math.max(count, size);
        }
        return count;
    }

    private static int cCalculation(int rCount, int cCount) {
        int count = 0;
        HashMap<Integer, Integer> h; //수와 수의 빈도
        for (int i = 0; i < cCount; i++) {
            h = new HashMap<>();
            for (int j = 0; j < rCount; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
                h.put(arr[j][i], h.getOrDefault(arr[j][i], 0) + 1);
                arr[j][i] = 0;
            }
            ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(h.entrySet());
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            });

            int size = list.size() * 2;
            size = Math.min(size, 100);
            for (int j = 0; j < size; j += 2) {
                arr[j][i] = list.get(j / 2).getKey();
                arr[j + 1][i] = list.get(j / 2).getValue();
            }
            count = Math.max(count, size);
        }
        return count;
    }
}
