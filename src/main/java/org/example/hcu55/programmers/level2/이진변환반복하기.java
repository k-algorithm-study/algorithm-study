package org.example.hcu55.programmers.level2;

// 이진 변환 반복하기, Programmers(Level 2)
public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;        // 0의 개수
        int oneLen;             // 0 제거 후 1의 길이
        int count = 0;          // 총 반복 횟수

        while (!s.equals("1")) {
            count++;
            oneLen = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                } else {
                    oneLen++;
                }
            }

            s = Integer.toBinaryString(oneLen);
        }

        answer[0] = count;
        answer[1] = zeroCnt;

        return answer;
    }
}
