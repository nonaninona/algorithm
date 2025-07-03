import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int E;
    static List<List<List<Integer>>> graph = new ArrayList<>();
    static int v1, v2;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a - 1).add(List.of(c, b - 1));
            graph.get(b - 1).add(List.of(c, a - 1));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()) - 1;
        v2 = Integer.parseInt(st.nextToken()) - 1;

//        System.out.println(graph);
//        System.out.println(v1 + " " + v2);


        int[] firstRoute = {0, v1, v2, N - 1};
        int[] secondRoute = {0, v2, v1, N - 1};

        int first = calc(firstRoute);
        int second = calc(secondRoute);

        if (first == -1 || second == -1)
            System.out.println(-1);
        else
            System.out.println(Math.min(first, second));
    }

    static int[] dist;

    private static int calc(int[] route) {
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            int distance = dijkstra(route[i], route[i + 1]);
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }
            ret += distance;
        }
        return ret;
    }

    private static int dijkstra(int start, int end) {
        dist = new int[N];
        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<List<Integer>> q = new PriorityQueue<>(
                Comparator.comparingInt(list -> list.get(0))
        );

        q.offer(List.of(0, start));
        dist[start] = 0;

        while (!q.isEmpty()) {
            List<Integer> node = q.poll();
            int distance = node.get(0);
            int target = node.get(1);

            if (dist[target] < distance)
                continue;

            List<List<Integer>> edges = graph.get(target);
            for (List<Integer> edge : edges) {
                int nextDistance = edge.get(0);
                int nextTarget = edge.get(1);

                if (distance + nextDistance < dist[nextTarget]) {
                    dist[nextTarget] = distance + nextDistance;
                    q.offer(List.of(dist[nextTarget], nextTarget));
                }
            }
        }

        return dist[end];
    }

}

