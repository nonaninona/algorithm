import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] W;
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N+1][40001];
        dp[0][0] = true;
        for(int i=0;i<N;i++) {
            for(int j=0;j<40001;j++) {
                if(dp[i][j]) {
                    if(j+W[i] <= 40000)
                        dp[i+1][j+W[i]] = true;
                    dp[i+1][Math.abs(j-W[i])] = true;
                    dp[i+1][j] = true;
                }
            }
        }
//        for(int i=0;i<N+1;i++) {
//            for(int j=0;j<100;j++)
//                System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int query = Integer.parseInt(st.nextToken());
            if(dp[N][query])
                sb.append("Y");
            else
                sb.append("N");
            sb.append(" ");
        }

        System.out.println(sb);

    }
}