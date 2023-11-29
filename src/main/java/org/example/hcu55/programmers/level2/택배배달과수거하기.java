package org.example.hcu55.programmers.level2;

import java.util.Stack;

// 택배 배달과 수거하기, Programmers(Level 2)
public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> D = new Stack<>();
        Stack<Integer> P = new Stack<>();

        for (int i = 0; i < n; i++) {
            D.push(deliveries[i]);
            P.push(pickups[i]);
        }

        while (!D.isEmpty() || !P.isEmpty()) {

            while (!D.isEmpty() && D.peek() == 0) {     // 맨 끝이 0일 경우 계산할 필요 없으니 pop
                D.pop();
            }
            while (!P.isEmpty() && P.peek() == 0) {
                P.pop();
            }

            answer += 2L * Math.max(D.size(), P.size());

            int Dtarget = 0;
            while (!D.isEmpty()) {
                int Dcurrent = D.pop();

                if (Dtarget + Dcurrent <= cap) {     // 배달 가능
                    Dtarget += Dcurrent;
                } else {     // 배달 불가능
                    D.push(Dtarget + Dcurrent - cap);   // 남은 배달 양 스택에 넣어주기
                    break;
                }
            }

            int Ptarget = 0;
            while (!P.isEmpty()) {
                int Pcurrent = P.pop();

                if (Ptarget + Pcurrent <= cap) {
                    Ptarget += Pcurrent;
                } else {
                    P.push(Ptarget + Pcurrent - cap);
                    break;
                }
            }
        }
        return answer;
    }
}