import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] costs;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        costs = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        int ret = Integer.MAX_VALUE;

        dp = new int[N][3];
        // 첫번째 색을 빨강으로 칠하기
        dp[1][0] = Integer.MAX_VALUE;
        dp[1][1] = costs[0][0] + costs[1][1];
        dp[1][2] = costs[0][0] + costs[1][2];

        calcDP(N);
        ret = Math.min(ret, dp[N-1][1]);
        ret = Math.min(ret, dp[N-1][2]);

        // 초록
        dp[1][0] = costs[0][1] + costs[1][0];
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][2] = costs[0][1] + costs[1][2];

        calcDP(N);
        ret = Math.min(ret, dp[N-1][0]);
        ret = Math.min(ret, dp[N-1][2]);

        // 파랑
        dp[1][0] = costs[0][2] + costs[1][0];
        dp[1][1] = costs[0][2] + costs[1][1];
        dp[1][2] = Integer.MAX_VALUE;

        calcDP(N);
        ret = Math.min(ret, dp[N-1][0]);
        ret = Math.min(ret, dp[N-1][1]);

        System.out.println(ret);
    }

    private static void calcDP(int N) {
        for (int i = 2; i < N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
    }
}