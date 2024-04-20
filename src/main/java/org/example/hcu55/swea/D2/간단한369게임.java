package org.example.hcu55.swea.D2;

import java.util.*;

public class 간단한369게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String number = Integer.toString(i);             // 숫자를 문자열 변환
            int count = 0;                                   // 3,6,9 개수 카운트 변수

            for (int j = 0; j < number.length(); j++) {      // 한자리씩
                if (number.charAt(j) == '3' || number.charAt(j) == '6' || number.charAt(j) == '9') {    // 하나라도 포함되면
                    count++;
                }
            }

            if (count > 0) {                                            // 카운트 없으면 그냥 출력하기
                number = number.replaceAll(".", "");   // 여기 구조를 좀 바꿔보고 싶음(문자열 전체를 빈칸으로 만듬)
                for (int k = 0; k < count; k++) {
                    number += "-";                                      // 빈 문자열에 카운트 개수만큼 "-" 추가 하기
                }
            }

            System.out.print(number + " ");
        }
    }
}