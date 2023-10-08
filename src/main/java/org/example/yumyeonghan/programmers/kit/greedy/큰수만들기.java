package org.example.yumyeonghan.programmers.kit.greedy;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class 큰수만들기 {

    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = number.length();
        int searchNumber = 0;

        for (int i = 0; i < len - k; i++) {
            int max = 0;
            for (int j = searchNumber; j < i + k + 1; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    searchNumber = j + 1;
                }
            }
            stringBuilder.append(max);
        }
        return stringBuilder.toString();
    }

}
