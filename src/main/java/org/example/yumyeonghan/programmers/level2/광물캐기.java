package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927
public class 광물캐기 {

  private int answer = (int) 1e9;

  public int solution(int[] picks, String[] minerals) {
    int diamond = picks[0];
    int iron = picks[1];
    int stone = picks[2];

    if (diamond > 0) {
      dfs(0, "diamond", 0, minerals, diamond - 1, iron, stone);
    }
    if (iron > 0) {
      dfs(0, "iron", 0, minerals, diamond, iron - 1, stone);
    }
    if (stone > 0) {
      dfs(0, "stone", 0, minerals, diamond, iron, stone - 1);
    }
    return answer;
  }

  private void dfs(
      int fatigue,
      String tool,
      int index,
      String[] minerals,
      int diamond,
      int iron,
      int stone
  ) {
    if (index >= minerals.length) {
      answer = Math.min(answer, fatigue);
      return;
    }

    if (minerals[index].equals("diamond")) {
      if ("diamond".equals(tool)) {
        fatigue += 1;
      } else if ("iron".equals(tool)) {
        fatigue += 5;
      } else {
        fatigue += 25;
      }
    } else if (minerals[index].equals("iron")) {
      if ("diamond".equals(tool)) {
        fatigue += 1;
      } else if ("iron".equals(tool)) {
        fatigue += 1;
      } else {
        fatigue += 5;
      }
    } else if (minerals[index].equals("stone")) {
      if ("diamond".equals(tool)) {
        fatigue += 1;
      } else if ("iron".equals(tool)) {
        fatigue += 1;
      } else {
        fatigue += 1;
      }
    }

    // index가 4가 되면, 해당 곡괭이가 5개의 광석을 모두 캤기 때문에 다음 곡괭이 선택
    if ((index + 1) % 5 == 0) {
      if ((diamond == 0 && iron == 0 && stone == 0)) {
        answer = Math.min(answer, fatigue);
        return;
      }

      if (diamond > 0) {
        dfs(fatigue, "diamond", index + 1, minerals, diamond - 1, iron, stone);
      }

      if (iron > 0) {
        dfs(fatigue, "iron", index + 1, minerals, diamond, iron - 1, stone);
      }

      if (stone > 0) {
        dfs(fatigue, "stone", index + 1, minerals, diamond, iron, stone - 1);
      }
    } else {
      dfs(fatigue, tool, index + 1, minerals, diamond, iron, stone);
    }

  }

}
