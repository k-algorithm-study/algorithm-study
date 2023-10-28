package org.example.kw99j10.baekjoon.sort;
import java.util.*;

/**
 * 좌표 압축 - Silver II
 */

public class Sort04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n]; //입력을 저장할 배열

        var h = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            h.put(num, 0); //map 초기화
        }

        //좌표 압축을 위해 key 값이 작은 순으로 오름차순 정렬
        //좌표를 압축 min: 0, 같다면 같은 수로 압축
        var a = new ArrayList<>(h.entrySet());
        a.sort(Comparator.comparingInt(Map.Entry::getKey));

        int count = 0; //좌표 rank 변수

        for (Map.Entry<Integer, Integer> entry : a) {
            h.put(entry.getKey(), count++);
        }

        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(h.get(j)).append(" ");
        }
        System.out.print(sb);
    }
}
