import java.util.*;
import java.io.*;

class Main {

    static int K, W, H, ans;
    static int[][] board;
    static boolean[][][] V;
    static Queue<int[]> Q;

    static int[] Dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] Dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] Dy2 = {-1, 0, 1, 0};
    static int[] Dx2 = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        V = new boolean[H][W][K+1];
        V[0][0][K] = true;
        ans = Integer.MAX_VALUE;

        Q = new ArrayDeque<>();
        Q.offer(new int[] { 0, 0, K, 0 });
        while(!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int k = node[2];
            int h = node[3];

            if(y == H-1 && x == W-1) {
                ans = h;
                break;
            }

            if(k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + Dy[i], nx = x + Dx[i];
                    if(ny < 0 || nx < 0 || ny >= H || nx >= W)
                        continue;
                    if(V[ny][nx][k-1])
                        continue;
                    if(board[ny][nx] == 1)
                        continue;
                    V[ny][nx][k-1] = true;
                    Q.offer(new int[]{ny, nx, k - 1, h + 1});
                }
            }

            for(int i=0;i<4;i++) {
                int ny = y + Dy2[i], nx = x + Dx2[i];
                if(ny < 0 || nx < 0 || ny >= H || nx >= W)
                    continue;
                if(V[ny][nx][k])
                    continue;
                if(board[ny][nx] == 1)
                    continue;
                V[ny][nx][k] = true;
                Q.offer(new int[]{ny, nx, k, h + 1});
            }

        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}