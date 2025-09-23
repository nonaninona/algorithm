import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int s, e;
    static List<int[]>[] G;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;

        G = new List[N];
        for (int i = 0; i < N; i++)
            G[i] = new ArrayList<>();

        int h1, h2, k;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            h1 = Integer.parseInt(st.nextToken()) - 1;
            h2 = Integer.parseInt(st.nextToken()) - 1;
            k = Integer.parseInt(st.nextToken());

            G[h1].add(new int[]{h2, k});
            G[h2].add(new int[]{h1, k});
        }

        int lo = 0;
        int hi = 1_000_001;
        while(lo+1 < hi) {
            int mid = (lo+hi)/2;
//            System.out.println(lo + " " + hi + " " + mid);
            if(canGo(mid))
                lo = mid;
            else
                hi = mid;
//            System.out.println("hi");
        }

        System.out.println(lo);
    }

    static Queue<Integer> Q;
    static boolean[] V;

    private static boolean canGo(int mid) {
        Q = new ArrayDeque<>();
        V = new boolean[N];
        Q.offer(s);
        V[s] = true;
        while(!Q.isEmpty()) {
            int n = Q.poll();
//            System.out.println(n);

            List<int[]> edges = G[n];
            for(int[] edge : edges) {
                int t = edge[0];
                int w = edge[1];

                if(V[t] || w < mid)
                    continue;

                V[t] = true;
                Q.offer(t);
            }
        }
        return V[e];
    }

}
