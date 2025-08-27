import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[][] board;
    static int[][] gBoard;
    static Map<Integer, int[]>[] G;
    static int gNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfsGraph();
        setGraph();
        calc();

    }

    private static void dfsGraph() {
        V = new boolean[N][M];
        gBoard = new int[N][M];
        gNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!V[i][j] && board[i][j] == 1) {
                    V[i][j] = true;
                    gBoard[i][j] = gNum;
                    dfs(i, j, gNum++);
                }
            }
        }
        gNum--;

//        System.out.println("gBoard");
//        for(int i=0;i<N;i++) {
//            System.out.println(Arrays.toString(gBoard[i]));
//        }
//        System.out.println();
    }

    static PriorityQueue<int[]> PQ;

    private static void setGraph() {
        G = new Map[gNum+1];
        for (int i = 1; i <= gNum; i++) {
            G[i] = new HashMap<>();
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
//                System.out.println(i + " " + j + " " + gBoard[i][j]);
                if(gBoard[i][j] == 0)
                    continue;

                int s = gBoard[i][j];
//                System.out.println("s " + i + " " + j + " " + s);

                for(int k=0;k<4;k++) {
                    int ny = i, nx = j;
//                    System.out.println("k " + k);
                    int length = 0;
                    ny += Dy[k];
                    nx += Dx[k];
//                    System.out.println("init " + ny + " " + nx + " ");

                    while(!(ny < 0 || nx < 0 || ny >= N || nx >= M)) {
                        int e = gBoard[ny][nx];
//                        System.out.println("e " + ny + " " + nx + " " + e);
                        if(e != 0) {
                            if(e != s && length >= 2) {
                                int[] edge = G[s].get(e);
                                if(edge == null)
                                    G[s].put(e, new int[]{e, length});
                                else
                                    G[s].put(e, new int[]{e, Math.min(length, edge[1])});
                            }
                            break;
                        }

                        length++;
                        ny += Dy[k];
                        nx += Dx[k];
                    }
                }
            }
        }

//        for(int i=1;i<=gNum;i++) {
//            Map<Integer, int[]> g = G[i];
//            for(int key : g.keySet()) {
//                System.out.println(i + " " + Arrays.toString(g.get(key)));
//            }
//        }
    }

    private static void calc() {
        PQ = new PriorityQueue<>(Comparator.comparing((int[] l) -> l[2]));
        for(int i=1;i<=gNum;i++) {
            for(int key: G[i].keySet()) {
                int[] node = G[i].get(key);
                int[] n = new int[]{i, node[0], node[1]};
//                System.out.println(Arrays.toString(n));
                PQ.offer(n);
            }
        }

        parents = new int[gNum+1];
        for(int i=1;i<=gNum;i++)
            parents[i] = i;

        int mst = 0;
        while(!PQ.isEmpty()) {
            int[] node = PQ.poll();
            int s = node[0], e = node[1], w = node[2];

//            System.out.println(s + " " + e + " " + w);
//            System.out.println(find(s) + " " + find(e));

            if(find(s) != find(e)) {
                union(s, e);
                mst += w;
            }
        }

//        System.out.println(Arrays.toString(parents));
        int ans = mst;
        int p = parents[1];
        for(int i=2;i<=gNum;i++) {
            if(p != find(i)) {
                ans = -1;
                break;
            }
        }

        System.out.println(ans);
    }

    static int[] parents;

    private static int find(int x) {
        if(parents[x] == x)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if(aP == bP)
            return;

        if(aP < bP)
            parents[bP] = aP;
        else
            parents[aP] = bP;
    }

    private static void dfs(int y, int x, int gNum) {
        for(int i=0;i<4;i++) {
            int ny = y + Dy[i], nx = x + Dx[i];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(V[ny][nx])
                continue;
            if(board[ny][nx] != 1)
                continue;

            V[ny][nx] = true;
            gBoard[ny][nx] = gNum;
            dfs(ny, nx, gNum);
        }
    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, -1, 0, 1};
    static boolean[][] V;
}