import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static List<Integer>[] G;
    static boolean[] V;
    static boolean ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = new List[N];
        for(int i=0;i<N;i++)
            G[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
            G[b].add(a);
        }

        V = new boolean[N];
        ans = false;
        for(int i=0;i<N;i++) {
            if(ans) break;
            V[i] = true;
            dfs(i, 0);
            V[i] = false;
        }

        System.out.println(ans ? 1 : 0);

    }

    private static void dfs(int n, int d) {
        if(ans)
            return;

        List<Integer> edges = G[n];
        for(int e : edges) {
            if(ans) return;
            if(V[e]) continue;

            if(d+1 == 4) {
                ans = true;
                return;
            }

            V[e] = true;
            dfs(e, d+1);
            V[e] = false;
        }
    }

}
