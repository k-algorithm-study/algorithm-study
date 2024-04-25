package org.example.hcu55.swea.D2;

import java.util.*;
import java.io.*;

public class 스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] sudoku = new int[9][9];         // 스도쿠 2차원 배열

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());     // 스도쿠 값 입력
                }
            }

            boolean check = true;                   // 겹치면 false로 변경

            // 가로, 세로 검증
            for (int i = 0; i < 9; i++) {
                Set<Integer> set1 = new HashSet<>();        // 가로 검증
                Set<Integer> set2 = new HashSet<>();        // 세로 검증

                for (int j = 0; j < 9; j++) {
                    set1.add(sudoku[i][j]);
                    set2.add(sudoku[j][i]);
                }
                if (set1.size() != 9) {
                    check = false;
                }
                if (set2.size() != 9) {
                    check = false;
                }
            }

            // 3 x 3 검증
            for (int x = 0; x < 9; x += 3) {
                for (int y = 0; y < 9; y += 3) {
                    Set<Integer> set = new HashSet<>();

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            set.add(sudoku[x + i][y + j]);
                        }
                    }
                    if (set.size() != 9) {
                        check = false;
                    }
                }
            }

            int c = check ? 1 : 0;        // boolean -> int 형 변환
            System.out.println("#" + testCase + " " + c);
        }
    }
}