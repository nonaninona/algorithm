import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][][] dp;
    static int[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[3][N][M]; // 0 - 왼쪽, 1 - 아래쪽, 2 - 오른쪽
        board = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j=0;j<3;j++)
            for(int i=0;i<M;i++)
                dp[j][0][i] = board[0][i];

        for(int i=1;i<N;i++) {
            for(int j=0;j<M;j++) {
                dp[0][i][j] = Integer.MAX_VALUE;
                if(j+1 < M)
                    dp[0][i][j] = board[i][j] + Math.min(dp[1][i-1][j+1], dp[2][i-1][j+1]);

                dp[1][i][j] = Integer.MAX_VALUE;
                dp[1][i][j] = board[i][j] + Math.min(dp[0][i-1][j], dp[2][i-1][j]);

                dp[2][i][j] = Integer.MAX_VALUE;
                if(0 <= j-1)
                    dp[2][i][j] = board[i][j] + Math.min(dp[0][i-1][j-1], dp[1][i-1][j-1]);
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[0][i]));
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[1][i]));
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[2][i]));
//        }

        int ret = Integer.MAX_VALUE;
        for(int j=0;j<3;j++)
            for(int i=0;i<M;i++)
                ret = Math.min(dp[j][N-1][i], ret);
        System.out.println(ret);
    }
}