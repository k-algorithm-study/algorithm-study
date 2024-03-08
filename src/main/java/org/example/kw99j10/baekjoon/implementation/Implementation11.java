package org.example.kw99j10.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 치킨 배달 - Gold V
 */
public class Implementation11 {
    static int n, m;
    static int[][] arr;
    static boolean[] visit;
    static ArrayList<int[]> home; //집
    static ArrayList<int[]> chicken; //치킨 집
    static int min = Integer.MAX_VALUE; //치킨 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //0: 빈칸, 1: 집, 2: 치킨 집

        arr = new int[n][n];

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    home.add(new int[]{i, j}); //집
                }

                if (arr[i][j] == 2) {
                    chicken.add(new int[]{i, j}); //치킨 집
                }
            }
        }
        visit = new boolean[chicken.size()]; //치킨 집의 개수만큼 방문 배열을 선언
        searchMinDistance(0, 0); //완전 탐색 - 조합
        System.out.println(min);
    }

    static void searchMinDistance(int idx, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        int x = Math.abs(home.get(i)[0] - chicken.get(j)[0]);
                        int y = Math.abs(home.get(i)[1] - chicken.get(j)[1]);
                        tmp = Math.min(tmp, (x + y)); //치킨 거리를 계산
                    }
                }
                sum += tmp;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            visit[i] = true;
            searchMinDistance(i + 1, cnt + 1);
            visit[i] = false;
        }
    }
}
