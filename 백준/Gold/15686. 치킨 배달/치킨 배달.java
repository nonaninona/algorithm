import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static List<int[]> chicken;
    static int[] targets;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        board = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        targets = new int[M];
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int start) {
        if(depth == M) {
//            System.out.println(Arrays.toString(targets));
            ans = Math.min(ans, calcDist());
            return;
        }

        for(int i=start;i<chicken.size();i++) {
            targets[depth] = i;
            dfs(depth+1, i+1);
        }
    }

    private static int calcDist() {
        int ret = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(board[i][j] == 1) {
                    int dist = Integer.MAX_VALUE;

                    for(int k=0;k<M;k++) {
                        int[] t = chicken.get(targets[k]);
                        int d = Math.abs(t[0] - i) + Math.abs(t[1] - j);
                        dist = Math.min(dist, d);
                    }

                    ret += dist;
                }
            }
        }
        return ret;
    }
}