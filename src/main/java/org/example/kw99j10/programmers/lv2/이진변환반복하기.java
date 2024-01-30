package org.example.kw99j10.programmers.lv2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int zero_erase = 0;

        while (!s.equals("1")) {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero_erase += 1;
                }
            }
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            count += 1;
        }
        answer[0] = count;
        answer[1] = zero_erase;
        return answer;
    }
}