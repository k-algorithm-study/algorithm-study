package org.example.kw99j10.programmers.lv1;

import java.util.HashMap;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        //추억 점수: (사람, 점수)
        var score = new HashMap<String, Integer>();
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (score.containsKey(photo[i][j])) {
                    answer[i] += score.get(photo[i][j]);
                }
            }
        }
        return answer;
    }
}
