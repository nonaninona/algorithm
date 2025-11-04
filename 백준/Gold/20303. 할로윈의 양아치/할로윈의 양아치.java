import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Integer>[] G;
    static boolean[] V;
    static int[] C;
    static List<int[]> L;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        G = new List[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        C = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            G[u].add(v);
            G[v].add(u);
        }

        V = new boolean[N];
        L = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (V[i])
                continue;
            int[] c = dfs(i);
            L.add(c);
        }


//        for(int[] c : L)
//            System.out.println(Arrays.toString(c));

        dp = new int[L.size()+1][K+1];
        for (int i = 0; i < L.size(); i++) {
            for (int j = 1; j < K; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);

                int w = L.get(i)[1];
                int v = L.get(i)[0];
                if (j - w >= 0)
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j - w] + v);
            }
        }

//        for (int i = 0; i < L.size() + 1; i++)
//            System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[L.size()][K-1]);


    }

    static int[] dfs(int n) {
        V[n] = true;
        int ret = C[n];
        int cnt = 1;
        List<Integer> edges = G[n];
        for (int e : edges) {
            if (V[e])
                continue;
            int[] c = dfs(e);
            ret += c[0];
            cnt += c[1];
        }

        return new int[]{ret, cnt};
    }
}