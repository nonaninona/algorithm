import java.io.*;
import java.util.*;

public class Main {

    static int N, M, F;
    static int[][] board;
    static int[][] dist;
    static Queue<int[]> Q;
    static int[][] guests;
    static boolean[] V;
    static int sy, sx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken())-1;
        sx = Integer.parseInt(st.nextToken())-1;

        guests = new int[M][4];
        V = new boolean[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int ty = Integer.parseInt(st.nextToken())-1;
            int tx = Integer.parseInt(st.nextToken())-1;

            guests[i][0] = y;
            guests[i][1] = x;
            guests[i][2] = ty;
            guests[i][3] = tx;
        }

        System.out.println(solve());
    }

    private static int solve() {
        int guestCount = M;

        while(guestCount > 0) {
            bfs(sy, sx);
            int gIdx = findGuest();
            if(gIdx == -1)
                return -1;
            V[gIdx] = true;

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(dist[i]));
//            }

            int y = guests[gIdx][0];
            int x = guests[gIdx][1];
            int ty = guests[gIdx][2];
            int tx = guests[gIdx][3];
            if (F < dist[y][x])
                return -1;
            F -= dist[y][x];
//            System.out.println("take : " + F);

            bfs(y, x);
            if(dist[ty][tx] == -1)
                return -1;
            if (F < dist[ty][tx])
                return -1;
            F += dist[ty][tx];
            guestCount--;
//            System.out.println("ride : " + F);

            sy = ty;
            sx = tx;
        }

        return F;
    }

    private static int findGuest() {
        int minIdx = -1;
        int minY = -1;
        int minX = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < guests.length;i++) {
            if(V[i]) continue;

            int[] guest = guests[i];
            int y = guest[0];
            int x = guest[1];
            if(dist[y][x] == -1)
                continue;

            if(dist[y][x] < min) {
                min = dist[y][x];
                minY = y;
                minX = x;
                minIdx = i;
            } else if(dist[y][x] == min) {
                if(y < minY) {
                    minY = y;
                    minX = x;
                    minIdx = i;
                } else if(y == minY) {
                    if(x < minX) {
                        minX = x;
                        minIdx = i;
                    }
                }
            }
        }

        return minIdx;
    }

    private static void bfs(int sY, int sX) {
        dist = new int[N][N];
        for(int i=0;i<N;i++)
            Arrays.fill(dist[i], -1);
        Q = new ArrayDeque<>();
        Q.offer(new int[] { sY, sX, 0 });
        while(!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int d = node[2];

            if(dist[y][x] != -1)
                continue;

            dist[y][x] = d;
            for(int i=0;i<4;i++) {
                int ny = y + Dy[i], nx = x + Dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                    continue;
                if(dist[ny][nx] != -1)
                    continue;
                if(board[ny][nx] == 1)
                    continue;

                Q.offer(new int[]{ny, nx, d + 1});
            }
        }
    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};
}