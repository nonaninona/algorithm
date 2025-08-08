import java.io.*;
import java.util.*;

public class Solution {

    static int TC, N, L;
    static int[] T, K;
    static int R, ret;
    static int[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TC = Integer.parseInt(br.readLine());

        for(int tc=1;tc<TC+1;tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            T = new int[N];
            K = new int[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            ret = 0;
            B = new int[N];
            for(R=1;R<N+1;R++) 
                comb(0, 0);

            System.out.printf("#%d %d\n", tc, ret);
        }

    }

    private static void comb(int depth, int start) {
        if(depth == R) {
//            System.out.println(Arrays.toString(B));
            int v = 0, c = 0;
            for(int i=0;i<R;i++) {
                v += T[B[i]];
                c += K[B[i]];
            }
            if(c <= L)
                ret = Math.max(ret, v);
//            System.out.println(v + " " + c);
            return;
        }

        for(int i=start;i<N;i++) {
            B[depth] = i;
            comb(depth+1, i+1);
        }
    }


}