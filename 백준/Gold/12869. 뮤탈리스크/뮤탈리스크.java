import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] health;
    static int ans;
    static int[][][] dp;
    static List<int[]> perms = new ArrayList<>();
    static int[] value = new int[]{9, 3, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[61][61][61];
        for (int i = 0; i < 61; i++)
            for (int j = 0; j < 61; j++)
                Arrays.fill(dp[i][j], -1);
        dp[0][0][0] = 0;

        health = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        health[3] = 0;
        getPerms();

        dfs(health[0], health[1], health[2]);

        System.out.println(dp[health[0]][health[1]][health[2]]);
    }

    private static int dfs(int h1, int h2, int h3) {
        if (dp[h1][h2][h3] != -1)
            return dp[h1][h2][h3];

        int ret = Integer.MAX_VALUE;
        for (int[] p : perms) {
//            System.out.println(Arrays.toString(p));
            int v1 = 0;
            int v2 = 0;
            int v3 = 0;
            if (N == 1) {
                v1 = value[p[0]];
                v2 = 0;
                v3 = 0;
            } else if (N == 2) {
                v1 = value[p[0]];
                v2 = value[p[1]];
                v3 = 0;
            } else if (N == 3) {
                v1 = value[p[0]];
                v2 = value[p[1]];
                v3 = value[p[2]];
            }

            ret = Math.min(ret, dfs(Math.max(0, h1 - v1), Math.max(0, h2 - v2), Math.max(0, h3 - v3)));
        }

        return dp[h1][h2][h3] = 1 + ret;
    }


    static boolean[] V;
    static int[] p;

    private static void getPerms() {
        V = new boolean[N];
        p = new int[N];
        perm(0);
    }

    //permutation 구하기
    private static void perm(int depth) {
        if (depth == N) {
            perms.add(Arrays.copyOf(p, N));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (V[i])
                continue;
            p[depth] = i;
            V[i] = true;
            perm(depth + 1);
            V[i] = false;
        }
    }

    private static boolean allDead(int[] health) {
        for (int i = 0; i < N; i++) {
            if (health[i] != 0)
                return false;
        }
        return true;
    }


}