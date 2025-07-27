import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] dist;
    static PriorityQueue<int[]> queue;

    static int[] Dy  = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0)
                break;

            board = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N][N];
            for(int i=0;i<N;i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[2]));
            queue.offer(new int[]{0, 0, board[0][0]});
            dist[0][0] = board[0][0];

            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                int y = node[0];
                int x = node[1];
                int w = node[2];

                if(dist[y][x] < w)
                    continue;

                for(int i=0;i<4;i++) {
                    int nY = y + Dy[i];
                    int nX = x + Dx[i];

                    if(nY < 0 || nX < 0 || nY >= N || nX >= N)
                        continue;

                    int nW = board[nY][nX];
                    if(w + nW < dist[nY][nX]) {
                        dist[nY][nX] = w + nW;
                        queue.offer(new int[]{nY, nX, dist[nY][nX]});
                    }
                }
            }

            System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);

            tc++;
        }

    }
}