import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D;
    static int[][] board;
    static int[] B;
    static boolean[] V;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        V = new boolean[M];
        B = new int[3];
        ans = 0;
        perm(0, 0);
        System.out.println(ans);
    }

    public static void perm(int depth, int start) {
        if (depth == 3) {
//            System.out.println(Arrays.toString(B));
            ans = Math.max(ans, calc());
            return;
        }

        for (int i = start; i < M; i++) {
            if (V[i]) continue;
            B[depth] = i;
            V[i] = true;
            perm(depth + 1, i+1);
            V[i] = false;
        }

    }

    static int[][] newBoard;

    private static int calc() {
        newBoard = new int[N][];
        for (int i = 0; i < N; i++)
            newBoard[i] = Arrays.copyOf(board[i], M);

        int[] y, x, d;
        y = new int[3];
        x = new int[3];
        d = new int[3];
        Arrays.fill(y, -1);
        Arrays.fill(x, -1);
        Arrays.fill(d, Integer.MAX_VALUE);

        int count = 0;
        for (int k = 0; k < N; k++) {
            for (int a = 0; a < 3; a++) {
                int aX = B[a];
                int aY = N;
                for (int i = 0; i < N - k; i++) {
                    for (int j = 0; j < M; j++) {
                        if (newBoard[i][j] == 1) {
                            int dist = Math.abs(aX - j) + aY - i - k;
                            if(dist > D)
                                continue;
                            if (dist < d[a]) {
                                d[a] = dist;
                                y[a] = i;
                                x[a] = j;
                            } else if (dist == d[a]) {
                                if (j < x[a]) {
                                    y[a] = i;
                                    x[a] = j;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < 3; a++) {
                if (y[a] == -1 || x[a] == -1)
                    continue;

                if (newBoard[y[a]][x[a]] == 1) {
                    newBoard[y[a]][x[a]] = 0;
                    count++;
                }
            }

            Arrays.fill(y, -1);
            Arrays.fill(x, -1);
            Arrays.fill(d, Integer.MAX_VALUE);

//            System.out.println(count);
//            printBoard();
//            System.out.println();
        }

        return count;
    }

    private static void printBoard() {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(newBoard[i]));
    }
}