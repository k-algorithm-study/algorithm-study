package org.example.hcu55.programmers.level2;

// 연속된 부분 수열의 합, Programmers(Level 2)
public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int[] answer = new int[2];
        left = 0;
        right = 0;
        int min_seqLen = 1000001;
        int sum = 0;

        while (true) {
            if (sum > k) {
                sum -= sequence[left++];
            } else if (right >= sequence.length) {
                break;
            } else {
                sum += sequence[right++];
            }

            if (sum == k) {
                if(right - left < min_seqLen) {
                    min_seqLen = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }


        return answer;
    }
}
