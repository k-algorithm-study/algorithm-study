package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/161989
public class 덧칠하기 {

  public int solution(int n, int m, int[] section) {
    //한번의 페인트칠에 칠할수 있는 롤로의 길이 m, 전체길이 n
    //페인트를 다시 칠 할 영역 section
    //section이 2,3,6 이라면 2345, 3456 이런식으로 최소 두번(답)을 해야 됨
    //규칙 롤러가 벽에서 벗어나면 아됨, 구역의 일부분만 포함되도록 칠하면 안됨
    //1. 반복문으로, section에 있는 번호 확인
    int index = 0;
    int count = 0;
    for (int i = 0; i < section.length; i++) {
      if (section[i] < index) {
        continue;
      }
      index = section[i] + m;
      count += 1;
    }
    //2. 첫 번호를 시작으로 +m 후 다시 1번, 이때 첫 번호 + m이 구역을 벗어난다면 break,후 정답에 + 1한것이 답
    return count;
  }

}
