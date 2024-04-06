package org.example.kw99j10.baekjoon.search.dfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 *  DSLR - Gold IV
 */
public class DfsBfs16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayDeque<String[]> queue = new ArrayDeque<>();
            boolean[] visit = new boolean[10001];
            queue.add(new String[]{String.valueOf(a), ""});
            while (!queue.isEmpty()) {
                String[] order = queue.poll();

                int current = Integer.parseInt(order[0]);
                String ord = order[1];

                if (current == b) {
                    sb.append(ord).append("\n");
                    break;
                }

                int d = (current * 2) % 10000;
                if (!visit[d]) {
                    visit[d] = true;
                    queue.add(new String[]{String.valueOf(d), ord + "D"});
                }

                int s = current == 0 ? 9999 : current - 1;
                if (!visit[s]) {
                    visit[s] = true;
                    queue.add(new String[]{String.valueOf(s), ord + "S"});
                }

                int l = (current % 1000) * 10 + (current / 1000);
                if (!visit[l]) {
                    visit[l] = true;
                    queue.add(new String[]{String.valueOf(l), ord + "L"});
                }

                int r = (current % 10) * 1000 + (current / 10);
                if (!visit[r]) {
                    visit[r] = true;
                    queue.add(new String[]{String.valueOf(r), ord + "R"});
                }
            }
        }
        System.out.print(sb);
    }
}
