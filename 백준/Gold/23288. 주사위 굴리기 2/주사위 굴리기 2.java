import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] B;
    static int[][] dice = {
            {0, 2, 0},
            {4, 1, 3},
            {0, 5, 0},
            {0, 6, 0}
    };

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};
    static int d = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        int y = 0;
        int x = 0;
        int k = 0;
        int ans = 0;
        while (k < K) {
            //judge direction
            int ny = y + Dy[d];
            int nx = x + Dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                d = (d + 2) % 4;
                ny = y + Dy[d];
                nx = x + Dx[d];
            }

            // move
//            System.out.println("roll " + d);
            roll(d);
            y = ny;
            x = nx;

            //add score
            ans += getScore(y, x);

            //judge next direction
            int a = dice[3][1];
            int b = B[y][x];
            if (a > b) {
                d = (d + 1) % 4;
            } else if (a < b) {
                d = (d - 1);
                if(d < 0)
                    d+=4;
            }

//            System.out.println(y + " " + x);
//            for(int i=0;i<4;i++)
//                System.out.println(Arrays.toString(dice[i]));
//            System.out.println(d);
//            System.out.println(ans);

            k++;
        }

        System.out.println(ans);
    }

    private static void roll(int dir) {

//        {0, 2, 0},
//        {4, 1, 3},
//        {0, 5, 0},
//        {0, 6, 0}

        if (dir == 0) {
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        } else if (dir == 1) {
            int temp = dice[3][1];
            dice[3][1] = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = temp;
        } else if (dir == 2) {
            int temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        } else if (dir == 3) {
            int temp = dice[3][1];
            dice[3][1] = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = temp;
        }
    }

    static boolean[][] V;
    private static int getScore(int y, int x) {
        int n = B[y][x];
        V = new boolean[N][M];
        V[y][x] = true;
        return n * dfs(y, x, n);
    }

    private static int dfs(int y, int x, int n) {
        int c = 1;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(V[ny][nx] || B[ny][nx] != n)
                continue;
            V[ny][nx] = true;

            c += dfs(ny, nx, n);
        }
        return c;
    }
}