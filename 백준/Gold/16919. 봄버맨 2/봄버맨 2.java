import java.io.*;
import java.util.*;

public class Main {

    static int R, C, N;
    static int[][] board;
    static int[][][] ans;
    static final int NONE = -10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String s = row[j];
                if (s.equals("."))
                    board[i][j] = NONE;
                else
                    board[i][j] = 0;
            }
        }

        ans = new int[4][R][C];
        int time = 1;

        if(time == N) {
            printBoard(board);
            return;
        }

        while (time < 6) {
            time++;
            if (time % 2 == 0)
                plant(time);
            else
                bomb(time);

            if(time >= 3) {
                copyToAns(time - 3);
            }

            if(time == N) {
                printBoard(board);
                return;
            }
        }

        printBoard(ans[(N-3)%4]);
    }

    private static void bomb(int t) {
        int[][] newBoard = new int[R][C];
        for (int i = 0; i < R; i++)
            newBoard[i] = Arrays.copyOf(board[i], C);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == t - 3) {
                    newBoard[i][j] = NONE;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + Dy[k];
                        int nx = j + Dx[k];

                        if (ny < 0 || nx < 0 || ny >= R || nx >= C)
                            continue;

                        newBoard[ny][nx] = NONE;
                    }
                }
            }
        }
        board = newBoard;
    }

    private static void plant(int t) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == NONE)
                    board[i][j] = t;
            }
        }
    }

    private static void copyToAns(int idx) {
        for (int i = 0; i < R; i++)
            ans[idx][i] = Arrays.copyOf(board[i], C);
    }

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, 1, -1};

    private static void printBoard(int[][] b) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (b[i][j] >= 0)
                    System.out.print("O");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }
}