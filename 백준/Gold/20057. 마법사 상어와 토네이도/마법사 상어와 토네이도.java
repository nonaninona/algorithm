import java.io.*;
import java.util.*;

class Main {

    static int[][] B;
    static int N;

    static int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

    // 왼쪽, 아래쪽, 오른쪽, 위쪽
    static int[][] tDy;
    static int[][] tDx;

    static int[] Dy = { 0, 1, 0, -1 };
    static int[] Dx = { -1, 0, 1, 0 };

    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        B = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        tDy = new int[4][10];
        tDx = new int[4][10];
        tDy[0] = new int[] {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0};
        tDx[0] = new int[] { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 };
        for(int i=1;i<4;i++) {
            for(int j=0;j<10;j++) {
                tDy[i][j] = -tDx[i-1][j];
                tDx[i][j] = tDy[i-1][j];
            }
        }

        ans = 0;

        int size = 0;
        int dir = 0;
        int y = N/2;
        int x = N/2;
        for(int i=0;i<2*N-1;i++) {
            if(i%2==0 && i != 2*N-2)
                size++;

//            System.out.println("arrow");
//            System.out.println(dir);
//            System.out.println(size);
            for(int j=0;j<size;j++) {
                move(dir, y, x);
//                System.out.println("dot");
//                System.out.println(y + " " + x);
                y += Dy[dir];
                x += Dx[dir];
            }

            dir = (dir+1)%4;
        }

        System.out.println(ans);
    }

    private static void move(int d, int y, int x) {
        int ny = y + Dy[d];
        int nx = x + Dx[d];

        int sand = B[ny][nx];
        int sum = 0;
        int out = 0;
        for(int i=0;i<10;i++) {
            if(i == 9) {
                int ty = ny + tDy[d][i];
                int tx = nx + tDx[d][i];

                int a = sand-sum;
                if(ty < 0 || tx < 0 || ty >= N || tx >= N)
                    out += a;
                else
                    B[ty][tx] += a;

                B[ny][nx] = 0;
                break;
            }

            int m = sand * percent[i] / 100;
            int ty = ny + tDy[d][i];
            int tx = nx + tDx[d][i];

            if(ty < 0 || tx < 0 || ty >= N || tx >= N)
                out += m;
            else
                B[ty][tx] += m;
            sum += m;
        }

        ans += out;
    }

}
