package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 개똥벌레 - Gold V
 */
public class Binary10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //항상 짝수
        int m = Integer.parseInt(st.nextToken());

        //장애물(석순(아래) -> 종유석(위) 순서로 번갈아 나타남)
        int[] down = new int[500001];
        int[] up = new int[500001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                down[k] += 1; //석순 부터 시작
            }
            else{
                up[k] += 1;
            }
        }
        for (int i = m; i >= 2; i--) {
            up[i - 1] += up[i];
            down[i - 1] += down[i];
        }

        var sum = new ArrayList<Integer>(); //장애물 개수의 누적합
        for (int i = 1; i <= m; i++) {
            sum.add(up[i] + down[m + 1 - i]);
        }

        Collections.sort(sum);

        int count = 0; //구간의 수
        for (Integer integer : sum) {
            if (!sum.get(0).equals(integer)) {
                break;
            }
            count += 1;
        }
        System.out.println(sum.get(0) + " " + count);
    }
}
