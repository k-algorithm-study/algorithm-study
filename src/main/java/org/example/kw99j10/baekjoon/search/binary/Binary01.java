package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 숫자 카드 2 - Silver IV
 */
public class Binary01 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n]; //상근이의 숫자 카드

        var has = new HashMap<Integer, Integer>(); //예시 중 몇개를 갖고 있는 지
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            has.put(arr[i], has.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr); //이분 탐색을 위한 정렬

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int index = Arrays.binarySearch(arr, tmp);
            if (index >= 0) {
                sb.append(has.get(tmp)).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

        /**
         * Map을 이용한 풀이
         */
        /*int n = sc.nextInt();

        var has = new HashMap<Integer, Integer>(); //예시 중 몇개를 갖고 있는 지
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            has.put(tmp, has.getOrDefault(tmp, 0) + 1);
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if (!has.containsKey(tmp)) {
                sb.append(0).append(" ");
            }
            else{
                sb.append(has.get(tmp)).append(" ");
            }
        }
        System.out.println(sb);*/
    }
}
