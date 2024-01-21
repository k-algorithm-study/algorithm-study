package org.example.hcu55.programmers.level2;

// 2개 이하로 다른 비트, Programmers(Level 2)
public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {            // 짝수라면
                answer[i] = numbers[i] + 1;
                continue;
            }

            String n = Long.toString(numbers[i], 2);

            if (!n.contains("0")) {         // 홀수이면서 1로만 이루어져 있다면
                String temp = n.substring(0, 1) + "0" + n.substring(1);     // String 2번째 자리에 0 삽입
                answer[i] = Long.parseLong(temp, 2);        // 10진수로 변환 후 answer 배열에 삽입
            } else {        // 홀수이면서 1과 0이 포함되어 있다면
                int idx = n.lastIndexOf("0");           // 마지막으로 0이 나오는 인덱스 찾기
                n = n.substring(0, idx) + "10" + n.substring(idx + 2);      // 문자열 다시 만들기
                answer[i] = Long.parseLong(n, 2);
            }
        }
        return answer;
    }
}
