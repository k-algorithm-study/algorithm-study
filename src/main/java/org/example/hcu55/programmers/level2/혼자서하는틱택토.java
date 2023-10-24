package org.example.hcu55.programmers.level2;

// 혼자서 하는 틱택토, Programmers(Level 2)
public class 혼자서하는틱택토 {
    public int solution(String[] board) {
        int Ocount = 0;
        int Xcount = 0;
        char[][] map = new char[3][3];

        //O와 X의 개수 세기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O')
                    Ocount++;
                if (map[i][j] == 'X')
                    Xcount++;
            }
        }

        if (Xcount > Ocount) {          //X가 O보다 많으면 안됨
            return 0;
        }

        if (Ocount > Xcount + 1) {      //O이 X보다 2개이상 많으면 안됨
            return 0;
        }

        if (Win(board, 'O')) {      //O이 이겼을 시 X가 O의 개수와 같으면 규칙 위반
            if (Ocount == Xcount) {
                return 0;
            }
        }

        if (Win(board, 'X')) {      //X가 이겼을 시 O이 X보다 1개 많으면 규칙 위반
            if (Ocount == Xcount + 1) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean Win(String[] board, char ch) {
        for (int i = 0; i < 3; i++) {      //가로 검사
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {      //세로 검사
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }
        //대각선 검사
        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}
