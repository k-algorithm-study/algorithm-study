package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 주차 요금 계산, programmers:Level 2
 */
public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {

        var money = new HashMap<String, Integer>();//차량 번호, 주차 요금
        var time = new HashMap<String, String>();//차량 번호, 주차 시간

        for (String record : records) {
            String[] tmp = record.split(" ");
            money.put(tmp[1], 0); //차량에 대한 주차 요금 0 초기화
        }

        for (String record : records) {
            String[] tmp = record.split(" ");
            String hourMin = tmp[0]; //시각
            String carNumber = tmp[1]; //차량 번호
            String text = tmp[2]; //내역(in,out)

            //차가 없던 경우
            if (text.equals("IN")) {
                time.put(carNumber, hourMin);
            }
            //차가 있던 경우
            else if (text.equals("OUT")) {
                String[] in = time.remove(carNumber).split(":");
                String[] out = hourMin.split(":");

                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int min = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                int InOut = hour * 60 + min;
                money.put(carNumber, money.get(carNumber) + InOut); //출차 시 주차 요금을 갱신
                //cf)같은 차에 대한 출입은 제한이 없음
            }
        }

        //출차된 내역이 없다면 23:59에 출차시킴
        if (!time.isEmpty()) {
            for (String carNumber : time.keySet()) {

                String[] tmp = time.get(carNumber).split(":");

                int hour = 23 - Integer.parseInt(tmp[0]);
                int min = 59 - Integer.parseInt(tmp[1]);
                int Inout = hour * 60 + min;
                money.put(carNumber, money.get(carNumber) + Inout);
            }
        }

        var ans = new ArrayList<>(money.keySet()); //차량 정렬을 위한 리스트
        Collections.sort(ans); //차량 번호가 작은 자동차부터 청구

        int[] answer = new int[ans.size()];

        //fees 0:기본 시간, 1: 기본 요금, 2: 단위 시간, 3: 단위 요금
        for (int i = 0; i < answer.length; i++) {
            int total = money.get(ans.get(i));

            //기본 시간에 따라 요금 부과
            answer[i] = fees[0] >= total ? fees[1] : fees[1] + (int) Math.ceil((double) (total - fees[0]) / fees[2]) * fees[3];
        }
        return answer;
    }
}
