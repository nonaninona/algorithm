import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, X;
    static List<List<List<Integer>>> graph = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s-1).add(List.of(w, e-1));
        }

        int ret = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            int distance = dijkstra(i, X) + dijkstra(X, i);
            ret = Math.max(ret, distance);
        }

        System.out.println(ret);
    }

    static int[] dist;

    private static int dijkstra(int start, int end) {
        if(start == end)
            return 0;

        dist = new int[N];
        for(int i=0;i<N;i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<List<Integer>> q = new PriorityQueue<List<Integer>>(
                Comparator.comparingInt(list -> list.get(0))
        );
        q.offer(List.of(0, start));
        dist[start] = 0;

        while(!q.isEmpty()) {
            List<Integer> e = q.poll();
            int distance = e.get(0);
            int target = e.get(1);

            if(dist[target] < distance)
                continue;

            List<List<Integer>> edges = graph.get(target);
            for(List<Integer> edge : edges) {
                int nextDistance = edge.get(0);
                int nextTarget = edge.get(1);

                if(distance + nextDistance < dist[nextTarget]) {
                    dist[nextTarget] = distance + nextDistance;
                    q.offer(List.of(dist[nextTarget], nextTarget));
                }
            }
        }

        return dist[end];
    }

}

