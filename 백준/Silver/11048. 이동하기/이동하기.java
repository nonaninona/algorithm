import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                dp[i + 1][j + 1] = Integer.parseInt(st.nextToken());
                int max = Math.max(dp[i][j+1], dp[i+1][j]);
                max = Math.max(max, dp[i][j]);
                dp[i+1][j+1] += max;
            }
        }

        System.out.println(dp[N][M]);
    }
}