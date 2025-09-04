import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[] B;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        B = new int[20];

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                B[i] = Integer.parseInt(st.nextToken());

            dp = new int[N][N];
            for(int i=0;i<N;i++)
                Arrays.fill(dp[i], -1);
            int ans = dfs(0, N-1);

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static int dfs(int s, int e) {
        if(s > e)
            return 0;
        if(dp[s][e] != -1)
            return dp[s][e];

        int ret = 0;
        for(int i=s;i<=e;i++) {
            int score = 0;
            if(s == 0 && e == N-1)
                score += B[i];
            else if(s == 0 && e != N-1)
                score += B[e+1];
            else if(s != 0 && e == N-1)
                score += B[s-1];
            else
                score += B[s-1] * B[e+1];
            ret = Math.max(ret, score + dfs(s, i - 1) + dfs(i + 1, e));
        }
        return dp[s][e] = ret;
    }
}