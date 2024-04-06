package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  소수의 연속합 - Gold III
 */
public class Binary16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }
        prime.add(0);

        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (start <= end && end < prime.size()) {
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= prime.get(start++);
            } else {
                sum += prime.get(end++);
            }
        }
        System.out.println(count);
    }
}
