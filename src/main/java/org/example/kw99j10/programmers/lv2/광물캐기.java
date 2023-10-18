package org.example.kw99j10.programmers.lv2;

import java.util.*;
/**
 * 광물 캐기, programmers:Level 2
 */
public class 광물캐기 {

    static class Mine{
        int dia;
        int iron;
        int stone;

        public Mine(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    static int[][] piro; //광물별 피로도
    static ArrayList<Mine> mines; //구간 별 광물의 피로도

    public static int solution(int[] picks, String[] minerals) {

        int answer = 0; //필요한 최소한의 피로도

        piro = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int sum = 0; //곡괭이의 수
        for (int pick : picks) {
            sum += pick;
        }
        mines = new ArrayList<>();

        for (int i = 0; i < minerals.length; i += 5) {
            if (sum == 0) {
                break;
            }
            int dia = 0, iron = 0, stone = 0;

            //다섯개씩 끊어서 계산
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) {
                    break;
                }
                String mineral = minerals[j];
                int cost = mineral.equals("iron")
                        ? 1 : mineral.equals("stone")
                        ? 2 : 0;

                dia += piro[0][cost];
                iron += piro[1][cost];
                stone += piro[2][cost];
            }
            mines.add(new Mine(dia, iron, stone));
            sum -= 1;
        }

        //내림차순 정렬
        Collections.sort(mines, (o1, o2) -> o2.stone - o1.stone);

        for (Mine mine : mines) {
            int dia = mine.dia;
            int iron = mine.iron;
            int stone = mine.stone;

            if (picks[0] > 0) {
                answer += dia;
                picks[0] -= 1;
                continue;
            }
            if (picks[1] > 0) {
                answer += iron;
                picks[1] -= 1;
                continue;
            }
            if (picks[2] > 0) {
                answer += stone;
                picks[2] -= 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] picks = new int[3];
        String[] minerals = new String[8];

        for (int i = 0; i < picks.length; i++){
            picks[i] = sc.nextInt();
        }
        for (int i = 0; i < minerals.length; i++) {
            minerals[i] = sc.next();
        }
        System.out.println(solution(picks, minerals));
    }
}
