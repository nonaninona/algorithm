import java.io.*;
import java.util.*;

public class Solution {

    static Set<String> S;
    static int[][] board;
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        board = new int[4][4];
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            S = new HashSet<>();
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    dfs(0, i, j, "");
                }
            }

            System.out.printf("#%d %d\n", tc, S.size());
        }

    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    private static void dfs(int depth, int y, int x, String s) {
        if(depth == 7) {
            S.add(s);
            return;
        }

        for(int i=0;i<4;i++) {
            int ny = y + Dy[i], nx = x + Dx[i];
            if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
                continue;
            dfs(depth+1, ny, nx, s+board[y][x]);
        }
    }

}