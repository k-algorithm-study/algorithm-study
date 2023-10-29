package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 좌료 압축, 실버II
public class 좌표압축 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] originArr = new int[N];	// 원본 배열
        int[] sortedArr = new int[N];	// 정렬 한 배열
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            originArr[i] = sortedArr[i] = sc.nextInt();
        }

        Arrays.sort(sortedArr); // 크기 순 정렬

        int rank = 0;
        for(int num : sortedArr) {
            if(!map.containsKey(num)) {     // map에 없는거만 정렬된 수와 순위 등록
                map.put(num, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : originArr) {
            int value = map.get(key);
            sb.append(value).append(' ');
        }

        System.out.println(sb);
    }
}
