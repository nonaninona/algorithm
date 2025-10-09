import java.io.*;
import java.util.*;

class Main {

    static int[][] B;
    static boolean[][][] V;
    static int N;
    static PriorityQueue<int[]> Q;

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        B = new int[N][N];
        int bCount = 0;
        int cell = -1;
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                cell = Integer.parseInt(row[j]);
                if (cell == 0)
                    bCount++;
                B[i][j] = cell;
            }
        }

        int ans = -1;

        V = new boolean[bCount+1][N][N];
        Q = new PriorityQueue<>(Comparator.comparing((int[] l) -> l[0]));
        Q.offer(new int[]{0, 0, 0}); // 횟수, y, x
        while (!Q.isEmpty()) {
            int[] node = Q.poll();
            int c = node[0];
            int y = node[1];
            int x = node[2];

            if(V[c][y][x])
                continue;

            if(y == N-1 && x == N-1) {
                ans = c;
                break;
            }

            V[c][y][x] = true;

            int ny = -1;
            int nx = -1;
            int nc = -1;
            for(int i=0;i<4;i++) {
                ny = y+Dy[i];
                nx = x+Dx[i];
                nc = c;

                if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                    continue;

                if(B[ny][nx] == 0) {
                    nc = c+1;
                }

                if(V[nc][ny][nx])
                    continue;

                Q.offer(new int[]{nc, ny, nx});
            }
        }

        System.out.println(ans);
    }
}
