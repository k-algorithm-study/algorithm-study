package org.example.hcu55.swea.D2;

import java.io.*;

public class 패턴마디의길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String str = br.readLine();
            int len = 0;

            for (int i = 1; i < 10; i++) {
                String a = str.substring(0, i);          // 0 ~ i 까지
                String b = str.substring(i, i * 2);      // i 부터 i + i 까지

                if (a.equals(b)) {                       // 같으면 그때 길이 구하기
                    len = i;
                    break;
                }
            }
            System.out.println("#" + testCase + " " + len);
        }
    }
}
