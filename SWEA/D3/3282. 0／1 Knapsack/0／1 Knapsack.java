import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, K;
    static int[] V, C;
    static int[] dp;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            V = new int[N];
            C = new int[N];
            dp = new int[K+1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = K; j >= V[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - V[i]] + C[i]);
                }
            }

//            System.out.println(Arrays.toString(dp));
            builder.append("#").append(tc).append(" ").append(dp[K]).append("\n");
        }
        System.out.println(builder);

    }

}