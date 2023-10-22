package org.example.kw99j10.programmers.lv2;

import java.util.Scanner;

/**
 * 당구 연습, programmers:Level 2
 */

public class 당구연습 {

    /**
     * @param m: 당구대의 가로 길이
     * @param n: 당구대의 세로 길이
     * @param startX: 쳐야 하는 공의 x좌표
     * @param startY: 쳐야 하는 공의 y좌표
     * @param balls: 공들의 위치를 나타낸 2차원 배열
     * @return: 각 회마다 굴러간 거리의 최솟값의 제곱을 배열에 담아 return
     */
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        //선 대칭 경우의 수
        //{startX, -startY},{m + (m - startX), startY},{-startX, startY},{startX, n + (n - startY)}

        for (int i = 0; i < balls.length; i++) {

            int min = Integer.MAX_VALUE;

            int a = balls[i][0]; //공의 x 좌표
            int b = balls[i][1]; //공의 y 좌표

            //시작 좌표에서 공(좌표)까지의 거리
            double distance_x = Math.abs(startX - a);
            double distance_y = Math.abs(startY - b);

            int top = (int) (Math.pow(startX - a, 2)) + (int)(Math.pow(startY - (n + (n - b)), 2));
            int bottom= (int) (Math.pow(startX - a, 2)) + (int)(Math.pow(startY + b, 2));
            int left=(int) (Math.pow(startX - (-a), 2)) + (int)(Math.pow(startY - b, 2));
            int right=(int) (Math.pow(startX - (m + (m - a)), 2)) +(int) (Math.pow(startY - b, 2));

            if (distance_x == 0) {
                if (b>startY){
                    min=Math.min(bottom,Math.min(left,right));
                }
                else if (b<startY){
                    min=Math.min(top,Math.min(left,right));
                }
            }
            if (distance_y == 0){
                if (a>startX){
                    min=Math.min(top,Math.min(bottom,left));
                }
                else if (a<startX){
                    min=Math.min(top,Math.min(bottom,right));
                }
            }
            else{
                min=Math.min(top,Math.min(bottom,Math.min(left,right)));
            }
            answer[i] = min;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
