package org.example.hcu55.programmers.level1;

// 옹알이 (2), Programmers(Level 1)
public class 옹알이2 {
    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("aya")
                    || babbling[i].contains("ye")
                    || babbling[i].contains("woo")
                    || babbling[i].contains("ma")) {
                babbling[i] = babbling[i].replace("ayaaya", "1");   // 연속되는 문자들은 숫자로 치환
                babbling[i] = babbling[i].replace("yeye", "2");
                babbling[i] = babbling[i].replace("woowoo", "3");
                babbling[i] = babbling[i].replace("mama", "4");

                babbling[i] = babbling[i].replace("aya", " ");      // 말할 수 있는 단어들은 공백으로 치환
                babbling[i] = babbling[i].replace("ye", " ");
                babbling[i] = babbling[i].replace("woo", " ");
                babbling[i] = babbling[i].replace("ma", " ");

                babbling[i] = babbling[i].replace(" ", "");     // 남은 공백들도 다 길이를 없애줌
            }
            if (babbling[i].length() == 0) {    // 다 치환되어 길이가 0이면 머쓱이가 할 수 있는 말이다.
                answer++;
            }
        }
        return answer;
    }
}
