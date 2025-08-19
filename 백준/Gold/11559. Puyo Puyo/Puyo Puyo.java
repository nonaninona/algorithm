import java.io.*;
import java.util.*;

class Main {

    static char[][] board;
    static int[][] V;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];
        for(int i=0;i<12;i++) {
            String row = br.readLine();
            for(int j=0;j<6;j++) {
                board[i][j] = row.charAt(j);
            }
        }

        ans = 0;
        while(true) {
            V = new int[12][6];
            boolean isPop = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (V[i][j] == 0 && board[i][j] != '.') {
                        int ret = dfs(i, j, board[i][j]);
                        if (ret >= 4) {
                            isPop = true;
                            markDfs(i, j, board[i][j], 2);
                        } else {
                            markDfs(i, j, board[i][j], 1);
                        }
                    }
                }
            }

//            for(int i=0;i<12;i++)
//                System.out.println(Arrays.toString(board[i]));
//            System.out.println();
//            for(int i=0;i<12;i++)
//                System.out.println(Arrays.toString(V[i]));
//            System.out.println();

            if (!isPop) break;

            ans++;

            char[][] newBoard = new char[12][6];
            for (int j = 0; j < 6; j++) {
                int pos = 11;
                for (int i = 11; i >= 0; i--) {
                    if(V[i][j] == 2)
                        continue;

                    newBoard[pos][j] = board[i][j];
                    pos--;
                }
                for(int i = 0; i < pos + 1; i++) {
                    newBoard[i][j] = '.';
                }
            }
            board = newBoard;

//            for(int i=0;i<12;i++)
//                System.out.println(Arrays.toString(board[i]));
//            System.out.println();
        }

        System.out.println(ans);

    }

    private static void markDfs(int y, int x, char c, int v) {
        V[y][x] = v;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i], nx = x + Dx[i];
            if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6)
                continue;
            if(board[ny][nx] != c)
                continue;
            if(V[ny][nx] != 3)
                continue;
            markDfs(ny, nx, c, v);
        }
    }

    static int[] Dy = { -1, 0, 1, 0 };
    static int[] Dx = { 0, 1, 0, -1 };
    private static int dfs(int y, int x, char c) {
        int ret = 1;

        V[y][x] = 3;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i], nx = x + Dx[i];
            if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6)
                continue;
            if(board[ny][nx] != c)
                continue;
            if(V[ny][nx] != 0)
                continue;
            ret += dfs(ny, nx, c);
        }

        return ret;
    }
}