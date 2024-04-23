package org.example.hcu55.swea.D1;

import java.io.*;
import java.util.*;

public class 큰놈작은놈같은놈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());        // 첫번째 수
            int num2 = Integer.parseInt(st.nextToken());        // 두번째 수

            String sign = "";
            if (num1 < num2) {
                sign += "<";
            } else if (num1 == num2) {
                sign += "=";
            } else {
                sign += ">";
            }

            System.out.println("#" + testCase + " " + sign);
        }
    }
}
