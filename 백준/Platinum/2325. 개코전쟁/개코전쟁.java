import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> queue;
    static int[] dist;
    static int[] path;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new int[]{y, z});
            graph.get(y).add(new int[]{x, z});
        }


        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        path = new int[N];
        Arrays.fill(path, -1);

        queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));

        queue.offer(new int[]{0, 0});
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int z = node[1];

            if (dist[y] < z)
                continue;

            List<int[]> edges = graph.get(y);
            for (int[] edge : edges) {
                int nY = edge[0];
                int nZ = edge[1];

                if (z + nZ < dist[nY]) {
                    dist[nY] = z + nZ;
                    path[nY] = y;
                    queue.offer(new int[]{nY, dist[nY]});
                }
            }
        }
//        System.out.println(Arrays.toString(path));

        int ret = 0;
        int idx = N-1;
        while(path[idx] != -1) {
            dijkstra(path[idx], idx);
            ret = Math.max(ret, dist[N - 1]);
//            System.out.println(idx + " " + ret);
//            System.out.println(Arrays.toString(dist));

            idx = path[idx];
        }

        System.out.println(ret);
    }

    private static void dijkstra(int s, int e) {
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));
        queue.offer(new int[]{0, 0});
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int z = node[1];

            if (dist[y] < z)
                continue;

            List<int[]> edges = graph.get(y);
            for (int[] edge : edges) {
                int nY = edge[0];
                int nZ = edge[1];
                if (y == s && nY == e) {
//                    System.out.println(" " + y + " " + nY);
                    continue;
                }

                if (z + nZ < dist[nY]) {
                    dist[nY] = z + nZ;
                    queue.offer(new int[]{nY, dist[nY]});
                }
            }
        }
    }
}