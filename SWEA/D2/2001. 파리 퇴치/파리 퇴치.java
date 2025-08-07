import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, T;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<T+1;tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N][N+1];
            for(int i=0;i<N;i++) {
                for(int j=1;j<N+1;j++) {
                    dp[i][j] = board[i][j-1] + dp[i][j-1];
                }
//                System.out.println(Arrays.toString(dp[i]));
            }

            int ret = 0;
            int sum = 0;
            for(int i=0;i<N-M+1;i++) {
                for(int j=0;j<N-M+1;j++) {
                    sum = 0;
                    for(int m=0;m<M;m++)
                        sum += dp[i+m][j+M] - dp[i+m][j];
                    ret = Math.max(ret, sum);
//                    System.out.println(i + " " + j + " " + sum);
                }
            }

            System.out.printf("#%d %d\n", tc, ret);

        }
    }
}