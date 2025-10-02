import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] W;
    static Set<Integer>[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        S = new Set[N+1];
        for(int i=0;i<N+1;i++)
            S[i] = new HashSet<>();

        dfs(0, 0);

//        for(int i=0;i<N+1;i++) {
//            System.out.println(S[i]);
//        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int query = Integer.parseInt(st.nextToken());
            if(S[N].contains(query))
                sb.append("Y");
            else
                sb.append("N");
            sb.append(" ");
        }

        System.out.println(sb);

    }

    private static void dfs(int pos, int weight) {
        if(weight + 500 * (N-pos) < 0 || weight - 500 * (N-pos) > 40_000)
            return;

        if(S[pos].contains(weight))
            return;

        S[pos].add(weight);

        if(pos == N)
            return;

        dfs(pos+1, weight);
        dfs(pos+1, weight+W[pos]);
        dfs(pos+1, weight-W[pos]);
    }
}