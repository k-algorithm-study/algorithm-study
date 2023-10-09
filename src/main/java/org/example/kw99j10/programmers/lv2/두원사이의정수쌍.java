package org.example.kw99j10.programmers.lv2;

import java.util.Scanner;
/**
 *  두 원 사이의 정수 쌍, programmers:Level 2
 */
public class 두원사이의정수쌍 {
    static long solution(int r1, int r2) {
        long answer = 0;

        //r1: 작은 원의 반지름, r2: 큰 원의 반지름
        double r_distance1 = Math.pow(r1, 2);
        double r_distance2 = Math.pow(r2, 2);

        //하나의 사분면에 대하여 for문 실행
        for (int i = 1; i <= r2; i++) {

            /**
             * 좌표는 정수이기 때문에 long형으로 타입 형 변환
             * 이 때, 좌표는 큰 원의 반지름과 작은 원의 반지름 사이에 존재하는 좌표를 구함
             */
            long distance1 = (long) Math.floor(Math.sqrt(r_distance2 - Math.pow(i, 2)));
            long distance2 = (long) Math.ceil(Math.sqrt(r_distance1 - Math.pow(i, 2)));
            answer += distance1 - distance2 + 1; //원점 값 중복 제거
        }
        answer *= 4; //4사분면이므로 4를 곱함
        return answer;
    }

    //test를 위한 psvm문
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        System.out.println(solution(r1, r2));
    }
}
