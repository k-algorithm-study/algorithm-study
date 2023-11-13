package org.example.kw99j10.programmers.lv2;

import java.util.Scanner;

/**
 * 마법의 엘리베이터, programmers:Level 2
 */
public class 마법의엘리베이터 {
    public static int solution(int storey) {

        int answer = 0; //버튼을 누르는 횟수

        //엘리베이터가 0층에 도착하면 반복문 종료 (cf: 항상 최소한의 버튼을 눌러야함)
        while (storey != 0) {

            //현재 층수를 10의 배수로 나눴을 때 나머지를 확인
            int div = storey % 10;

            //나머지가 6 이상: 올라갔다가 내려가는 경우가 빠른 경우
            if (div >= 6) {
                answer += 10 - div;
                storey += 10 - div;
            }

            //나머지가 5 일때: 해당 숫자 앞의 숫자를 고려
            else if (div == 5) {
                int tmp = storey / 10 % 10;

                if (tmp >= 5) {
                    answer += 10 - div;
                    storey += 10 - div;
                }
                else{
                    answer += div;
                }
            }

            //나머지가 5 이하: 내려가는 버튼만 누르면 되는 경우 (나머지가 5 이하)
            else {
                answer += div;
            }
            System.out.println(storey + " " + answer);
            storey = storey / 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
