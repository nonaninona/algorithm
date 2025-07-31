import java.io.*;
import java.util.*;

public class Main {

    static int N, M, d;
    static int[][] board;
    static boolean[][] isCleaned;
    static int curY, curX;
    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        curY = Integer.parseInt(st.nextToken());
        curX = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isCleaned = new boolean[N][M];
        int ret = 0;
        while (true) {
            if(!isCleaned[curY][curX]) {
                isCleaned[curY][curX] = true;
                ret++;
            }

            if(checkAround(curY, curX)) {
                if(checkGoBack(curY, curX)) {
                    curY += Dy[(d+2)%4];
                    curX += Dx[(d+2)%4];
                    continue;
                } else {
                    break;
                }
            }

            if(!checkAround(curY, curX)) {
                rotate();
                if(checkFront(curY, curX)) {
                    curY += Dy[d];
                    curX += Dx[d];
                }
            }
        }

        System.out.println(ret);
    }

    private static void rotate() {
        d--;
        if(d < 0)
            d += 4;
    }

    private static boolean checkFront(int curY, int curX) {
        int nY = curY + Dy[d];
        int nX = curX + Dx[d];

        if(nY < 0 || nX < 0 || nY >= N || nX >= M)
            return false;

        return board[nY][nX] == 0 && !isCleaned[nY][nX];
    }

    private static boolean checkGoBack(int curY, int curX) {
        int nY = curY + Dy[(d+2)%4];
        int nX = curX + Dx[(d+2)%4];

        if(nY < 0 || nX < 0 || nY >= N || nX >= M)
            return false;

        return board[nY][nX] == 0;
    }

    private static boolean checkAround(int curY, int curX) {
        for(int i=0;i<4;i++) {
            int nY = curY + Dy[i];
            int nX = curX + Dx[i];

            if(nY < 0 || nX < 0 || nY >= N || nX >= M)
                continue;

            if(board[nY][nX] == 0 && !isCleaned[nY][nX])
                return false;
        }
        return true;
    }
}