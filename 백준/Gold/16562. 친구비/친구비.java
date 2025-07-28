import java.io.*;
import java.util.*;

public class Main {

    static int N, M, k;
    static int[] A;
    static int[] parents;
    static int[] min;
    static Set<Integer> set;

    private static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if(aP == bP)
            return;

        if(aP < bP) {
            parents[bP] = aP;
            min[aP] = Math.min(min[aP], min[bP]);
        }
        else {
            parents[aP] = bP;
            min[bP] = Math.min(min[aP], min[bP]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        min = Arrays.copyOf(A, N);
        parents = new int[N];
        for(int i=0;i<N;i++)
            parents[i] = i;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            union(a,b);
        }
//        System.out.println(Arrays.toString(parents));

        set = new HashSet<>();
        for(int i=0;i<N;i++) {
            set.add(find(i));
        }
//        System.out.println(set);

        int ret = 0;
        for(int num : set) {
            ret += min[find(num)];
        }
//        System.out.println(Arrays.toString(min));

        if(ret <= k)
            System.out.println(ret);
        else
            System.out.println("Oh no");
    }
}