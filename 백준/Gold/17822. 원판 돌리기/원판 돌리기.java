import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, T;
    static int[][] circles = null;
    static int[][] pointers = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        circles = new int[N+1][M];
        pointers = new int[N+1][2];
        for(int i=1;i<N+1;i++) {
            pointers[i][0] = 0;
            pointers[i][1] = M-1;
        }

        T = Integer.parseInt(st.nextToken());

        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
                circles[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            spin(x, d, k);

            check();
        }

        int ret = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<M;j++) {
                ret += circles[i][j];
            }
        }

        System.out.println(ret);
    }

    private static void check() {
        int[] Dy = {-1, 0, 1, 0};
        int[] Dx = {0, 1, 0, -1};

        boolean[][] check = new boolean[N+1][M];

        boolean isExist = false;

        for(int i=1;i<N+1;i++) {
            int y = i;
            int x = pointers[i][0];
            for(int j=0;j<M;j++) {
                for(int d=0;d<4;d++) {
                    int ny = y + Dy[d];
                    if(ny < 1 || ny >= N+1)
                        continue;

                    int nx = pointers[ny][0] + j + Dx[d];
                    if(nx < 0)
                        nx += M;
                    if(nx >= M)
                        nx -= M;

                    if(circles[y][x] == 0)
                        continue;

                    if(circles[ny][nx] == circles[y][x]) {
                        check[y][x] = true;
                        check[ny][nx] = true;
                        isExist = true;
                    }
                }
                x = (x+1)%M;
            }
        }

        if(isExist) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j])
                        circles[i][j] = 0;
                }
            }
            return;
        }

        double avg = 0.0;
        int count = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<M;j++) {
                avg += circles[i][j];
                if(circles[i][j] != 0)
                    count += 1;
            }
        }
        avg /= count;

        for(int i=1;i<N+1;i++) {
            for(int j=0;j<M;j++) {
                if(circles[i][j] == 0)
                    continue;
                if(circles[i][j] > avg)
                    circles[i][j] -= 1;
                else if(circles[i][j] < avg)
                    circles[i][j] += 1;
            }
        }
    }

    private static void spin(int x, int d, int k) {
        for(int i=x;i<N+1;i+=x) {
            if(d == 0) {
                pointers[i][0] -= k;
                pointers[i][1] -= k;
                if(pointers[i][0] < 0)
                    pointers[i][0] += M;
                if(pointers[i][1] < 0)
                    pointers[i][1] += M;
            } else {
                pointers[i][0] += k;
                pointers[i][1] += k;
                if(pointers[i][0] >= M)
                    pointers[i][0] -= M;
                if(pointers[i][1] >= M)
                    pointers[i][1] -= M;
            }
        }
    }
}

