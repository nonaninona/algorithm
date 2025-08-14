import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] board;
    static List<int[]> cores;
    static int ans, cnt, maxC, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 1)
                        cores.add(new int[]{i, j});
                }
            }

            ans = Integer.MAX_VALUE;
            cnt = 0;
            c = 0;
            maxC = 0;
            dfs(0);

            if (ans == Integer.MAX_VALUE)
                ans = 0;
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    private static void dfs(int depth) {
        if(cores.size() - depth + c < maxC)
            return;
//        System.out.println(depth);
        if (depth == cores.size()) {
//            System.out.println(cnt);
            if (maxC < c) {
                maxC = c;
                ans = cnt;
            } else if (maxC == c) {
                ans = Math.min(ans, cnt);
            }
            return;
        }

        int[] core = cores.get(depth);
        int y = core[0];
        int x = core[1];
        for (int i = 0; i < 4; i++) {
            int ret = line(y, x, Dy[i], Dx[i]);
//            System.out.println(i + " " + ret);
            if (ret == -1)
                continue;

            c++;
            cnt += ret;
            dfs(depth + 1);
            cnt -= ret;
            deleteLine(y, x, Dy[i], Dx[i]);
            c--;
        }

        dfs(depth+1);
    }

    private static void deleteLine(int y, int x, int dy, int dx) {
        int nY = y + dy;
        int nX = x + dx;
        while (!(nY < 0 || nX < 0 || nY >= N || nX >= N)) {
            board[nY][nX] = 0;
            nY += dy;
            nX += dx;
        }
    }

    private static int line(int y, int x, int dy, int dx) {
        int nY = y + dy;
        int nX = x + dx;

        if (nY < 0 || nX < 0 || nY >= N || nX >= N)
            return 0;

        if (board[nY][nX] != 0)
            return -1;

        board[nY][nX] = 2;

        int ret = line(nY, nX, dy, dx);


        if (ret == -1) {
            board[nY][nX] = 0;
            return -1;
        } else {
            return ret + 1;
        }
    }
}