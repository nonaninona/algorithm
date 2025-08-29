import java.util.*;
import java.io.*;

class Solution {

    static PriorityQueue<int[]> PQ;
    static int T, N;
    static int[][] board;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[100][100];
        dist = new int[100][100];
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dist[0][0] = 0;
            PQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
            PQ.offer(new int[]{0, 0, 0});
            while (!PQ.isEmpty()) {
                int[] node = PQ.poll();
                int d = node[0];
                int y = node[1];
                int x = node[2];

                if (dist[y][x] < d)
                    continue;

                for(int i=0;i<4;i++) {
                    int ny = y+Dy[i], nx = x+Dx[i];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                        continue;

                    int nD = board[ny][nx];
                    if(d + nD < dist[ny][nx]) {
                        dist[ny][nx] = d + nD;
                        PQ.offer(new int[]{dist[ny][nx], ny, nx});
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, dist[N-1][N-1]);

        }
    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};


}