import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static List<int[]>[] G;
    static PriorityQueue<int[]> PQ;
    static boolean[] V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        G = new List[N];
        for (int i = 0; i < N; i++)
            G[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            G[A].add(new int[]{B, C});
            G[B].add(new int[]{A, C});
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        V = new boolean[N];
        PQ = new PriorityQueue<>(Comparator.comparing((int[] l) -> l[1]));
        PQ.offer(new int[]{0, 0});
        while (!PQ.isEmpty()) {
            int[] n = PQ.poll();
            int dest = n[0];
            int dist = n[1];

//            System.out.println(dest + " " + dist);

            if (V[dest]) {
                continue;
            }
//            System.out.println(dest);
            sum += dist;
            max = Math.max(max, dist);

            for (int[] edge : G[dest]) {
                int nDest = edge[0];
                int nDist = edge[1];
//                System.out.println(nDest + " " + nDist);

                if (!V[nDest]) {
                    PQ.offer(new int[]{nDest, nDist});
                }
            }

            V[dest] = true;
        }

//        System.out.println(sum + " " + max);
        System.out.println(sum - max);


    }


}
