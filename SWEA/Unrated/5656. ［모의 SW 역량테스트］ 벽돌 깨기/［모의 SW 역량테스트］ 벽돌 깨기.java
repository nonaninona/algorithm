import java.util.*;
import java.io.*;

class Solution {

    static int T, N, W, H;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] board;
            board = new int[H][W];
            ans = 0;
            for(int i=0;i<H;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j] != 0)
                        ans++;
                }
            }

//            System.out.println("board");
//            for(int i=0;i<H;i++) {
//                System.out.println(Arrays.toString(board[i]));
//            }
//            System.out.println(ans);
//            System.out.println();

            dfs(0, ans, board);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void dfs(int depth, int count, int[][] board) {
        if(depth == N) {
            ans = Math.min(ans, count);
            return;
        }

        for(int j=0;j<W;j++) {
            int[][] nBoard = new int[H][W];
            for(int i=0;i<H;i++)
                nBoard[i] = Arrays.copyOf(board[i], W);
            int removeCnt = initBomb(nBoard, j);
            nBoard = drop(nBoard);
//            System.out.println();
//            System.out.println("depth " + depth + " pos " + j + " rmCount " + removeCnt);
//            for(int i=0;i<H;i++)
//                System.out.println(Arrays.toString(nBoard[i]));
//            System.out.println();
            dfs(depth+1, count - removeCnt, nBoard);
        }
    }

    private static int[][] drop(int[][] board) {
        int[][] nBoard = new int[H][W];

        for(int j=0;j<W;j++) {
            int zeroCnt = 0;
            for(int i=H-1;i>=0;i--) {
                if(board[i][j] == 0)
                    zeroCnt++;
            }
            for(int i=0;i<zeroCnt;i++)
                nBoard[i][j] = 0;
            int idx = zeroCnt;
            for(int i=0;i<H;i++) {
                if(board[i][j] != 0) {
                    nBoard[idx][j] = board[i][j];
                    idx++;
                }
            }
        }

        return nBoard;
    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    private static int initBomb(int[][] board, int pos) {
        int rmCnt = 0;
        for(int i=0;i<H;i++) {
            if(board[i][pos] != 0) {
                rmCnt += bomb(board, i, pos);
                break;
            }
        }
        return rmCnt;
    }

    private static int bomb(int[][] board, int y, int x) {
        int range = board[y][x];
        board[y][x] = 0;

        int cnt = 1;
        for(int d=0;d<4;d++) {
            int idx = 1;
            int ny = y+Dy[d], nx = x+Dx[d];
            while (!(ny < 0 || nx < 0 || ny >= H || nx >= W)) {
                if(idx == range)
                    break;

                if(board[ny][nx] != 0)
                    cnt += bomb(board, ny, nx);

                ny += Dy[d];
                nx += Dx[d];
                idx++;
            }
        }

        return cnt;
    }

}