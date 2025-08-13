import java.io.*;
import java.util.*;

public class Solution {

    static int ret;
    static int T, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            int[] W;
            boolean[] V;

            N = Integer.parseInt(br.readLine());
            W = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
                W[i] = Integer.parseInt(st.nextToken());
            V = new boolean[N];

            ret = 0;
            perm(0, 0, 0, W, V);

            System.out.printf("#%d %d\n", tc, ret);
        }
    }

    private static void perm(int depth, int left, int right, int[] W, boolean[] V) {
//        System.out.println(depth);
        if(depth == N) {
            ret++;
            return;
        }

        for(int i=0;i<N;i++) {
            if(V[i]) continue;

            V[i] = true;
            perm(depth+1, left+W[i], right, W, V);

            if(left >= right + W[i]) {
                perm(depth+1, left, right+W[i], W, V);
            }
            V[i] = false;
        }
    }
}
