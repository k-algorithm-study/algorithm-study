package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 순위 검색, programmers:Level 2
 */
public class 순위검색 {
    static HashMap<String, ArrayList<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String s : info) {
            String[] tmp = s.split(" ");
            dfs(tmp, "", 0); //모든 경우의 수 탐색
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] stance = query[i].split(" ");
            answer[i] = map.containsKey(stance[0]) ? binarySearch(stance[0], Integer.parseInt(stance[1])) : 0;
        }
        return answer;
    }

    static int binarySearch(String key, int score) {
        ArrayList<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (score > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }

    static void dfs(String[] s, String tmp, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(tmp)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(tmp, list);
            }
            map.get(tmp).add(Integer.parseInt(s[4]));
            return;
        }
        dfs(s, tmp + "-", cnt + 1); //"-"를 포함한 모든 경우의 수 고려
        dfs(s, tmp + s[cnt], cnt + 1);
    }
}
