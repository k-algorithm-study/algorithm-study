package org.example.kw99j10.programmers.lv1;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 카드 뭉치, programmers:Level 1
 */
public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        //꺼내기 쉽게 하도록 카드 뭉치를 배열 -> 리스트 옮겨 담음
        var cardList1 = new LinkedList<String>();
        var cardList2 = new LinkedList<String>();

        Collections.addAll(cardList1, cards1);
        Collections.addAll(cardList2, cards2);

        //반복문을 통해 목표 배열의 문자열이 나오지 않으면 종료
        for (String goalCard : goal) {

            //goal 의 크기 > list 의 크기 라면 예외 처리
            if (!cardList1.isEmpty() && cardList1.peekFirst().equals(goalCard)) {
                cardList1.removeFirst();
            }
            else if (!cardList2.isEmpty() && cardList2.peekFirst().equals(goalCard)) {
                cardList2.removeFirst();
            }
            else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
