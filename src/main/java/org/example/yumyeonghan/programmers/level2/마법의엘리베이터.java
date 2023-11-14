package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class 마법의엘리베이터 {

  public int solution(int storey) {
    int stone = 0;
    while (storey > 0) {
      // 10씩 지우면서 진행
      int num = storey % 10;
      storey /= 10;

      // U or D
      if (num == 5) {
        // U
        if (storey % 10 >= 5) {
          stone = stone + (10 - num);
          storey++;
        } else { // D
          stone += num;
        }
        // U
      } else if (num > 5) {
        stone = stone + (10 - num);
        storey++;
      } else { //D
        stone += num;
      }
    }
    return stone;
  }

}
