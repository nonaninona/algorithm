import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[] oils;;
    static PriorityQueue<int[]> Q;
    static List<int[]>[] G;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        oils = new int[N];
        for(int i=0;i<N;i++)
            oils[i] = Integer.parseInt(st.nextToken());

        G = new List[N];
        for(int i=0;i<N;i++)
            G[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            G[s].add(new int[] { e, w });
            G[e].add(new int[] { s, w });
        }

        Q = new PriorityQueue<>(Comparator.comparingInt((int[] l) -> l[1]));
        Q.offer(new int[] { 0, 0, oils[0] });
        D = new int[N][2500];
        for(int i=0;i<N;i++) {
            for(int j=0;j<2500;j++)
                D[i][j] = Integer.MAX_VALUE;
        }
        D[0][oils[0]] = 0;

        while(!Q.isEmpty()) {
            int[] node = Q.poll();
//            System.out.println(Arrays.toString(node));
            int n = node[0];
            int d = node[1];
            int o = node[2];

            if(D[n][o] < d)
                continue;

            List<int[]> edges = G[n];
            for(int[] edge : edges) {
                int nN = edge[0];
                int nD = edge[1];
                int nO = Math.min(o, oils[nN]);

                if(d + nD * o < D[nN][nO]) {
                    D[nN][nO] = d + nD * o;
                    Q.offer(new int[] { nN, D[nN][nO], nO });
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
            min = Math.min(min, oils[i]);
        System.out.println(D[N-1][min]);
    }
}