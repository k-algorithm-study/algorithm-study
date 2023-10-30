package org.example.hcu55.programmers.level1;

// 카드 뭉치, Programmers(Level 1)
public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int card1Index = 0;
        int card2Index = 0;

        for (int i = 0; i < goal.length; i++) {
            if (card1Index < cards1.length && goal[i].equals(cards1[card1Index])) {
                card1Index++;
            } else if (card2Index < cards2.length && goal[i].equals(cards2[card2Index])) {
                card2Index++;
            } else {
                answer = "No";
                return answer;
            }
        }
        answer = "Yes";
        return answer;
    }
}
