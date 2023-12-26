package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class 할인행사 {

  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    // date 로부터 연속되는 10일을 탐색해야하므로 `discount.length - 9` 로 제한함
    for (int date = 0; date < discount.length - 9; date++) {
      int solvedItem = 0; // 정현이가 원하는 해결된 제품 수 (banana가 해결되면 +1 됨)
      for (int wantedItemIndex = 0; wantedItemIndex < want.length; wantedItemIndex++) {
        int itemCount = 0; // 각 아이템의 할인 횟수

        // date 로부터 +10 까지 순회 (1일차면 10일차까지 탐색)
        for (int searchItemIndex = date; searchItemIndex < date + 10; searchItemIndex++) {
          if (discount[searchItemIndex].equals(want[wantedItemIndex])) {
            itemCount += 1; // 연속되는 10일차 안에 원하는 제품이 할인 품목으로 있으면 +1
          }
        }

        // 해당 아이템의 할인 횟수와 정현이가 원하는 할인 횟수가 다르면 날짜 변경 (1일차 -> 2일차로)
        // 할인 횟수가 같다면 해당 아이템은 해결된 아이템이기 때문에 solvedItem + 1
        if (itemCount < number[wantedItemIndex]) {
          break;
        } else {
          solvedItem += 1;
        }
      }

      // 해결된 제품 수와 정현이가 원하는 제품 수가 같다면 해당 날짜에는 회원가입 할 수 있으므로 정답 +1
      if (solvedItem == want.length) {
        answer += 1;
      }
    }
    return answer;
  }

}
