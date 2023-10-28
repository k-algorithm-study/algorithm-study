package org.example.kw99j10.baekjoon.sort;

import java.util.*;

/**
 * 통계학 - Silver III
 */
public class Sort03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //수의 개수

        int[] arr = new int[n];
        var h = new HashMap<Integer, Integer>(); //최빈값을 구하기 위한 map

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            h.put(num, h.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr); //중앙값 & 범위를 구하기 위해 배열 정렬

        int sum = 0; //배열의 합

        for (int j : arr) {
            sum += j;
        }

        int avg = (int) Math.round((double) sum / arr.length); //산술 평균
        int middle = arr[arr.length / 2]; //중앙값
        int most = 0; //최빈값
        int range = arr[arr.length - 1] - arr[0]; //범위


        //map key:value -> 나온 숫자:나온 빈도
        //빈도 내림차순 정렬 -> 빈도가 같다면 숫자 오름차순 정렬
        var a = new ArrayList<>(h.entrySet());
        a.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });

        int tmp = 0; //임시 최빈값을 저장할 변수
        var most_answer = new ArrayList<Integer>(); //최빈값을 가지는 키를 담을 리스트
        for (Map.Entry<Integer, Integer> entry : a) {
            if (entry.getValue() >= tmp) {
                tmp = entry.getValue();
                most_answer.add(entry.getKey());
            }
        }
        Collections.sort(most_answer);
        most = most_answer.size() == 1
                ? most_answer.get(0) : most_answer.get(1);
        System.out.println(avg);
        System.out.println(middle);
        System.out.println(most);
        System.out.println(range);
    }
}
