package org.example.kw99j10.programmers.lv2;

import java.util.PriorityQueue;

/**
 * 이모티콘 할인행사, programmers:Level 2
 */
public class 이모티콘할인행사 {
    static int[] sales = {10, 20, 30, 40}; //할인율
    static int[] count; //사용자별 할인율을 계산한 판매액을 저장할 배열
    static PriorityQueue<int[]> queue; //회원 수와 매출액을 담을 큐
    public int[] solution(int[][] users, int[] emoticons) {

        //서비스 가입자가 많은 순 -> 같다면 판매액이 큰 순 정렬
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        count = new int[emoticons.length];

        //할인율을 적용하여 나올 수 있는 전체 판매액의 경우의 수에 대하여 dfs 수행
        dfs(0, users, emoticons);

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
        return queue.peek(); //조건에 따른 최댓값 출력(가입자 수, 판매액)
    }
    private void dfs(int t, int[][] users, int[] emoticons) {

        if (t == count.length) {
            int join = 0; //서비스에 가입한 회원 수
            int sum = 0; //이모티콘 매출액

            for (int[] user : users) {

                //할인율 이상의 이모티콘만 구매 & 그 구매 비용이 total을 넘기면 서비스 가입
                int discount_percent = user[0]; //구매할 이모티콘의 할인율 마지노선
                int max_money = user[1]; //이모티콘 구매 비용 마지노선

                int total = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    if (count[j] >= discount_percent) {
                        total += emoticons[j] * (100 - count[j]) / 100;
                    }
                }
                if (total >= max_money) {
                    join += 1; //구매 비용 마지노선을 넘어가면 서비스에 가입
                }
                else {
                    sum += total; //판매액 누적
                }
            }
            queue.offer(new int[]{join, sum});
            return;
        }
        for (int sale : sales) {
            count[t] = sale; //할인율 대입
            dfs(t + 1, users, emoticons);
        }
    }
}
