import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static Queue<int[]> Q;
    static int[][] visited;
    static char[][] board;
    static int sy, sx, ey, ex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken()) - 1;
        sx = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;
        ex = Integer.parseInt(st.nextToken()) - 1;

        visited = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(visited[i], -1);
        Q = new ArrayDeque<>();
        Q.offer(new int[] { sy, sx, 0 });
        visited[sy][sx] = 0;

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int d = node[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + Dy[i], nx = x + Dx[i];
                int k = 1;
                while (!(ny < 0 || nx < 0 || ny >= N || nx >= M) && k <= K) {
                    if (board[ny][nx] == '#')
                        break;
                    if (ny == ey && nx == ex)
                        return d + 1;
                    if (visited[ny][nx] != -1) {
                        if (d + 1 > visited[ny][nx])
                            break;
                        else {
                            k++;
                            ny += Dy[i];
                            nx += Dx[i];
                            continue;
                        }
                    }

                    Q.offer(new int[] { ny, nx, d + 1 });
                    visited[ny][nx] = d+1;
                    k++;
                    ny += Dy[i];
                    nx += Dx[i];
                }
            }
        }
        return -1;
    }

    static int[] Dy = { -1, 0, 1, 0 };
    static int[] Dx = { 0, 1, 0, -1 };

}