import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<Integer, Integer>[] G;
    static int s, e;
    static Queue<Integer> Q;
    static boolean[] V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        G = new Map[N];
        for (int i = 0; i < N; i++) {
            G[i] = new HashMap<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            int v = G[A].computeIfAbsent(B, k -> Integer.MIN_VALUE);
            G[A].put(B, Math.max(v, C));
            v = G[B].computeIfAbsent(A, k -> Integer.MIN_VALUE);
            G[B].put(A, Math.max(v, C));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;


        int lo = 0;
        int hi = 1_000_000_001;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
//            System.out.println("bSrc");
//            System.out.println(lo + " " + hi + " " + mid);
            if (bfs(mid))
                lo = mid;
            else
                hi = mid;
        }

        System.out.println(lo);

    }

    private static boolean bfs(int mid) {
        Q = new ArrayDeque<>();
        V = new boolean[N];

        Q.offer(s);
        V[s] = true;
        while (!Q.isEmpty()) {
            int n = Q.poll();

            Map<Integer, Integer> edges = G[n];
            for (int k : edges.keySet()) {
                if (!V[k] && edges.get(k) >= mid) {
                    Q.offer(k);
                    V[k] = true;
                }
            }
        }
//        System.out.println(V[e]);

        return V[e];
    }

}
