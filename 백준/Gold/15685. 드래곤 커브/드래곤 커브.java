import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] infos;
    static int[][] board = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        infos = new int[N][4];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++)
                infos[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            createDots(i);
//            printBoard();
        }

        int ret = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(board[i][j] == 1 && board[i][j+1] == 1 && board[i+1][j] == 1 && board[i+1][j+1] == 1)
                    ret++;
            }
        }

//        printBoard();
        System.out.println(ret);
    }

    private static void printBoard() {
        for(int i=0;i<=100;i++) {
            for(int j=0;j<=100;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void createDots(int idx) {
        int[] info = infos[idx];

        int[] initDot = new int[]{ info[1], info[0] };
//        System.out.println(Arrays.toString(initDot));
        List<int[]> dots = new ArrayList<>();
        dots.add(initDot);

        int d = info[2];
        for(int i=0;i<=info[3];i++) {
            curve(dots, d, i);
            d=(d+1)%4;
        }

        for(int[] dot : dots) {
            int y = dot[0];
            int x = dot[1];

            if(y < 0 || x < 0 || y > 100 || x > 100)
                throw new RuntimeException("에러");

            board[y][x] = 1;
        }
    }

    static int[] Dy = {0, -1, 0, 1};
    static int[] Dx = {1, 0, -1, 0};

    private static void curve(List<int[]> dots, int d, int g) {
        if(g == 0) {
            createInitDot(dots, d);
            return;
        }

        int[] lastDot = dots.get(dots.size()-1);
        int ly = lastDot[0];
        int lx = lastDot[1];
        int size = dots.size();
        for(int i=size-2;i>=0;i--) {
            int[] curDot = dots.get(i);
            int cury = curDot[0];
            int curx = curDot[1];

            int dy = cury-ly;
            int dx = curx-lx;

            int[] newDot = new int[] {ly + dx, lx - dy};
//            System.out.println(Arrays.toString(newDot));
            dots.add(newDot);
        }
    }

    private static void createInitDot(List<int[]> dots, int d) {
        int[] dot = new int[] { dots.get(0)[0]+Dy[d], dots.get(0)[1]+Dx[d] };
//        System.out.println(Arrays.toString(dot));
        if(dot[0] < 0 || dot[1] < 0 || dot[0] > 100 || dot[1] > 100)
            throw new RuntimeException("에러");
        dots.add(dot);
    }
}