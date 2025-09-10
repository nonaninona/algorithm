import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static Queue<Integer> Q;
    static List<Integer>[] G, RG;
    static boolean[] V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            G = new List[N];
            RG = new List[N];
            for(int i=0;i<N;i++) {
                G[i] = new ArrayList<>();
                RG[i] = new ArrayList<>();
            }
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                G[s].add(e);
                RG[e].add(s);
            }

            int ans = 0;
            for(int i=0;i<N;i++) {
                Q = new ArrayDeque<>();
                V = new boolean[N];

                Q.offer(i);
                V[i] = true;
                int ret1 = bfs(G);

                Q.offer(i);
                V = new boolean[N];
                V[i] = true;
                int ret2 = bfs(RG);

                if(ret1+ret2 == N-1)
                    ans++;
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static int bfs(List<Integer>[] graph) {
        int ret = 0;
        while(!Q.isEmpty()) {
            int idx = Q.poll();

            for(int e : graph[idx]) {
                if(!V[e]) {
                    Q.offer(e);
                    V[e] = true;
                    ret++;
                }
            }
        }
        return ret;
    }
}