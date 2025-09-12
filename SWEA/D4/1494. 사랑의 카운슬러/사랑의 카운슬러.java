import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] W;
    static int x, y;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            W = new int[N][2];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                W[i] = new int[]{f, s};
            }

            ans = Long.MAX_VALUE;
            x = 0;
            y = 0;
            for (int i = 0; i < N; i++) {
                x += W[i][0];
                y += W[i][1];
            }
            comb(0, 0);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void comb(int depth, int start) {
        if (depth == N / 2) {
            ans = Math.min(ans, (long) x * x + (long) y * y);
            return;
        }

        for (int i = start; i < N; i++) {
            int dx = W[i][0] * 2;
            int dy = W[i][1] * 2;

            x -= dx;
            y -= dy;
            comb(depth + 1, i + 1);
            x += dx;
            y += dy;
        }
    }

}
