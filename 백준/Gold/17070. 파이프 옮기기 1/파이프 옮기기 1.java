import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N][3]; // 0 - 가로, 1 - 세로, 2 - 대각선
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0 || i == 0 && j == 1 || i == 1 && j == 0 || i == 1 && j == 1)
                    continue;
                if(board[i][j] == 1)
                    continue;

                if (j - 1 >= 0)
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i - 1 >= 0)
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                if (i - 1 >= 0 && j - 1 >= 0 && board[i-1][j] == 0 && board[i][j-1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

//        for(int i=0;i<N;i++) {
//            for(int j=0;j<N;j++)
//                System.out.print(Arrays.toString(dp[i][j]) + " ");
//            System.out.println();
//        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}