package org.example.yumyeonghan.programmers.kit.hash;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class 폰켓몬 {

    public static void main(String[] args) {
        System.out.println(new 폰켓몬().solution(new int[]{3, 1, 2, 3}));
    }

    public int solution(int[] nums) {
        int len = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() > len ? len : set.size();
    }

}
