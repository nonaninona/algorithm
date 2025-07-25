import java.io.*;
import java.util.*;

public class Main {

    static int N, E;
    static int v1, v2;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> queue;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken())-1;
        v2 = Integer.parseInt(st.nextToken())-1;

        int ret1 = getRet1();
        int ret2 = getRet2();

        int ret = Math.min(ret1, ret2);
        if(ret == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ret);
    }

    private static int getRet2() {
        int ret2 = 0;
        dijkstra(0);
        if(dist[v2] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret2 += dist[v2];

        dijkstra(v2);
        if(dist[v1] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret2 += dist[v1];

        dijkstra(v1);
        if(dist[N-1] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret2 += dist[N-1];

        return ret2;
    }

    private static int getRet1() {
        int ret1 = 0;
        dijkstra(0);
        if(dist[v1] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret1 += dist[v1];

        dijkstra(v1);
        if(dist[v2] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret1 += dist[v2];

        dijkstra(v2);
        if(dist[N-1] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        ret1 += dist[N-1];

        return ret1;
    }

    private static void dijkstra(int start){
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));

        queue.offer(new int[]{start, 0});
        dist[start] = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int b = node[0];
            int c = node[1];

            if(dist[b] < c)
                continue;

            List<int[]> edges = graph.get(b);
            for(int[] edge : edges) {
                int nB = edge[0];
                int nC = edge[1];

                if(c + nC < dist[nB]) {
                    dist[nB] = c + nC;
                    queue.offer(new int[]{nB, dist[nB]});
                }
            }
        }
    }
}