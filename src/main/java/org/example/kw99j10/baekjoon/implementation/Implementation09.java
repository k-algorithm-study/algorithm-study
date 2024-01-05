package org.example.kw99j10.baekjoon.implementation;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 요세푸스 문제 - Silver IV
 */
public class Implementation09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        var list = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 1;

        while (true) {
            if (list.size() == 1) {
                sb.append(list.poll()).append(">"); //마지막 수는 "," X
                break;
            }

            if (count == k) {
                sb.append(list.removeFirst()).append(", ");
                count = 0; //count 초기화
            }
            else{
                list.addLast(list.removeFirst());
            }
            count += 1;
        }
        System.out.print(sb);
    }
}
