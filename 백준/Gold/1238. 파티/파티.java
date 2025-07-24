import java.io.*;
import java.util.*;

public class Main {

    static int[] dist;
    static int[] distX;
    static int N, M, X;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        graph = new ArrayList<>();
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] {v, w});
        }

        queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));
        queue.offer(new int[]{X, 0});
        distX = new int[N];
        Arrays.fill(distX, Integer.MAX_VALUE);
        distX[X] = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int v = node[0];
            int w = node[1];

            if(distX[v] < w)
                continue;

            List<int[]> edges = graph.get(v);
            for(int[] edge: edges) {
                int nV = edge[0];
                int nW = edge[1];

                if(w + nW < distX[nV]) {
                    distX[nV] = w + nW;
                    queue.offer(new int[]{nV, distX[nV]});
                }
            }
        }


        int ret = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            if(i==X)
                continue;
            queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));
            queue.offer(new int[]{i, 0});
            dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                int v = node[0];
                int w = node[1];

                if(dist[v] < w)
                    continue;

                List<int[]> edges = graph.get(v);
                for(int[] edge: edges) {
                    int nV = edge[0];
                    int nW = edge[1];

                    if(w + nW < dist[nV]) {
                        dist[nV] = w + nW;
                        queue.offer(new int[]{nV, dist[nV]});
                    }
                }
            }

//            System.out.println(Arrays.toString(dist));
            ret = Math.max(ret, dist[X]+distX[i]);
        }

        System.out.println(ret);
    }
}