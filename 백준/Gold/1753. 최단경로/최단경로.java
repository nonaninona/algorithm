import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        List<List<List<Integer>>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            g.get(s).add(List.of(e, w));
            ;

        }

        // priority queue => 의미가 있는 정점을 넣는 것
        // queue에서 꺼내서 주변 노드 확인해서 그 노드 통해서 도달 거리가 더 가까우면 갱신 + 큐에 넣기
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        int[] d = new int[V];
        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[K] = 0;

        q.add(new int[]{d[K], K});

        while(!q.isEmpty()) {
            int[] tuple = q.poll();
            int dist = tuple[0];
            int n = tuple[1];

            if(d[n] < dist)
                continue;

            for(List<Integer> t : g.get(n)) {
                int e = t.get(0);
                int w = t.get(1);

                if(d[e] <= w+dist)
                    continue;

                d[e] = w+dist;
                q.add(new int[]{w+dist, e});
            }
        }

        for (int i = 0; i < V; i++) {
            if(d[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }
}