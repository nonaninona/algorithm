import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] v;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        v = new boolean[N];
        dfs(0, 0);
        int ret = 0;

        for(int i=0;i<N;i++)
            if(v[i])
                ret++;
        System.out.println(ret-1);
    }

    private static void dfs(int n, int hop) {
//        System.out.println(n + " " + hop);
        if(hop == 3)
            return;

        v[n] = true;
        List<Integer> edges = graph.get(n);
        for(int i=0;i<edges.size();i++) {
            int edge = edges.get(i);
            dfs(edge, hop+1);
        }
    }
}