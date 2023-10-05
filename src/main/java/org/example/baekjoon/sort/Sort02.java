package org.example.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int []a=new int[n];

        for (int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);

        int minSum=0; //필요한 시간의 합의 최솟 값
        for (int i=0;i<a.length;i++){
            for (int j=0;j<=i;j++){
                minSum+=a[j];
            }
        }
        System.out.println(minSum);
    }
}
