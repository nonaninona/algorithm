import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[] count;
    static int ret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        count = new int[]{0, 5, 5, 5, 5, 5};

        ret = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if (ret == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ret);
    }

    private static void dfs(int y, int x, int cnt) {
//        System.out.println(y + " " + x + " " + cnt);
        if (y == 9 && x == 10) {
            ret = Math.min(ret, cnt);
            return;
        }

        if (x == 10) {
            dfs(y + 1, 0, cnt);
            return;
        }

        if (board[y][x] == 1) {
            for (int s = 5; s > 0; s--) {
                if (count[s] <= 0)
                    continue;
                if (!checkPossible(y, x, s))
                    continue;
                removeBoard(y, x, s);
                count[s]--;
//                printBoard();
                dfs(y, x + 1, cnt + 1);
                setBoard(y, x, s);
                count[s]++;
            }
        } else {
            dfs(y, x + 1, cnt);
        }
    }

    private static void printBoard() {
        for(int i=0;i<10;i++)
            System.out.println(Arrays.toString(board[i]));
        System.out.println();
    }

    private static boolean checkPossible(int y, int x, int s) {
        if (y + s > 10 || x + s > 10)
            return false;

        for (int i = y; i < y + s; i++)
            for (int j = x; j < x + s; j++)
                if (board[i][j] == 0)
                    return false;
        return true;
    }

    private static void removeBoard(int y, int x, int s) {
        for (int i = y; i < y + s; i++)
            for (int j = x; j < x + s; j++)
                board[i][j] = 0;
    }

    private static void setBoard(int y, int x, int s) {
        for (int i = y; i < y + s; i++)
            for (int j = x; j < x + s; j++)
                board[i][j] = 1;
    }

    private static boolean isPossible(int y, int x, int s) {
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                if (board[y + i][x + j] == 0)
                    return false;
        return true;
    }
}