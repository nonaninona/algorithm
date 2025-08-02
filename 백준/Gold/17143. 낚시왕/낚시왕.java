import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;

public class Main {

    static int R, C, M;
    static int[][] sharks;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        sharks = new int[M][5];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sharks[i][0] = Integer.parseInt(st.nextToken()) - 1;
            sharks[i][1] = Integer.parseInt(st.nextToken()) - 1;
            sharks[i][2] = Integer.parseInt(st.nextToken());
            sharks[i][3] = Integer.parseInt(st.nextToken()) - 1;
            sharks[i][4] = Integer.parseInt(st.nextToken());
//            System.out.println(sharks[i][0] + " " + sharks[i][1] + " " + (i+1));
            board[sharks[i][0]][sharks[i][1]] = i + 1;
        }
//        printBoard();

        int ret = 0;
        for (int j = 0; j < C; j++) {
//            System.out.println("fishing");
            ret += fishing(j);
//            printBoard();
//            System.out.println("moving");
            move();
//            printBoard();
//            printSharks();
        }
        System.out.println(ret);

    }

    private static void printBoard() {
        for (int i = 0; i < R; i++)
            System.out.println(Arrays.toString(board[i]));
        System.out.println();
    }

    private static void printSharks() {
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.toString(sharks[i]));
        System.out.println();
    }

    private static int fishing(int j) {
        for (int i = 0; i < R; i++) {
            if (board[i][j] == 0)
                continue;

            int sid = board[i][j] - 1;
            sharks[sid][0] = -1;
            sharks[sid][1] = -1;
            board[i][j] = 0;

            return sharks[sid][4];
        }
        return 0;
    }

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, 1, -1};

    private static void move() {
        int[][] newBoard = new int[R][C];
        for (int i = 0; i < M; i++) {
            int[] shark = sharks[i];
            int y = shark[0];
            int x = shark[1];
            int s = shark[2];
            int d = shark[3];
            int z = shark[4];

            if (y == -1 && x == -1)
                continue;

//            System.out.println(y + " " + x + "  " + s + " " + d + " " + z);

            int ny = y;
            int nx = x;
            if (d == 0 || d == 1) {
                s %= (2 * R - 2);
                while (s > 0) {
                    if (ny == R - 1)
                        d = 0;
                    else if (ny == 0)
                        d = 1;

                    ny += Dy[d];
                    s--;
                }
            } else if (d == 2 || d == 3) {
                s %= (2 * C - 2);
                while (s > 0) {
                    if (nx == C - 1)
                        d = 3;
                    else if (nx == 0)
                        d = 2;

                    nx += Dx[d];
                    s--;
                }
            }

//            System.out.println(y + " " + x);

            shark[0] = ny;
            shark[1] = nx;
            shark[3] = d;

            if (newBoard[ny][nx] == 0) {
                newBoard[ny][nx] = i + 1;
                continue;
            }

            int otherSid = newBoard[ny][nx]-1;
            if (sharks[otherSid][4] > z) {
                shark[0] = -1;
                shark[1] = -1;
            } else {
                sharks[otherSid][0] = -1;
                sharks[otherSid][1] = -1;
                newBoard[ny][nx] = i + 1;
            }
        }

        board = newBoard;
    }
}