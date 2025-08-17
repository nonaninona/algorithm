import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int i=0;i<N;i++)
            arr[i] = Long.parseLong(br.readLine());

        tree = new long[4*N];
        init(0, N-1, 1);

        for(int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                update(0, N-1, 1, b-1, c - arr[b-1]);
                arr[b-1] = c;
            } else if(a == 2) {
                System.out.println(query(0, N-1, 1, b-1, (int) c-1));
            }
        }
    }

    private static long init(int s, int e, int n) {
        if(s == e) return tree[n] = arr[s];
        int mid = (s+e)/2;
        return tree[n] = init(s, mid, n*2) + init(mid+1, e, n*2+1);
    }

    private static long query(int s, int e, int n, int l, int r) {
        if(e < l || r < s) return 0;
        if(l <= s && e <= r) return tree[n];
        int mid = (s + e)/2;
        return query(s, mid, n*2, l, r) + query(mid+1, e, n*2+1, l, r);
    }

    private static void update(int s, int e, int n, int t, long diff) {
        if(e < t || t < s) return;
        tree[n] += diff;
        if(s == e) return;
        int mid = (s + e) /2;
        update(s, mid, n*2, t, diff);
        update(mid+1, e, n*2+1, t, diff);
    }

}