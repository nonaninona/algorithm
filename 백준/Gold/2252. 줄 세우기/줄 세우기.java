import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegrees;
    static List<Integer>[] G;
    static Queue<Integer> Q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        G = new List[N];
        for(int i=0;i<N;i++)
            G[i] = new ArrayList<>();

        indegrees = new int[N];
        int s, e;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;

            G[s].add(e);
            indegrees[e]++;
        }

        Q = new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            if(indegrees[i] == 0)
                Q.offer(i);
        }

        while(!Q.isEmpty()) {
            int n = Q.poll();
//            System.out.println(n);
            sb.append(n+1).append(" ");

            List<Integer> edges = G[n];
            for(int edge : edges) {
                if(--indegrees[edge] == 0)
                    Q.offer(edge);
            }
        }

        System.out.println(sb);


    }
}
