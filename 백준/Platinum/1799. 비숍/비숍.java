import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int ret, cnt;
    static boolean[] diag, rDiag; // / \

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

        ret = 0; cnt = 0;
        diag = new boolean[2*N-1];
        rDiag = new boolean[2*N-1];
        dfs(0);
        System.out.println(ret);
    }

    private static void dfs(int depth) {
        if(cnt + 2*N - depth < ret)
            return;
//        System.out.println(Arrays.toString(diag));
//        System.out.println(Arrays.toString(rDiag));
//        System.out.println();

        if(depth == 2*N) {
            ret = Math.max(ret, cnt);
            return;
        }

        boolean notPlaced = true;
        if(depth < N) {
            int y = 0;
            int x = depth;
            for (int i = 0; i < depth+1; i++) {
                if(board[y][x] == 1 && !diag[y+x] && !rDiag[x-y+N-1]) {
                    notPlaced = false;

                    cnt++;
                    diag[y+x] = true;
                    rDiag[x-y+N-1] = true;
                    dfs(depth+1);
                    diag[y+x] = false;
                    rDiag[x-y+N-1] = false;
                    cnt--;
                }
                y++;
                x--;
            }
        } else {
            int y = N-1;
            int x = depth-N+1;
            for(int i=0;i<N-1-(depth-N);i++) {
                if(board[y][x] == 1 && !diag[y+x] && !rDiag[x-y+N-1]) {
                    notPlaced = false;

                    cnt++;
                    diag[y+x] = true;
                    rDiag[x-y+N-1] = true;
                    dfs(depth+1);
                    diag[y+x] = false;
                    rDiag[x-y+N-1] = false;
                    cnt--;
                }
                y--;
                x++;
            }
        }
        if(notPlaced)
            dfs(depth+1);

    }

    static int[] Dy = { -1, -1, 1, 1 };
    static int[] Dx = { -1, 1, -1, 1 };
    private static boolean isPossible(int y, int x) {
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i], nx = x + Dx[i];
            while(!(ny < 0 || nx < 0 || ny >= N || nx >= N)) {
                if(board[ny][nx] == 2)
                    return false;

                ny += Dy[i];
                nx += Dx[i];
            }
        }

        return true;
    }
}