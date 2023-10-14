package org.example.yumyeonghan.programmers.kit.dfs_bfs;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class 타겟넘버 {

    int answer = 0;

    public static void main(String[] args) {
        System.out.println(new 타겟넘버().solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
        } else {
            dfs(numbers, target, sum + numbers[depth], depth + 1);
            dfs(numbers, target, sum - numbers[depth], depth + 1);
        }
    }

}
