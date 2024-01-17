package org.example.kw99j10.programmers.lv2;
/**
 * 2개 이하로 다른 비트, programmers:Level 2
 */
public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        //규칙 - 짝수: 다음 홀수와 비트 차이(1~2)
        //홀수: 0이 나오는 지점을 비교 -> 현재 수 + 2의 n승 - 2의 n-1승 만큼의 차이

        for (int i = 0; i < numbers.length; i++) {
            long tmp = numbers[i];

            if (tmp % 2 == 0) {
                answer[i] = tmp + 1;
            }
            else{
                String s = Long.toBinaryString(tmp);
                long place = 0; //0이 나오는 자리
                long p = 0;
                long t = 0;

                if (!s.contains("0")) {
                    s = "0" + s; //0이 없다면 맨 앞에 0을 추가
                }

                //ex ) 3(11) -> 3 + 4(2^2) - 2(2^1) = 5 (101)
                for (int j = s.length() - 1; j >= 0; j--) {
                    char c = s.charAt(j);
                    if (c == '0') {
                        p = place;
                        t = place - 1;
                        break;
                    }
                    place += 1;
                }
                answer[i] = tmp + (long) Math.pow(2, p) - (long) Math.pow(2, t);
            }
        }
        return answer;
    }
}
