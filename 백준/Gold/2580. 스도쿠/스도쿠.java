import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[9][9];
    static List<int[]> dots = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();
    static boolean[][] row = new boolean[9][9];
    static boolean[][] column = new boolean[9][9];
    static boolean[][][] grid = new boolean[9][3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
               board[i][j] = Integer.parseInt(st.nextToken());
               int num = board[i][j];
               if(num == 0)
                   dots.add(new int[]{i, j});
               else {
                   row[num-1][i] = true;
                   column[num-1][j] = true;
                   grid[num-1][i/3][j/3] = true;
               }
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth == dots.size()) {
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++)
                    builder.append(board[i][j]).append(" ");
                builder.append("\n");
            }
            System.out.println(builder);
            System.exit(0);
        }

        int y = dots.get(depth)[0];
        int x = dots.get(depth)[1];

        for(int num=1;num<10;num++) {
            boolean isPossible = isPossible(y, x, num);
            if (isPossible) {
                board[y][x] = num;
                row[num-1][y] = true;
                column[num-1][x] = true;
                grid[num-1][y/3][x/3] = true;
                dfs(depth+1);
                board[y][x] = 0;
                row[num-1][y] = false;
                column[num-1][x] = false;
                grid[num-1][y/3][x/3] = false;
            }
        }
    }

    private static boolean isPossible(int y, int x, int num) {
        return !(row[num-1][y] || column[num-1][x] || grid[num-1][y/3][x/3]);
    }
}