package org.example.yumyeonghan.baekjoon.impl;

import java.util.*;

//셀프 넘버, 실버5
public class Impl02 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            int nonSelfNum = 0;

            if (i < 10) {
                nonSelfNum = i
                        + String.valueOf(i).charAt(0) - '0';
            }
            if (i >= 10 && i < 100) {
                nonSelfNum = i
                        + String.valueOf(i).charAt(0) - '0'
                        + String.valueOf(i).charAt(1) - '0';
            }

            if (i >= 100 && i < 1000) {
                nonSelfNum = i
                        + String.valueOf(i).charAt(0) - '0'
                        + String.valueOf(i).charAt(1) - '0'
                        + String.valueOf(i).charAt(2) - '0';
            }

            if (i >= 1000 && i < 10000) {
                nonSelfNum = i
                        + String.valueOf(i).charAt(0) - '0'
                        + String.valueOf(i).charAt(1) - '0'
                        + String.valueOf(i).charAt(2) - '0'
                        + String.valueOf(i).charAt(3) - '0';
            }
            list.add(nonSelfNum);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!list.contains(Integer.valueOf(i))) {
                System.out.println(i);
            }
        }
    }

}
