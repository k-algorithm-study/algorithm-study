package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 신고 결과 받기, Programmers(Level 1)
public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();     // 신고자 중복은 안되서 set 사용
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {      // id_list의 이름을 name 변수에 저장하여 map과 idxMap에 저장
            String name = id_list[i];
            map.put(name, new HashSet<>());      // 이름, HashSet
            idxMap.put(name, i);                 // 이름, 인덱스 번호 맵
        }

        for (String s : report) {
            String[] str = s.split(" ");   // "muzi frodo"
            String from = str[0];                // str[0] = "muzi"
            String to = str[1];                  // str[1] = "frodo"
            map.get(to).add(from);               // Set에 신고한 유저 추가
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);  // map에서 신고 당한 사람 이름을 key로 신고한 사람의 set을 가져옴
            if (send.size() >= k) {                      // 신고한 사람의 수가 k 이상이면
                for (String name : send) {
                    answer[idxMap.get(name)]++;          // answer의 사람 인덱스에 맞춰 처리 결과 메일 수 개수 증가
                }
            }
        }
        return answer;
    }
}
