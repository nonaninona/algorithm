import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;

    public static int find(int x) {
        if(parent[x] == x)
            return parent[x];
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
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

        parent = new int[N];
        for(int i=0;i<N;i++)
            parent[i] = i;

        int ret = 0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)) {
                ret = i+1;
                break;
            }
            else
                union(a, b);
        }

        System.out.println(ret);
    }
}