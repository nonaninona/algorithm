import java.util.*;
import java.io.*;

class Main {

    static int N, M, K;
    static List<int[]>[] G;
    static PriorityQueue<long[]> PQ;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        G = new List[N + 1];
        for (int i = 0; i <= N; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            G[e].add(new int[]{s, c});
        }

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PQ = new PriorityQueue<>(Comparator.comparing((long[] l) -> l[1]));
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) {
            int k = Integer.parseInt(st.nextToken());
            PQ.offer(new long[] { k, 0 });
            dist[k] = 0;
        }

        while(!PQ.isEmpty()) {
            long[] node = PQ.poll();
            long e = node[0];
            long d = node[1];

//            System.out.println(e + " " + d);

            if(dist[(int)e] < d)
                continue;

            List<int[]> edges = G[(int)e];
            for(int[] edge : edges) {
                int nE = edge[0];
                int nD = edge[1];

                if(d + nD < dist[nE]) {
                    dist[nE] = d + nD;
                    PQ.offer(new long[]{nE, dist[nE]});
                }
            }
        }

//        System.out.println(Arrays.toString(dist));

        long max = Long.MIN_VALUE;
        int ans = -1;
        for(int i=1;i<=N;i++) {
            if(dist[i] != Long.MAX_VALUE && dist[i] > max) {
                max = dist[i];
                ans = i;
            }
        }

        System.out.println(ans);
        System.out.println(max);
    }
}