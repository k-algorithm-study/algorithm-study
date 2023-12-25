package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 할인 행사, programmers:Level 2
 */
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        var list = new ArrayList<String>();

        //리스트에 정현이가 원하는 제품을 원하는 개수만큼 저장
        for (int i=0;i<want.length;i++) {
            for (int j = 0; j < number[i]; j++) {
                list.add(want[i]);
            }
        }

        //10일 동안 회원 자격을 부여하여 할인 제품을 살 수 있음
        for (int i = 0; i <= discount.length - 10; i++) {

            //10일 단위의 비교 리스트 생성
            ArrayList<String> tmp = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(discount, i, i + 10)));

            for (String product : list) {
                tmp.remove(product);
            }

            if (tmp.size()==0) {
                answer += 1;
            }
        }
        return answer;
    }
}
