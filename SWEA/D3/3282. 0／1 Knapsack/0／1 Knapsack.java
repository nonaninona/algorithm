import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, K;
    static int[] V, C;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        V = new int[100];
        C = new int[100];
        dp = new int[1001];
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }


            Arrays.fill(dp, 0);
            for (int i = 0; i < N; i++) {
                for (int j = K; j >= 1; j--) {
                    if(V[i] <= j)
                        dp[j] = Math.max(dp[j], C[i]);

                    if (j - V[i] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                        dp[j] = Math.max(dp[j], dp[j - V[i]] + C[i]);
                    }
                    else
                        dp[j] = Math.max(dp[j], dp[j - 1]);

                }
            }

//            System.out.println(Arrays.toString(dp));
            System.out.printf("#%d %d\n", tc, dp[K]);
        }

    }

}