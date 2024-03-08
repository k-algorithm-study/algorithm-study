package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 입국심사 - Gold V
 */
public class Binary14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken()); //심사 시간
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        long answer = 0;
        long start = 0;
        long end = (long) m * max; //최댓값

        while (start <= end) {
            long mid = (start + end) / 2;

            long count = 0; //심사 받을 수 있는 사람 수
            for (int i = 0; i < n; i++) {
                count += (mid / arr[i]);

                if (count >= m) {
                    break; //m명을 넘어가면 종료
                }
            }

            if (count >= m) {
                answer = mid;
                end = mid - 1; //최대 심사 수
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
