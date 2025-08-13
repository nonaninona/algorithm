import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0;i<R;i++) {
            String[] row = br.readLine().split("");
            for(int j=0;j<C;j++) {
                board[i][j] = row[j].charAt(0);
            }
        }

        ans = 0;
        for(int i=0;i<R;i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static boolean dfs(int y, int x) {
        if(x == C-1) {
            ans++;
//            for(int i=0;i<R;i++)
//                System.out.println(Arrays.toString(board[i]));
            return true;
        }

        if(y-1 >= 0 && board[y-1][x+1] == '.') {
            board[y-1][x+1] = 'O';
            if(dfs(y-1, x+1)) {
                return true;
            }
            board[y - 1][x + 1] = '.';
        }
        if(board[y][x+1] == '.') {
            board[y][x+1] = 'O';
            if(dfs(y, x+1)) {
                return true;
            }
            board[y][x + 1] = '.';
        }
        if(y+1 < R && board[y+1][x+1] == '.') {
            board[y+1][x+1] = 'O';
            if(dfs(y+1, x+1)) {
                return true;
            }
        }

        return false;
    }
}