import java.util.*;
import java.io.*;

class Solution {

    static int T, N, S, ans;
    static List<Integer>[] G;
    static int[] V;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = 10;

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            G = new List[100];
            for(int i=0;i<100;i++)
                G[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N/2;i++) {
                int f = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken())-1;
//                System.out.println(f + " " + t);
                G[f].add(t);
            }


            V = new int[100];
            dfs(1, S-1);

            int maxV = Integer.MIN_VALUE;
            ans = Integer.MIN_VALUE;
            for(int i=0;i<100;i++) {
                if(V[i] == 0)
                    continue;
                if(V[i] > maxV) {
                    maxV = V[i];
                    ans = i+1;
                } else if(V[i] == maxV) {
                    ans = Math.max(ans, i+1);
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void dfs(int depth, int n) {
//        System.out.println(depth + " " + n);
        V[n] = depth;
        List<Integer> edges = G[n];
//        System.out.println(edges);
        for(int e : edges) {
            if(V[e] == 0 || depth+1 < V[e])
                dfs(depth+1, e);
        }
    }
}