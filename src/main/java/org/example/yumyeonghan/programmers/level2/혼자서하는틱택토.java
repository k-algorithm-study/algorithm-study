package org.example.yumyeonghan.programmers.level2;

public class 혼자서하는틱택토 {

  static boolean visit[][];

  public int solution(String[] board) {
    int answer = 1;
    int oCnt = 0;
    int xCnt = 0;
    int successO = 0;
    int successX = 0;
    visit = new boolean[3][3];

    // 보드의 각 칸을 순회하면서 O 와 X 의 개수를 셈
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length(); j++) {
        if (board[i].charAt(j) == 'O') {
          oCnt++;
        } else if (board[i].charAt(j) == 'X') {
          xCnt++;
        }
      }
    }

    // O보다 X가 많을 때는 승부 불가능이므로 0을 반환
    if (xCnt > oCnt) {
      return 0;
    }

    // O이 X보다 2개 더 많을 때도 승부 불가능이므로 0을 반환 (쵀대 1개가 더 많을 수 있음)
    if (xCnt + 1 < oCnt) {
      return 0;
    }
    successO += check(board, 'O', "OOO");
    successX += check(board, 'X', "XXX");

    // 선공이 이겼을 때, O가 X보다 하나 많아야 하고,
    if (successO == 1 && xCnt == oCnt) {
      return 0;
    }

    // 후공이 이겼을 때 O와 X의 개수가 같아야 함
    if (successX == 1 && xCnt != oCnt) {
      return 0;
    }

    // 완성된 O나 X가 1개씩 이상 있을 때 승부 불가능이므로 0을 반환
    if (successO >= 1 && successX >= 1) {
      return 0;
    }
    return answer;
  }

  // 가로 3줄, 세로 3줄, 대각선 2줄 총 8가지 검사 (3개의 같은 표시 'O' or 'X' 가 만들어 졌는지 확인)
  public int check(String[] board, Character ch, String str) {
    int result = 0;
    int cnt[] = new int[8];

    // 각 줄에 대한 특정 문자가 몇 번 나타나는지 셈
    for (int i = 0; i < 3; i++) {

      // 세로 3줄
      if (board[i].charAt(0) == ch) {
        cnt[0]++;
      }
      if (board[i].charAt(1) == ch) {
        cnt[1]++;
      }
      if (board[i].charAt(2) == ch) {
        cnt[2]++;
      }

      // 대각선 \
      if (board[i].charAt(i) == ch) {
        cnt[3]++;
      }
    }

    // 가로 3줄
    for (int i = 0; i < 3; i++) {
      if (board[i].equals(str)) {
        cnt[4 + i] += 3;
      }
    }

    // 대각선 /
    for (int i = 2; i >= 0; i--) {
      if (board[i].charAt(2 - i) == ch) {
        cnt[7]++;
      }
    }

    // 각 방향별로 3번 나타나면 승리 조건이므로 result 값 증가
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] == 3) {
        result++;
      }
    }
    return result;
  }

}
