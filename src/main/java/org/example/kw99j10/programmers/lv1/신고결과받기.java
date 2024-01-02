package org.example.kw99j10.programmers.lv1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 신고 결과 받기, programmers:Level 1
 */
public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        var count = new HashMap<String, Integer>(); //신고 처리 횟수
        var relation = new HashMap<String, HashSet<String>>(); //신고 관계

        //id 리스트 저장
        for (String id : id_list) {
            count.put(id, 0);
            relation.put(id, new HashSet<>());
        }

        //각 유저는 한 번에 한 명의 유저만 신고할 수 있음
        for (String s : report) {
            String[] tmp = s.split(" ");

            String userId = tmp[0];
            String reportId = tmp[1];

            relation.get(reportId).add(userId); //(피신고자, 신고자)
        }

        for (String s : relation.keySet()) {
            HashSet<String> set = relation.get(s); //신고 대상

            //신고 대상이 k번 이상 신고 당하면 이용 정지 & 처리 결과 메일 +1
            if (set.size() >= k) {
                for (String list : set) {
                    count.put(list, count.get(list) + 1);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count.get(id_list[i]);
        }
        return answer;
    }
}
