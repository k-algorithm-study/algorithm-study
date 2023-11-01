package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
public class 공원산책 {

  public int[] solution(String[] park, String[] routes) {
    int startX = 0;
    int startY = 0;
    char[][] graph = new char[park.length][park[0].length()];

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        graph[i][j] = park[i].charAt(j);
        if (graph[i][j] == 'S') {
          startX = j;
          startY = i;
        }
      }
    }

    for (String st : routes) {
      String way = st.split(" ")[0];
      int len = Integer.parseInt(st.split(" ")[1]);

      int nx = startX;
      int ny = startY;

      for (int i = 0; i < len; i++) {
        if (way.equals("E")) {
          nx++;
        }
        if (way.equals("W")) {
          nx--;
        }
        if (way.equals("S")) {
          ny++;
        }
        if (way.equals("N")) {
          ny--;
        }
        if (nx >= 0 && ny >= 0 && ny < graph.length && nx < graph[0].length) {
          if (graph[ny][nx] == 'X') {
            break;
          }
          if (i == len - 1) {
            startX = nx;
            startY = ny;
          }
        }
      }
    }
    return new int[]{startY, startX};
  }

}
