package org.example.yumyeonghan.programmers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class 신고결과받기 {

  public int[] solution(String[] id_list, String[] report, int k) {
    // init map
    int[] answer = new int[id_list.length];
    Map<String, Integer> userIndexInfo = new HashMap<>(); // 정답 출력에 사용
    Map<String, HashSet<String>> userReportedInfo = new HashMap<>(); // 신고당한 사용자 : 신고한 사용자
    for (int i = 0; i < id_list.length; i++) {
      String user = id_list[i];
      userIndexInfo.put(user, i);
      userReportedInfo.put(user, new HashSet<>());
    }

    for (String reportInfo : report) {
      String[] split = reportInfo.split(" ");
      String reportingUser = split[0];
      String reportedUser = split[1];
      userReportedInfo.get(reportedUser).add(reportingUser);
    }

    // check answer
    for (int i = 0; i < id_list.length; i++) {
      HashSet<String> reportingUsers = userReportedInfo.get(id_list[i]);
      if (reportingUsers.size() >= k) {
        for (String reportingUser : reportingUsers) {
          int userIndex = userIndexInfo.get(reportingUser);
          answer[userIndex]++;
        }
      }
    }
    return answer;
  }

}
