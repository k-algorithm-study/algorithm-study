package org.example.hcu55.swea.D1;

import java.io.*;

public class 자릿수더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split("");

        int sum = 0;

        for (String s : num) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
