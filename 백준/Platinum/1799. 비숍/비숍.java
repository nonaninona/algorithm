import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int ret;
    static boolean[] rDiag; // / \

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 0;
        rDiag = new boolean[2*N-1];
        dfs(0, 0);

        int ans = ret;

        ret = 0;
        rDiag = new boolean[2*N-1];
        dfs(1, 0);

        ans += ret;
        System.out.println(ans);
    }

    private static void dfs(int depth, int cnt) {
        if(depth%2 == 0)
            if(cnt + (N - depth/2) < ret)
                return;
        else
            if(cnt + (N-1 - depth/2) < ret)
                return;
//        System.out.println(Arrays.toString(diag));
//        System.out.println(Arrays.toString(rDiag));
//        System.out.println();

        if(depth >= 2*N-1) {
            ret = Math.max(ret, cnt);
            return;
        }


        int yStart = Math.max(0, depth-(N-1));
        int yEnd = Math.min(depth, N-1);

        for(int y=yStart;y<=yEnd;y++) {
            int x = depth - y;
            if(board[y][x] == 1 && !rDiag[x-y+N-1]) {
                rDiag[x-y+N-1] = true;
                dfs(depth+2, cnt+1);
                rDiag[x-y+N-1] = false;
            }
        }
        dfs(depth+2, cnt);
    }
}