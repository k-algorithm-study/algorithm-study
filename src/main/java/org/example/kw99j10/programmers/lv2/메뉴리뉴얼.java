package org.example.kw99j10.programmers.lv2;

import java.util.*;

/**
 * 메뉴 리뉴얼, programmers:Level 2
 */
public class 메뉴리뉴얼 {
    HashMap<String, Integer> menu; //메뉴 조합, 나온 횟수

    public String[] solution(String[] orders, int[] course) {

        menu = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        //order 정렬 -> 메뉴 중복 방지(ABC = CBA)
        for (int i = 0; i < orders.length; i++) {
            char[] array = orders[i].toCharArray();
            Arrays.sort(array);
            orders[i] = String.valueOf(array);
        }

        //길이와 일치하는 문자열 조합 리턴
        for (int length : course) {
            for (String menuList : orders) {
                comb("", menuList, length);
            }
            if (!menu.isEmpty()) {
                ArrayList<Integer> lists = new ArrayList<>(menu.values());
                lists.sort(((o1, o2) -> o2 - o1)); //
                int max = lists.get(0);

                if (max > 1) {
                    for (String key : menu.keySet()) {
                        if (menu.get(key).equals(max)) {
                            result.add(key);
                        }
                    }
                }
                menu.clear();
            }
        }

        Collections.sort(result); //사전 순으로 저장
        return result.toArray(new String[0]);
    }

    private void comb(String tmp, String menuList, int length) {
        if (length == 0) {
            menu.put(tmp, menu.getOrDefault(tmp, 0) + 1);
            return;
        }
        //부분 문자열 조합 저장
        for (int i = 0; i < menuList.length(); i++) {
            comb(tmp + menuList.charAt(i), menuList.substring(i + 1), length - 1);
        }
    }
}