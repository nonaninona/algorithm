import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> graph;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            graph.get(e).add(s);
        }

        ans = new int[N];
        ans[0] = 1;
        for (int i = 1; i < N; i++) {
            List<Integer> edges = graph.get(i);

            int dist = 1;
            for (int e : edges) {
                dist = Math.max(dist, 1 + ans[e]);
            }
            ans[i] = dist;
        }

        for (int i = 0; i < N; i++)
            System.out.print(ans[i] + " ");
    }
}