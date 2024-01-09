package org.example.kw99j10.programmers.lv1;

import java.util.Arrays;

/**
 * 최소 직사각형, programmers:Level 1
 *
 **/
public class 최소직사각형 {
    public int solution(int[][] sizes) {

        int length = sizes.length; //배열의 길이

        int[] wallet_height = new int[sizes.length]; //명함의 세로 길이를 담는 배열
        int[] wallet_width = new int[sizes.length]; //명함의 가로 길이를 담는 배열

        //눕혀서 계산할 수 있으므로 세로에 더 긴 길이를 담는다고 가정
        for (int i = 0; i < length; i++) {
            wallet_height[i] = Math.max(sizes[i][0], sizes[i][1]);
            wallet_width[i] = Math.min(sizes[i][0], sizes[i][1]);
        }

        //각 배열 정렬
        Arrays.sort(wallet_height);
        Arrays.sort(wallet_width);

        //모든 명함을 수납할 수 있는 가장 작은 지갑의 크기
        int minWallet = wallet_height[length - 1] * wallet_width[length - 1];

        return minWallet;
    }
}
