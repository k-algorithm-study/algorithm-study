package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.Scanner;
/**
 *  연속된 부분 수열의 합, programmers:Level 2
 */
public class 연속된부분수열의합 {

    static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0; //부분 수열의 시작 인덱스
        int right = 0; //부분 수열의 종료 인덱스

        int sum = 0; //부분 수열 구간의 합
        int min = 1000000001; //나올 수 있는 구간 범위의 최대 값

        while (true) {

            //부분 수열의 구간 합이 k와 같은 경우 구간 길이 비교
            if (sum == k) {
                if (min > right - left) {
                    min = right - left; //부분 수열은 길이가 가장 짧고 앞쪽이어야 함
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left];
                left += 1;
            }

            //부분 수열의 구간 합이 k보다 크다면 구간의 길이를 줄임
            else if (sum > k) {
                sum -= sequence[left];
                left += 1;
            }

            //종료 인덱스가 수열의 길이와 같으면 반복문을 종료
            else if (right == sequence.length) {
                break;
            }

            //부분 수열의 구간 합이 k보다 작다면 구간의 길이를 늘림
            else {
                sum += sequence[right];
                right += 1;
            }
        }
        return answer;
    }

    //test를 위한 psvm문
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequence = new int[5];

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(solution(sequence, k)));
    }
}
