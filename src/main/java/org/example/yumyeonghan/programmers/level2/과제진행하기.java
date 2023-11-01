package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/176962
public class 과제진행하기 {

  public String[] solution(String[][] plans) {
    String[] answer = new String[plans.length];
    List<Work> works = new ArrayList<>();
    for (String[] plan : plans) {
      String name = plan[0];
      String[] time = plan[1].split(":");
      int start = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
      int playtime = Integer.valueOf(plan[2]);
      works.add(new Work(name, start, playtime));
    }
    works.sort(Comparator.comparingInt(work -> work.start)); // 시작 시간 순서로 정렬

    Deque<Work> workStack = new ArrayDeque<>(); // 진행 중인 작업 스택
    workStack.push(works.get(0)); // 스택에 첫 작업 푸쉬
    int currentTime = works.get(0).start; // 첫 작업 시간
    int answerIndex = 0;

    // 두번째 작업 부터 비교
    for (int i = 1; i < plans.length; i++) {
      int nextStartTime = works.get(i).start; // 다음 작업 시작 시간

      while (!workStack.isEmpty()) {
        Work work = workStack.pop(); // 진행 중인 작업 팝
        String name = work.name;
        int startTime = work.start;
        int playtime = work.playtime;

        // 새로운 작업에 대한 현재 시간 동기화
        if (currentTime < startTime) {
          currentTime = startTime;
        }

        // 다음 작업 시작 시간이 현재 작업의 끝나는 시간보다 빠르면 현재 작업 스택에 넣고 중단
        int endTime = currentTime + playtime;
        if (nextStartTime < endTime) {
          int remainTime = endTime - nextStartTime;
          workStack.push(new Work(name, startTime, remainTime));
          currentTime = nextStartTime;
          break;
        } else { // 그렇지 않으면, 작업 완료
          answer[answerIndex] = name;
          answerIndex += 1;
          currentTime += playtime;
        }
      }
      workStack.push(works.get(i));
    }

    // 남은 작업에 대해 최근 멈춘 작업에 대한 것부터 완료
    while (!workStack.isEmpty()) {
      answer[answerIndex] = workStack.pop().name;
      answerIndex += 1;
    }
    return answer;
  }

  static class Work {

    String name;
    int start;
    int playtime;

    Work(String name, int start, int playtime) {
      this.name = name;
      this.start = start;
      this.playtime = playtime;
    }

  }

}
