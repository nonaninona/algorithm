import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};

    static int N;
    static int M;
    static int[][] board = null;
    static boolean[][] visited = null;
    static int[][] around = null;

    public static void dfs(int y, int x) {
        if(board[y][x] == 1)
            return;

        for (int i = 0; i < 4; i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;

            if(board[y][x] == 0)
                around[ny][nx]++;

            if(visited[ny][nx])
                continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cheeseCount = 0;
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    cheeseCount++;
            }
        }
        visited = new boolean[N][M];
        around = new int[N][M];

        int time = 0;
        while(cheeseCount > 0) {
            time++;
            dfs(0, 0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1 && around[i][j] >= 2) {
                        board[i][j] = 0;
                        cheeseCount--;
                    }
                }
            }
            visited = new boolean[N][M];
            around = new int[N][M];
        }

        System.out.println(time);

    }
}