package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.Scanner;

/**
 *  과제 진행하기, programmers:Level 2
 */
public class 과제진행하기 {
    static String[] solution(String[][] plans) {

        //과제 진행 순서: 새로운 과제 > 진행 중인 과제(최근 > 이전)
        String[] answer = new String[plans.length];

        Arrays.sort(plans,Comparator.comparing((String []o)->o[1])); //배열 시간 순 정렬

        var s=new Stack<String []>(); //멈춘 과제를 담을 stack

        int ans_index=0; //완료한 과제를 담을 인덱스
        int index=0; //현재 인덱스
        int current; //현재 인덱스의 진행시간
        int next=0; //다음 인덱스의 진행시간

        while (plans.length != index) {

            //과제 이름, 과제 시각, 걸리는 시간
            String subject = plans[index][0];

            String[] tmp = plans[index][1].split(":");
            int start_time = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            int play_time = Integer.parseInt(plans[index][2]);
            current = start_time + play_time;

            //다음 과제와 진행 시간이 겹치는 지 여부를 검사
            if (plans.length - 1 != index) {
                String[] t = plans[index + 1][1].split(":");
                int h = Integer.parseInt(t[0]) * 60;
                int m = Integer.parseInt(t[1]);
                next = h + m;

                //현재 과제가 끝나지 않았으면 stack에 저장 후 다음 과제로
                if (current > next) {
                    s.push(new String[]{subject, String.valueOf(current - next)});
                    index += 1;
                    continue;
                }
            }

            //겹치지 않고 진행할 수 있으면 answer 배열에 과제를 저장
            answer[ans_index] = subject;
            ans_index += 1;

            //멈춘 과제 실행(최근 멈춘 순서 대로)
            while (!s.isEmpty()) {

                int remain = next - current;

                String[] remain_subject = s.pop();
                int remain_time = Integer.parseInt(remain_subject[1]);
                if (remain >= remain_time) {
                    answer[ans_index] = remain_subject[0];
                    current += remain_time;
                    ans_index += 1;
                }
                else {
                    s.push(new String[]{remain_subject[0], String.valueOf(remain_time - remain)});
                    break;
                }
            }
            index += 1;
        }
        while (!s.isEmpty()){
            answer[ans_index]=s.pop()[0];
            ans_index+=1;
        }
        return answer;
    }

    //test를 위한 psvm문
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] plans = new String[3][3];
        for (int i = 0; i < plans.length; i++) {
            plans[i][0] = sc.next();
            plans[i][1] = sc.next();
            plans[i][2] = sc.next();
        }
        System.out.println(Arrays.toString(solution(plans)));
    }
}
