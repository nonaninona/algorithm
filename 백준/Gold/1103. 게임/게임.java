import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] B;
    static boolean[][] V;
    static boolean[][][] dp;
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
        dp = new boolean[N][M][N*M+1];
        V = new boolean[N][M];
        V[0][0] = true;
        dfs(0, 0, 1);

        System.out.println(ans);

    }

    private static void dfs(int y, int x, int c) {
        ans = Math.max(ans, c);
        if(dp[y][x][c])
            return;
        dp[y][x][c] = true;
//        System.out.println(y + " " + x + " " + c + " " + ans);

        for(int i=0;i<4;i++) {
            if(ans == -1)
                return;

            int ny = y + (B[y][x]-'0') * Dy[i];
            int nx = x + (B[y][x]-'0') * Dx[i];

//            System.out.println(ny + " " + nx);

            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(B[ny][nx] == 'H')
                continue;
            if(V[ny][nx]) {
                ans = -1;
                return;
            }

            V[ny][nx] = true;
            dfs(ny, nx, c+1);
            V[ny][nx] = false;
        }
    }
}