package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 공원 산책, Programmers(Level 1)
public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {

        // 로봇의 시작 위치
        int startH = 0;
        int startW = 0;

        int h = park.length;
        int w = park[0].length();

        char [][] parkArray = new char[h][w];

        for (int i = 0; i< h; i++) {
            String rowData = park[i];
            for (int j = 0; j< w; j++) {
                char locationData = rowData.charAt(j);
                parkArray[i][j] = locationData;
                if (locationData == 'S') {
                    startH = i;
                    startW = j;
                }
            }
        }
        // 좌표 값 저장
        Map<Character, List<Integer>> dirMove = new HashMap<Character, List<Integer>>();
        dirMove.put('E', List.of(0,1));
        dirMove.put('W', List.of(0,-1));
        dirMove.put('N', List.of(-1,0));
        dirMove.put('S', List.of(1,0));

        // routes 만큼 반복한다.
        for (String route : routes) {

            char direction = route.charAt(0);
            int move = route.charAt(2) - '0';
            // 이동할 위치 계산
            // 롤백을 위한 위치 저장
            int tmpH = startH;
            int tmpW = startW;

            boolean possible = true;

            // 해당 방향으로 몇칸을 이동해야해서, 한칸씩 이동하며 가능성을 확인한다.
            for (int i=0; i<move; i++) {
                int moveRow = startH + dirMove.get(direction).get(0);
                int moveColumn = startW + dirMove.get(direction).get(1);
                // 공원 바깥이면 실패
                if ( 0 > moveRow || moveRow >= h || 0 > moveColumn || moveColumn >= w) {
                    possible = false;
                    break;
                }
                // 장애물을 만나면 실패
                if (parkArray[moveRow][moveColumn] == 'X') {
                    possible = false;
                    break;
                }
                //실제 이동
                parkArray[moveRow][moveColumn] = 'S';
                parkArray[startH][startW] = 'O';

                startH = moveRow;
                startW = moveColumn;
            }
            //불가능한 경우가 존재하면 롤백
            if (possible == false) {
                startH = tmpH ;
                startW = tmpW;
            }
        }
        // 마지막에 로봇의 위치 출력
        int[] answer = new int[2];
        answer[0] = startH;
        answer[1] = startW;
        return answer;
    }
}
