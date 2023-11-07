package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
/**
 * 시소 짝궁, programmers:Level 2
 */
public class 시소짝궁 {
    public long solution(int[] weights) {

        long answer = 0; //시소 짝궁의 쌍을 리턴하는 변수

        var siso = new HashMap<Double, Integer>(); //시소 짝궁을 담을 set
        Arrays.sort(weights); //중복 방지를 위한 정렬

        //주어진 몸무게
        for (double tmp : weights) {
            if (siso.containsKey(tmp)) {
                answer += siso.get(tmp); //이미 포함된 경우의 수 라면 answer 증가
            }

            //나올 수 있는 시소 비율 경우의 수를 map에 저장
            siso.put(tmp, siso.getOrDefault(tmp, 0) + 1); //1:1
            siso.put(tmp * 3 / 2, siso.getOrDefault(tmp * 3 / 2, 0) + 1); //2:3
            siso.put(tmp * 2, siso.getOrDefault(tmp * 2, 0) + 1); //1:2
            siso.put(tmp * 4 / 3, siso.getOrDefault(tmp * 4 / 3, 0) + 1); //3:4
        }
        return answer;
    }
}
