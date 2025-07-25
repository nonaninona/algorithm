import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static int[][] board;
    static boolean[][] visited;
    static int[] L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=0;k<Q;k++) {
            int l = L[k];
            int size = (int) Math.pow(2, l);
            for(int i=0;i<N;i+=size) {
                for(int j=0;j<N;j+=size) {
                    rotate(i, j, size);
                }
            }

//            for(int i=0;i<N;i++)
//                System.out.println(Arrays.toString(board[i]));

            int[][] newBoard = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    newBoard[i][j] = board[i][j];
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(isMelt(i, j) && board[i][j] > 0)
                        newBoard[i][j]--;
                }
            }

            board = newBoard;

//            System.out.println();
//            for(int i=0;i<N;i++)
//                System.out.println(Arrays.toString(board[i]));
        }



        int sum = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);


        int max = 0;
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    private static int dfs(int y, int x) {
        if(visited[y][x])
            return 0;

        if(board[y][x] == 0) {
            visited[y][x] = true;
            return 0;
        }

        int ret = 1;
        visited[y][x] = true;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;

            ret += dfs(ny, nx);
        }

        return ret;
    }

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    private static boolean isMelt(int y, int x) {
        int count = 0;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;

            if(board[ny][nx] > 0)
                count++;
        }
        return count < 3;
    }

    private static void rotate(int top, int left, int size) {
//        System.out.println("top left size " + top + " " + left + " " + size);
        int[][] newBoard = new int[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                newBoard[i][j] = board[top+i][left+j];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[top + j][left + (size - 1) - i] = newBoard[i][j];
            }
        }
    }
}