import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] indegrees;
    static PriorityQueue<Integer> PQ;
    static List<Integer>[] G;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegrees = new int[N];
        PQ = new PriorityQueue<>();
        G = new List[N];
        for(int i=0;i<N;i++)
            G[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;

            G[A].add(B);
            indegrees[B]++;
        }

        for(int i=0;i<N;i++)
            if(indegrees[i] == 0)
                PQ.offer(i);

        while(!PQ.isEmpty()) {
            int num = PQ.poll();
            sb.append(num+1).append(" ");

            for(int e : G[num]) {
                if(--indegrees[e] == 0) {
                    PQ.offer(e);
                }
            }
        }

        System.out.println(sb);

    }
}