import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static final int NONE = -2;
    static int score;
    static int[][] board;
    static int sty, stx, rbCnt;
    static boolean[][] visited;
    static boolean[][] totalVisited;
    static PriorityQueue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        score = 0;
        while(true) {
            queue = new PriorityQueue<>(Comparator.comparing((int[] l) -> -l[0]).thenComparing((int[] l) -> -l[1]).thenComparing((int[] l) -> -l[2]).thenComparing((int[] l) -> -l[3]));
//            System.out.println("findMaxGroup");
            findMaxGroup();
//            printQueue();
            if (queue.isEmpty())
                break;

//            System.out.println("deleteBlock");
            deleteBlock(queue.poll());
//            printBoard();

//            System.out.println("setGravity");
            setGravity();
//            printBoard();

//            System.out.println("rotate");
            rotate();
//            printBoard();

//            System.out.println("setGravity");
            setGravity();
//            printBoard();

//            System.out.println(score);
        }

        System.out.println(score);
    }

    private static void printBoard() {
        System.out.println("board");
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++)
                System.out.printf("%2d ", board[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    private static void printQueue() {
        PriorityQueue<int[]> newQueue = new PriorityQueue<>(Comparator.comparing((int[] l) -> -l[0]).thenComparing((int[] l) -> -l[1]).thenComparing((int[] l) -> -l[2]).thenComparing((int[] l) -> -l[3]));

        System.out.println("queue");
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            newQueue.offer(node);
            System.out.println(Arrays.toString(node));
        }
        System.out.println();

        queue = newQueue;
    }

    private static void rotate() {
        int[][] newBoard = new int[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                newBoard[N-1-j][i] = board[i][j];
        board = newBoard;
    }

    private static void setGravity() {
        for(int j=0;j<N;j++) {
            for(int i=N-2;i>=0;i--) {
                if(board[i][j] >= 0) {
                    int next = i;
                    while(board[next+1][j] == NONE) {
                        next++;
                        if(next + 1 > N-1)
                            break;
                    }
                    if(next != i) {
                        board[next][j] = board[i][j];
                        board[i][j] = NONE;
                    }
                }
            }
        }
    }

    private static void deleteBlock(int[] node) {
        int y = node[2];
        int x = node[3];

        visited = new boolean[N][N];
        deleteDfs(y, x, board[y][x]);
        score += node[0] * node[0];
    }

    private static void deleteDfs(int y, int x, int c) {
        visited[y][x] = true;
        if(board[y][x] == c || board[y][x] == 0)
            board[y][x] = NONE;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;
            if(visited[ny][nx])
                continue;
            if(board[ny][nx] == c || board[ny][nx] == 0)
                deleteDfs(ny, nx, c);
        }
    }

    private static void findMaxGroup() {
        totalVisited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!totalVisited[i][j] && board[i][j] > 0) {
                    visited = new boolean[N][N];
                    sty = i;
                    stx = j;
                    rbCnt = 0;
                    int a = dfs(i, j, board[i][j]);
                    accVisited();
                    if(a >= 2)
                        queue.offer(new int[] { a, rbCnt, sty, stx });
                }
            }
        }
    }

    private static void accVisited() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(board[i][j] != -1 || board[i][j] != 0)
                    totalVisited[i][j] |= visited[i][j];
            }
        }

    }

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};
    private static int dfs(int y, int x, int c) {
        int ret = 1;
        visited[y][x] = true;
        setStandard(y, x, c);
        if(board[y][x] == 0)
            rbCnt++;
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i];
            int nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;
            if(visited[ny][nx])
                continue;

            if(board[ny][nx] == c || board[ny][nx] == 0)
                ret += dfs(ny, nx, c);
        }

        return ret;
    }

    private static void setStandard(int y, int x, int c) {
        if(board[y][x] == c) {
            if(y < sty) {
                sty = y;
            } else if(y == sty) {
                stx = Math.min(stx, x);
            }
        }
    }
}