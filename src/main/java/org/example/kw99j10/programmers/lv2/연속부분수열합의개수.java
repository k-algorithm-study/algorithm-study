package org.example.kw99j10.programmers.lv2;

import java.util.HashSet;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {

        var h = new HashSet<Integer>(); //부분 수열의 합을 담을 set

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += elements[k % elements.length];
                }
                h.add(sum);
            }
        }
        return h.size();
    }
}
