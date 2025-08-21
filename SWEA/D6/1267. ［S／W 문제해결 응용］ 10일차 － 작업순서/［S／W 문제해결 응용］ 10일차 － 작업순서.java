import java.io.*;
import java.util.*;

class Solution {

    static int V, E;
    static List<Integer>[] G;
    static int[] indegrees;
    static Queue<Integer> Q;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder builder;

        for(int tc = 1;tc<=10;tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            G = new List[V];
            for (int i = 0; i < V; i++)
                G[i] = new ArrayList<>();

            indegrees = new int[V];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;

                G[s].add(e);
                indegrees[e]++;
            }

            Q = new ArrayDeque<>();
            for (int i = 0; i < V; i++)
                if (indegrees[i] == 0)
                    Q.offer(i);

            ans = new int[V];
            int idx = 0;
            while (!Q.isEmpty()) {
                int n = Q.poll();
                ans[idx] = n + 1;
                idx++;
                List<Integer> edges = G[n];
                for (int e : edges) {
                    indegrees[e]--;
                    if (indegrees[e] == 0)
                        Q.offer(e);
                }
            }

            builder = new StringBuilder();
            for(int i=0;i<idx;i++)
                builder.append(ans[i]).append(" ");
            System.out.printf("#%d %s\n", tc, builder);
        }
    }
}