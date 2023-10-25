package org.example.yumyeonghan.programmers.kit.brute_force;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

  public int[] solution(int[] answers) {
    int[] 수포자1 = {1, 2, 3, 4, 5};
    int[] 수포자2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] 수포자3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int 수포자1답 = 0;
    int 수포자2답 = 0;
    int 수포자3답 = 0;

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == 수포자1[i % 수포자1.length]) {
        수포자1답++;
      }

    }

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == 수포자2[i % 수포자2.length]) {
        수포자2답++;
      }

    }

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == 수포자3[i % 수포자3.length]) {
        수포자3답++;
      }

    }

    List<Integer> answerList = new ArrayList<>();
    int[] tmp = {수포자1답, 수포자2답, 수포자3답};
    int value = Math.max(수포자3답, Math.max(수포자1답, 수포자2답));

    for (int i = 0; i < tmp.length; i++) {
      if (value == tmp[i]) {
        answerList.add(i + 1);
      }
    }

    int answer[] = new int[answerList.size()];
    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

}
