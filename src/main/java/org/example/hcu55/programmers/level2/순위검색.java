package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 순위 검색, Programmers(Level 2)
public class 순위검색 {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] data = info[i].split(" ");
            makeSentence(data, "", 0);
        }

        for (String key : map.keySet())         // 코테 점수를 기준으로 오름차순
            Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");      // " and " 없애기
            String[] q = query[i].split(" ");                     // [javabackendjuniorpizza, 100] 이런식으로 만들어짐
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    // 이분 탐색
    private static int binarySearch(String key, int score) {
        ArrayList<Integer> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < score)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return list.size() - low;
    }

    // info가 포함될 수 있는 문장
    private static void makeSentence(String[] data, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(data[4]));
            return;
        }
        makeSentence(data, str + "-", cnt + 1);           // "-"를 포함한 조합
        makeSentence(data, str + data[cnt], cnt + 1);     // "-"를 제외한 조합
    }
}