package org.example.hcu55.swea.D3;

import java.util.*;
import java.io.*;

public class 단순2진암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j) - '0';        // !주의 공백이 없어서 첨에 nextToken 쓰면 안됨
                }
            }

            // 뒤에서 부터 1로 시작하는 문자부터 찾아 앞으로 56개 숫자 배열에 따로 저장하기
            int[] code = new int[56];
            for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (arr[i][j] == 1) {                       // 뒤에서부터 1로 시작하는 지점 찾아서
                        int index = 0;
                        for (int k = j - 55; k <= j; k++) {
                            code[index++] = arr[i][k];          // 해당 인덱스 저장
                        }
                        break;                                  // 한 줄 만 찾으면 종료 시켜 버리기
                    }
                }
            }

            // 56개 숫자를 이제 7개씩 나눠서 변환한 수를 배열에 저장하기
            int[] convCode = new int[8];                       // 8자리 변환된 저장 배열
            String str;                                        // switch case 문 쓰기 위해 문자열 변환 변수
            int index2 = 0;

            for (int i = 0; i < code.length; i += 7) {
                str = "";
                for (int j = i; j < i + 7; j++) {
                    str += code[j];
                }
                convCode[index2++] = convert(str);            // 변환 함수 사용
            }

            // 변환된 수 검증하기
            int sum = 0;                                      // 10으로 나눠지는 지 확인 변수
            int resultSum = 0;                                // 최종 합 변수
            for (int i = 0; i < convCode.length; i++) {
                if (i % 2 == 0) {
                    sum += (convCode[i] * 3);
                } else {
                    sum += convCode[i];
                }
                resultSum += convCode[i];
            }

            if (sum % 10 == 0) {                // 10으로 나누어 떨어지면
                System.out.println("#" + testCase + " " + resultSum);
            } else {
                System.out.println("#" + testCase + " " + 0);
            }
        }
    }

    // 변환 함수
    public static int convert(String str) {
        switch (str) {
            case "0001101":
                return 0;
            case "0011001":
                return 1;
            case "0010011":
                return 2;
            case "0111101":
                return 3;
            case "0100011":
                return 4;
            case "0110001":
                return 5;
            case "0101111":
                return 6;
            case "0111011":
                return 7;
            case "0110111":
                return 8;
            case "0001011":
                return 9;
        }
        return -1;
    }
}
