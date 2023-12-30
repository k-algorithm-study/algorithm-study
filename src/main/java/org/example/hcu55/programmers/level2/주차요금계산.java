package org.example.hcu55.programmers.level2;

import java.util.*;

// 주차 요금 계산, Programmers(Level 2)
public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            costs.put(records[i].split(" ")[1], 0);
        }

        for(int i = 0; i < records.length; i++){
            String[] infos = records[i].split(" ");

            if(map.containsKey(infos[1])){
                String[] inTime = map.remove(infos[1]).split(":");
                String[] outTime = infos[0].split(":");

                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                costs.replace(infos[1], costs.get(infos[1]) + 60 * hour + minute);

            }else{
                map.put(infos[1], infos[0]); // 차 번호, 시간
            }
        }

        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);

            costs.replace(key, costs.get(key) + 60 * hour + minute);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(costs.entrySet());
        list.sort((o1, o2) -> {
            return (Integer.compare(Integer.parseInt(o1.getKey()), Integer.parseInt(o2.getKey())));
        });


        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        return answer;
    }
}