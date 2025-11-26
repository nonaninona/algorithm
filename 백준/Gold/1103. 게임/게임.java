import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] B;
    static boolean[][] V;
    static int[][] dp;
    static int ans;

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = row.charAt(j);
            }
        }

        ans = 0;

        V = new boolean[N][M];
        V[0][0] = true;

        dp = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(dp[i], -1);
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(B[i][j] == 'H')
                    continue;

                boolean isBase = true;
                for(int k=0;k<4;k++) {
                    int ny = i + (B[i][j] - '0') * Dy[k];
                    int nx = j + (B[i][j] - '0') * Dx[k];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || B[ny][nx] == 'H')
                        continue;
                    isBase = false;
                    break;
                }

                if(isBase)
                    dp[i][j] = 0;
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        dfs(0, 0);

        if(ans == -1)
            System.out.println(-1);
        else
            System.out.println(dp[0][0] + 1);

    }

    private static int dfs(int y, int x) {
        if(ans == -1)
            return -1;

        if(dp[y][x] != -1)
            return dp[y][x];

        int ret = 0;
        for(int i=0;i<4;i++) {
            if(ans == -1)
                return -1;

            int ny = y + (B[y][x]-'0') * Dy[i];
            int nx = x + (B[y][x]-'0') * Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(B[ny][nx] == 'H')
                continue;
            if(V[ny][nx]) {
                ans = -1;
                return -1;
            }

            V[ny][nx] = true;
            ret = Math.max(ret, 1 + dfs(ny, nx));
            V[ny][nx] = false;
        }

        return dp[y][x] = ret;
    }
}