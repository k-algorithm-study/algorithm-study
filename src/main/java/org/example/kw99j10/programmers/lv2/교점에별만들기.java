package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 교점에 별 만들기, programmers:Level 2
 */
public class 교점에별만들기 {
    public String[] solution(int[][] line) {

        var intersection = new HashSet<long[]>();

        //최소, 최대 좌표를 저장 -> 격자판의 너비와 높이를 구함
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {

            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                if (a * d - b * c == 0) {
                    continue; //두 직선은 평행 또는 일치함
                }

                if ((b * f - e * d) % (a * d - b * c) != 0 ||
                        (e * c - a * f) % (a * d - b * c) != 0) {
                    continue; //x좌표 or y 좌표가 정수가 아님
                }
                //교점의 x좌표, y좌표
                long x = (b * f - e * d) / (a * d - b * c);
                long y = (e * c - a * f) / (a * d - b * c);
                intersection.add(new long[]{x, y});
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        long width = maxX - minX + 1;
        long height = maxY - minY + 1;

        String[] answer = new String[(int) height];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }
        Arrays.fill(answer, sb.toString()); //width x height 만큼 "."을 채움

        long nx, ny; //교점의 (정수형)좌표를 가져옴
        for (long[] xy : intersection) {
            ny = maxY - xy[1];
            nx = xy[0] - minX; //교점의 좌표에 '*' 표시
            answer[(int)ny]= answer[(int)ny].substring(0, (int)nx)+"*"
                    +answer[(int)ny].substring((int)nx+1);
        }
        return answer;
    }
}
