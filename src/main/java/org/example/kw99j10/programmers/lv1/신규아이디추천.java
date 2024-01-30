package org.example.kw99j10.programmers.lv1;

public class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase(); //1단계
        answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2단계
        answer = answer.replaceAll("[.]{2,}", "."); //3단계
        answer = answer.replaceAll("^[.]|[.]$", ""); //4단계

        if (answer.isEmpty()) {
            answer += "a"; //5단계
        }

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", ""); //6단계
        }

        if (answer.length() < 3) {
            while (answer.length() != 3) {
                answer += answer.charAt(answer.length() - 1); //7단계
            }
        }
        return answer;
    }
}
