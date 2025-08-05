import java.io.*;
import java.util.*;

public class Solution {

    static int[][] board;
    static boolean[][] v;
    static int sy, sx;
    static int ey, ex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[100][100];

        for(int tc=1;tc<10+1;tc++) {
            br.readLine();
            for(int i=0;i<100;i++) {
                String[] strs = br.readLine().split("");
                for(int j=0;j<100;j++) {
                    board[i][j] = Integer.parseInt(strs[j]);
                    if (board[i][j] == 2) {
                        sy = i;
                        sx = j;
                    } else if(board[i][j] == 3) {
                        ey = i;
                        ex = j;
                    }
                }
            }

            v = new boolean[100][100];
            dfs(sy, sx);
            System.out.println("#" + tc + " " + (v[ey][ex] ? 1 : 0));
        }


    }

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    private static void dfs(int y, int x) {

        v[y][x] = true;
        for(int i=0;i<4;i++) {
            int ny = y+Dy[i], nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= 100 || nx >= 100)
                continue;
            if(v[ny][nx])
                continue;
            if(board[ny][nx] == 1)
                continue;

            dfs(ny, nx);
        }
    }
}