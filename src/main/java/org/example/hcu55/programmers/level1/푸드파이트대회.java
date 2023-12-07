package org.example.hcu55.programmers.level1;

// 푸드 파이트 대회, Programmers(Level 1)
public class 푸드파이트대회 {
    public String solution(int[] food) {
        String answer = "";
        String leftFood = "";
        String rightFood = "";

        for (int i = 1; i < food.length; i++) {
            for (int j = 1; j <= food[i] / 2; j++) {
                leftFood += i;
            }
        }

        for (int i = food.length - 1; i >= 1; i--) {
            for (int j = food[i] / 2; j >= 1; j--) {
                rightFood += i;
            }
        }
        answer = leftFood + "0" + rightFood;
        return answer;
    }
}
