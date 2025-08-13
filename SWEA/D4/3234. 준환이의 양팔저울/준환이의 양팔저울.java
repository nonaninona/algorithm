import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        int T, N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            int[] W;
            W = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                W[i] = Integer.parseInt(st.nextToken());
            
            int totalW = 0;
            for (int i = 0; i < N; i++)
                totalW += W[i];

            int[][] dp;
            dp = new int[1 << N][totalW + 1];

            for (int i = 0; i < (1 << N); i++)
                Arrays.fill(dp[i], -1);

            builder.append("#").append(tc).append(" ").append(dfs(0,0, N, dp, W)).append("\n");
        }
        System.out.print(builder);
    }

    private static int dfs(int mask, int leftSum, int N, int[][] dp, int[] W) {
        if (mask == (1 << N) - 1) {
            return 1;
        }

        if (dp[mask][leftSum] != -1)
            return dp[mask][leftSum];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                sum += W[i];
            }
        }
        int rightSum = sum - leftSum;

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                cnt += dfs(mask | (1 << i), leftSum + W[i], N, dp, W);

                if (leftSum >= rightSum + W[i]) {
                    cnt += dfs(mask | (1 << i), leftSum, N, dp, W);
                }
            }
        }

        return dp[mask][leftSum] = cnt;
    }
}
