package org.example.kw99j10.programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 공원 산책, programmers:Level 1
 */
public class 공원산책 {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        String[][] map = new String[park.length][park[0].length()];

        int w = 0; //공원의 가로
        int h = 0; //공원의 세로

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);
                if (c == 'S') {
                    w = j;
                    h = i; //시작점을 저장
                }
                map[i][j] = String.valueOf(c);
            }
        }

        for (String route : routes) {
            String[] tmp = route.split("");
            String op = tmp[0]; //이동할 방향
            int n = Integer.parseInt(tmp[1]); //이동할 범위

            int y_distance = h; //위, 아래 이동 거리
            int x_distance = w; //좌, 우 이동 거리

            //주어진 거리까지 반복문 실행
            for (int j = 1; j <= n; j++) {
                if (op.equals("N")) {
                    y_distance -= 1;
                }
                if (op.equals("S")) {
                    y_distance += 1;
                }
                if (op.equals("W")) {
                    x_distance -= 1;
                }
                if (op.equals("E")) {
                    x_distance += 1;
                }
                //공원을 벗어나는지 && 장애물을 만나는지 확인 -> 해당하면 무시
                if (x_distance < 0 || x_distance >= map[0].length ||
                        y_distance < 0 || y_distance >= map.length) {
                    continue;
                }
                else {
                    if (map[y_distance][x_distance].equals("X")) {
                        break;
                    }
                    //끝까지 실행했을 때 멈추지 않으면 높이와 넓이를 갱신
                    if (j == n){
                        h = y_distance;
                        w = x_distance;
                    }
                }
            }
            System.out.println(h+" "+w);
        }

        answer[0] = h;
        answer[1] = w;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] park = new String[4];
        String[] routes = new String[3];

        for (int i = 0; i < park.length; i++) {
            park[i] = sc.next();
        }
        for (int i = 0; i < routes.length; i++) {
            routes[i] = sc.next();
        }
        System.out.println(Arrays.toString(solution(park, routes)));
    }
}
