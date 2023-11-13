package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/150368
public class 이모티콘할인행사 {

  private int[] sales = {10, 20, 30, 40};
  private int sub = 0; // 최대 총 서비스 가입자
  private int earn = 0; // 최대 총 판매 금액

  public int[] solution(int[][] users, int[] emoticons) {
    int[] answer = new int[2];
    int[] discount = new int[emoticons.length];
    dfs(discount, 0, users, emoticons);
    answer[0] = sub;
    answer[1] = earn;
    return answer;
  }

  // dfs로 각 이모티콘에 대한 할인율 적용 후, calculate() 호출 => 완전 탐색
  private void dfs(int[] discount, int depth, int[][] users, int[] emoticons) {
    if (depth == discount.length) {
      calculate(discount, users, emoticons);
      return;
    }
    for (int i = 0; i < 4; i++) {
      discount[depth] = sales[i];
      dfs(discount, depth + 1, users, emoticons);
    }
  }

  // 적용된 각 이모티콘에 대한 할인율에 따라 계산 후, 서비스 가입자(sub) 및 판매액(earn) 갱신
  private void calculate(int[] discounts, int[][] users, int[] emoticons) {
    int subTmp = 0; // 임시 총 서비스 가입자
    int earnTmp = 0; // 임시 총 판매 금액

    // 사용자마다 서비스 가입 및 판매액 확인
    for (int[] user : users) {
      int discount = user[0];
      int price = user[1];
      int sum = 0; // 이모티콘 총 판매액

      // 현재 할인율이 사용자의 기준보다 크면, 할인 적용후 판매액 갱신
      for (int i = 0; i < discounts.length; i++) {
        if (discounts[i] >= discount) {
          sum += (emoticons[i] / 100) * (100 - discounts[i]);
        }
      }

      // 사용자의 서비스 가입 기준 금액을 초과하면 가입
      // 그렇지 않으면 판매액 증가
      if (sum >= price) {
        subTmp++;
      } else {
        earnTmp += sum;
      }
    }

    // 이전 할인율에서 계산했던 총 서비스 가입자 수보다 더 많으면 현재 구해진 가입자와 판매액 모두 갱신
    // 이전 할인율에서 계산했던 총 서비스 가입자 수와 같다면 현재 구해진 판매액과 비교해서 판매액만 더 큰것으로 갱신
    if (subTmp > sub) {
      sub = subTmp;
      earn = earnTmp;
    } else if (subTmp == sub) {
      if (earn < earnTmp) {
        earn = earnTmp;
      }
    }
  }

}
