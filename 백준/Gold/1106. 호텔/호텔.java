import java.io.*;
import java.util.*;

class Main {

    static int N, C;
    static int[][] dp;
    static int[] W, V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][100000 + 1];
        for (int i = 1; i < N + 1; i++) {
            int w = W[i - 1]; //비용
            int v = V[i - 1]; //고객수

            for (int j = 1; j <= 100000; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j - w >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + v);
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w] + v);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j <= 100000; j++) {
                if (dp[i][j] >= C)
                    ans = Math.min(j, ans);
            }
        }

        System.out.println(ans);
    }

}
