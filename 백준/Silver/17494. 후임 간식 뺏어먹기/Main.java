import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;

public class Main {

    static int N, M;
    static int[] W, H;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        H = new int[N+1];

        int wSum = 0, hSum = 0;
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            H[i] = Integer.parseInt(st.nextToken());

            wSum += W[i];
            hSum += H[i];
        }

        if(wSum < M) {
            System.out.println("죄송합니다 한승엽 병장님");
            System.exit(0);
        }

        dp = new int[N+1][wSum-M+1];
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<wSum-M+1;j++) {
                if(j-W[i] < 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + H[i]);
            }
        }

//        for(int i=0;i<N+1;i++)
//            System.out.println(Arrays.toString(dp[i]));

        System.out.println(hSum - dp[N][wSum-M]);
    }
}