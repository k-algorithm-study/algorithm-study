package org.example.kw99j10.programmers.lv2;

/**
 * 점 찍기, programmers:Level 2
 */
public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        long cut = (long) Math.pow(d, 2); //기준점 d

        //k의 배수 만큼 떨어진 위치에 점을 찍으므로 k씩 증가
        for (int i = 0; i <= d; i += k) {

            //k만큼 떨어진 위치
            double distance = Math.pow(i, 2);

            //점의 개수
            long count = (long) Math.sqrt(cut - distance) / k + 1;
            answer += count;
        }
        return answer;
    }
}
