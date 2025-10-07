import java.io.*;
import java.util.*;

class Main {

    static int N, M, K;
    static boolean[][][] visited;
    static Queue<int[]> Q;
    static int[][] board;

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0;i<N;i++) {
            String[] row = br.readLine().split("");
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        Q = new ArrayDeque<>();
        visited = new boolean[N][M][K+1];

        System.out.println(bfs());



    }

    public static int bfs() {
        Q.offer(new int[]{0, 0, K, 1});
        visited[0][0][K] = true;

        while(!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int k = node[2];
            int d = node[3];

//            System.out.println(y + " " + x + " " + k + " " + d);

            if(y == N-1 && x == M-1)
                return d;

//            System.out.println(1);

            for(int i=0;i<4;i++) {
                int ny = y+Dy[i];
                int nx = x+Dx[i];
                int nk = k;

                if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;

//                System.out.println(2);

                if(board[ny][nx] == 1) {
                    if(k == 0)
                        continue;
                    else
                        nk = k-1;
                }

//                System.out.println(3);

                if(visited[ny][nx][nk])
                    continue;

//                System.out.println(ny + " " + nx + " " + nk + " " + (d+1));
                Q.offer(new int[]{ny, nx, nk, d+1});
                visited[ny][nx][nk] = true;
            }

        }
        return -1;
    }


}
