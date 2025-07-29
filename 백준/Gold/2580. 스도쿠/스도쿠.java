import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[9][9];
    static List<int[]> dots = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
               board[i][j] = Integer.parseInt(st.nextToken());
               if(board[i][j] == 0)
                   dots.add(new int[]{i, j});
            }
        }

//        for(int i=0;i<dots.size();i++)
//            System.out.println(Arrays.toString(dots.get(i)));
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
//            System.out.println(y + " " + x + " " + num + " " + isPossible);
            if (isPossible) {
                board[y][x] = num;
                dfs(depth+1);
                board[y][x] = 0;
            }
        }
    }

    private static boolean isPossible(int y, int x, int num) {
        for(int i=0;i<9;i++) {
            if(board[i][x] == num)
                return false;
        }

        for(int i=0;i<9;i++) {
            if(board[y][i] == num)
                return false;
        }
        int iStart = y/3*3;
        int jStart = x/3*3;
        for(int i=iStart;i<iStart+3;i++) {
            for(int j=jStart;j<jStart+3;j++) {
                if(board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}