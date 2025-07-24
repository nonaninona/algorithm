import java.io.*;
import java.util.*;

public class Main {

    static int[] dist;
    static int V, E, K;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList<>();
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u-1).add(new int[] {v-1, w});
        }

        dist = new int[V];
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));
        queue.offer(new int[]{K, 0});
        dist[K] = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int v = node[0];
            int w = node[1];

            if(dist[v] < w)
                continue;

            List<int[]> edges = graph.get(v);
            for(int[] edge : edges) {
                int nV = edge[0];
                int nW = edge[1];

                if (w + nW < dist[nV]) {
                    dist[nV] = w + nW;
                    queue.offer(new int[]{nV, dist[nV]});
                }
            }
        }

        for(int i=0;i<V;i++) {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

}