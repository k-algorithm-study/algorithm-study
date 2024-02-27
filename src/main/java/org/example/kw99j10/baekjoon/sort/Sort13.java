package org.example.kw99j10.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 전화번호 목록 - Gold IV
 */
public class Sort13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            String answer = "YES";
            int n = Integer.parseInt(br.readLine());

            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j] = st.nextToken();
            }
            Arrays.sort(arr); //문자열 정렬 => 접두어가 같다면 붙어 있음

            //문자열 포함 여부 확인을 위해 startsWith 사용
            for (int j = n - 1; j > 0; j--) {
                if (arr[j].startsWith(arr[j - 1])) {
                    answer = "NO";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
