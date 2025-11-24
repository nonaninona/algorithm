import java.util.*;
import java.io.*;

public class Main {

    static class Cell {
        public Cell(int id, int d) {
            this.id = id;
            this.dir = d;
        }
        int id; //0 - 상어
        int dir; //북, 북서, 서, ... 반시계 45도
    }

    static class Pair {
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
        int y;
        int x;
    }

    static Cell[][] B;
    static Map<Integer, Pair> P;
    static int[] Dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] Dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static String[] dirs = { "↑", "↖", "←", "↙", "↓", "↘", "→", "↗"};

    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        B = new Cell[4][4];
        P = new HashMap<>();

        StringTokenizer st;
        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                B[i][j] = new Cell(a, b-1);
                P.put(a, new Pair(i, j));
            }
        }

        ans = 0;

        int sum = B[0][0].id;
        P.remove(B[0][0].id);
        P.put(0, new Pair(0, 0));
        B[0][0].id = 0;

        dfs(B, P, sum);

        System.out.println(ans);
    }

    private static void dfs(Cell[][] board, Map<Integer, Pair> pos, int sum) {
//        System.out.println("dfs " + sum);

        printBoard(board);
        for(int i=1;i<=16;i++) {
            Pair p = pos.get(i);
            if(p == null)
                continue;

            int y = p.y;
            int x = p.x;
            int d = board[y][x].dir;

            for(int j=0;j<8;j++) {
                int ny = y + Dy[(d+j)%8];
                int nx = x + Dx[(d+j)%8];
                if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
                    continue;
                if(board[ny][nx] != null && board[ny][nx].id == 0)
                    continue;

                pos.put(board[y][x].id, new Pair(ny, nx));
                Cell t = board[ny][nx];
                if(t != null)
                    pos.put(t.id, new Pair(y, x));

                board[y][x].dir = (d+j)%8;

                board[ny][nx] = board[y][x];
                board[y][x] = t;

                break;
            }

        }

        printBoard(board);

        Pair s = pos.get(0);
        int sy = s.y;
        int sx = s.x;
        int sd = board[sy][sx].dir;

        int sny = sy;
        int snx = sx;

        boolean isEnd = true;

        while(true) {
            sny += Dy[sd];
            snx += Dx[sd];

            if(sny < 0 || snx < 0 || sny >= 4 || snx >= 4)
                break;
            if(board[sny][snx] == null)
                continue;

            isEnd = false;

            //copy state
            Cell[][] newBoard = new Cell[4][4];
            for(int i=0;i<4;i++) {
                for (int j = 0; j < 4; j++) {
                    if(board[i][j] != null)
                        newBoard[i][j] = new Cell(board[i][j].id, board[i][j].dir);
                    else
                        newBoard[i][j] = null;
                }
            }
            Map<Integer, Pair> newPos = new HashMap<>();
            for(Map.Entry<Integer, Pair> e : pos.entrySet())
                newPos.put(e.getKey(), new Pair(e.getValue().y, e.getValue().x));

            //eat
            int tid = board[sny][snx].id;
            int newSum = sum + tid;
            newPos.remove(tid);

            //change
            newPos.put(0, new Pair(sny, snx));
            newBoard[sny][snx].id = 0;
            newBoard[sy][sx] = null;

            dfs(newBoard, newPos, newSum);
        }
        if(isEnd)
            ans = Math.max(ans, sum);
    }

    private static void printBoard(Cell[][] board) {
//        for(int i=0;i<4;i++) {
//            for(int j=0;j<4;j++) {
//                if(board[i][j] == null)
//                    System.out.print(" ".repeat(4));
//                else
//                    System.out.print(board[i][j].id + "/" + dirs[board[i][j].dir] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}