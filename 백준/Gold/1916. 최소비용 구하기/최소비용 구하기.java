import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<List<Integer>>> bus = new ArrayList<>();
    static int[] dist;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            bus.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            bus.get(s - 1).add(List.of(d, e - 1));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<List<Integer>> q = new PriorityQueue<>(
                Comparator.comparingInt(list -> list.get(0))
        );
        q.offer(List.of(0, start));

        dist = new int[N];
        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        while (!q.isEmpty()) {
            List<Integer> node = q.poll();
            int baseD = node.get(0);
            int dest = node.get(1);

            if (dist[dest] < baseD)
                continue;

            List<List<Integer>> directions = bus.get(dest);
            for (List<Integer> nextNode : directions) {
                int nextD = nextNode.get(0);
                int nextDest = nextNode.get(1);

                if (baseD + nextD < dist[nextDest]) {
                    dist[nextDest] = baseD + nextD;
                    q.offer(List.of(dist[nextDest], nextDest));
                }
            }
        }

        System.out.println(dist[end]);
    }
}

