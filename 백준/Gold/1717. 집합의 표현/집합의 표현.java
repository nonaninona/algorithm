import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;

    private static int find(int x) {

        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if(aP == bP)
            return;

        if(aP < bP)
            parent[bP] = aP;
        else
            parent[aP] = bP;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<N+1;i++) {
            parent[i] = i;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(k==0) {
                union(a, b);
            } else if(k==1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}