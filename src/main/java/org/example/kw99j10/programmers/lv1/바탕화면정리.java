package org.example.kw99j10.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 바탕화면 정리, programmers:Level 1
 */
public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4]; //answer의 크기 : 시작 좌표, 종료 좌표

        String[][] computer = new String[wallpaper.length][wallpaper[0].length()];

        for (int i = 0; i < wallpaper.length; i++) {
            String k = wallpaper[i];
            for (int j = 0; j < k.length(); j++) {
                computer[i][j] = String.valueOf(k.charAt(j));
            }
        }
        var x=new ArrayList<Integer>(); //x 좌표를 담을 list
        var y=new ArrayList<Integer>(); //y 좌표를 담을 list
        for (int i=0;i<computer.length;i++){
            for (int j=0;j<computer[i].length;j++){
                if (computer[i][j].equals("#")){
                    x.add(j);
                    y.add(i);
                }
            }
        }

        //정렬 시 처음 x, y값이 시작점 S이고 마지막 x, y 값에 1을 더한 값이 종료점 E
        Collections.sort(x);
        Collections.sort(y);
        answer[0]=y.get(0);
        answer[1]=x.get(0);

        answer[2]=y.get(x.size()-1)+1;
        answer[3]=x.get(y.size()-1)+1;
        return answer;
    }
}
