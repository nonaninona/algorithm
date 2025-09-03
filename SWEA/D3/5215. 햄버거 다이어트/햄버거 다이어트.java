import java.io.*;
import java.util.*;

public class Solution {

    static int TC, N, L;
    static int[] T, K;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TC = Integer.parseInt(br.readLine());

        for(int tc=1;tc<TC+1;tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            T = new int[N];
            K = new int[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N+1][L+1];
            for(int i=1;i<N+1;i++) {
                for(int j=0;j<=L;j++) {
                    if(j-K[i-1] < 0)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-K[i-1]] + T[i-1]);
                }
            }

            System.out.printf("#%d %d\n", tc, dp[N][L]);
        }

    }
}