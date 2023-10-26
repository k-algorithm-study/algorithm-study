package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

// 잃어버린 괄호, 실버 II
public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        String[] plusList = sc.nextLine().split("-");   // 처음 입력을 "-" 기준으로 나눔

        for (int i = 0; i < plusList.length; i++) {
            int temp = 0;

            String[] addStr = plusList[i].split("\\+"); // 다음은 + 끼리 먼저 더해주기 위해 "+" 문자 기준으로 나눔

            for (String num : addStr) {     // 숫자로 바꿔서 더하기
                temp += Integer.parseInt(num);
            }

            if (i == 0) {       // 첫번째 숫자는 빼는게 아니라 더해줌
                answer += temp;
            } else {
                answer -= temp; // 나머지들은 첫번째 숫자에서 다 빼버림
            }
        }
        System.out.println(answer);
    }
}
