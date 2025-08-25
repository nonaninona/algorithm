import java.util.*;
import java.io.*;

class Solution {

    static int T, N;
    static char[][] board;
    static int[][] cBoard;
    static boolean[][] V;

    static int[] Dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] Dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            for(int i=0;i<N;i++) {
                String row = br.readLine();
                for(int j=0;j<N;j++)
                    board[i][j] = row.charAt(j);
            }

            cBoard = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(board[i][j] == '*') {
                        cBoard[i][j] = -1;
                        for(int k=0;k<8;k++) {
                            int ny = i+Dy[k], nx = j+Dx[k];
                            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                                continue;
                            if(board[ny][nx] != '*')
                                cBoard[ny][nx]++;
                        }
                    }
                }
            }

//            for(int i=0;i<N;i++)
//                System.out.println(Arrays.toString(cBoard[i]));

            V = new boolean[N][N];
            int ans = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if (!V[i][j] && cBoard[i][j] == 0) {
                        V[i][j] = true;
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if (!V[i][j] && cBoard[i][j] != -1) {
                        ans++;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void dfs(int y, int x) {
        for(int i=0;i<8;i++) {
            int ny = y+Dy[i], nx = x+Dx[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
            if(V[ny][nx])
                continue;

            V[ny][nx] = true;
            if(cBoard[ny][nx] == 0)
                dfs(ny, nx);
        }
    }
}