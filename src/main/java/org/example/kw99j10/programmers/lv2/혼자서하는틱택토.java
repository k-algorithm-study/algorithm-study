package org.example.kw99j10.programmers.lv2;

/**
 * 혼자서 하는 틱택토, programmers:Level 2
 * 경우의 수: 불가능한 경우의 수를 구함
 */
public class 혼자서하는틱택토 {
    public int solution(String[] board) {
        int answer = 1;

        char[][] tictacto = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                tictacto[i][j] = s.charAt(j);
            }
        }
        int first = 0; //선공
        int second = 0; //후공
        int first_person = 0; //선공의 틱택토 개수
        int second_person = 0; //후공의 틱택토 개수

        //선공의 개수와 후공의 개수를 count
        for (char[] chars : tictacto)
            for (char c : chars) {
                if (c == 'O') {
                    first += 1;
                }
                if (c == 'X') {
                    second += 1;
                }
            }

        for (int i = 0; i < board.length; i++) {

            //선공이 틱택토를 완성할 경우
            //가로
            if (board[i].charAt(0)=='O' && board[i].charAt(1)=='O' && board[i].charAt(2)=='O'){
                first_person += 1;
            }

            //대각선
            if (board[2].charAt(0)=='O' && board[1].charAt(1)=='O' && board[0].charAt(2)=='O'){
                first_person += 1;
            }
            if (board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O'){
                first_person += 1;
            }

            //세로
            if (board[0].charAt(i)=='O' && board[1].charAt(i)=='O' && board[2].charAt(i)=='O'){
                first_person += 1;
            }

            //후공이 틱택토를 완성할 경우
            //가로
            if (board[i].charAt(0)=='X' && board[i].charAt(1)=='X' && board[i].charAt(2)=='X'){
                second_person += 1;
            }

            //대각선
            if (board[2].charAt(0)=='X' && board[1].charAt(1)=='X' && board[0].charAt(2)=='X'){
                second_person += 1;
            }
            if (board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X'){
                second_person += 1;
            }

            //세로
            if (board[0].charAt(i)=='X' && board[1].charAt(i)=='X' && board[2].charAt(i)=='X'){
                second_person += 1;
            }
        }

        //틱택토 게임이 끝났을 때 나올 수 없는 상황 경우의 수

        //후공이 선공보다 많이 나왔을 경우
        if (second > first) {
            answer = 0;
        }

        //선공이 후공보다 2개 더 많을 경우
        if (first - second > 1) {
            answer = 0;
        }

        //선공, 후공의 틱택토가 모두 완성되었을 경우
        if (first_person > 0 && second_person > 0) {
            answer = 0;
        }

        //선공의 틱택토가 끝났을 때
        if (first_person > 0) {
            if (first == second) {
                answer = 0;
            }
        }

        //후공의 틱택토가 끝났을 때
        if (second_person > 0) {
            if (first - second == 1) {
                answer = 0;
            }
        }
        return answer;
    }
}
