import java.io.*;
import java.util.*;

class Main {

    static int M;
    static int[] N, S;
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = new int[M];
        S = new int[M];

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            N[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        long ret = 0;
        for(int i=0;i<M;i++) {
            ret += S[i] * calc(N[i]);
            ret %= MOD;
        }

        System.out.println(ret);
    }

    private static long calc(int num) {
        long ret = 1;
        long square = num;
        long a = MOD-2;
        while(a > 0) {
            if(a%2 == 1) {
                ret *= square;
                ret %= MOD;
            }
            a = a >> 1;
            square *= square;
            square %= MOD;
        }
//        System.out.println(num);
//        System.out.println(ret);

        return ret;
    }
}