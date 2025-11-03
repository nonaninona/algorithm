import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][][] dp;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][10][(1<<10)];

        for(int i=1;i<10;i++) {
            dp[0][i][1<<i] = 1;
        }

        for(int i=1;i<N;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<(1<<10);k++) {
                    if(j-1 >= 0)
                        dp[i][j][k | (1 << j)] += dp[i-1][j-1][k];
                    if(j+1 <= 9)
                        dp[i][j][k | (1 << j)] += dp[i-1][j+1][k];
                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }

        long ans = 0;
        for(int i=0;i<10;i++) {
            ans += dp[N - 1][i][(1 << 10) - 1];
            ans %= MOD;
        }
        System.out.println(ans);
    }
}