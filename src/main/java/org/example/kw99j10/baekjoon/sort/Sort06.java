package org.example.kw99j10.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 신입 사원 - Silver I
 */
public class Sort06 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken()); //테스트 케이스 개수

        for (int i = 0; i < t; i++) {

            int max = 0; //선발할 수 있는 최대 신입사원 수

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //지원자 수

            int[][] arr = new int[n][2]; //지원자의 서류심사, 면접 성적을 담을 배열

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken()); //서류심사 성적
                arr[j][1] = Integer.parseInt(st.nextToken()); //면접 성적
            }

            //서류심사 성적 기준 오름차순 정렬
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int min_apply_doc = arr[0][0];
            int min_apply_interview = arr[0][1];

            for (int j = 1; j < n; j++) {

                int apply_doc = arr[j][0];
                int apply_interview = arr[j][1];

                if (apply_doc >= min_apply_doc || apply_interview >= min_apply_interview) {
                    max += 1;
                }

                boolean k = true;

                for (int s = 0; s < n; s++) {

                    if (s == j) {
                        continue;
                    }

                    int tmp_doc = arr[s][0];
                    int tmp_interview = arr[s][1];

                    //서류 점수와 면접 점수 등수 > 다른 사람의 서류 점수와 면접 점수 등수
                    if (apply_interview > tmp_interview && apply_doc > tmp_doc) {
                        k = false;
                        break;
                    }
                }
                if (k) {
                    max += 1;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
