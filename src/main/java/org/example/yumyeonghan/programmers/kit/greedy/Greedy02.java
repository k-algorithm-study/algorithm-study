package org.example.yumyeonghan.programmers.kit.greedy;

//조이스틱, 레벨2
public class Greedy02 {

    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move= len - 1;

        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int aIndex = i + 1;
            while(aIndex < len && name.charAt(aIndex) == 'A') {
                aIndex += 1;
            }
            move = Math.min(move, i * 2 + (len - aIndex)); // 앞으로 갔다가 뒤로
            move = Math.min(move, (len - aIndex) * 2 + i); // 처음부터 뒤로 갔다가 앞으로
        }
        answer += move;
        return answer;
    }

}
