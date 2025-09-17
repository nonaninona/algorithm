import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        K = Integer.parseInt(row[1]);

        long ans = 1;
        for(int i=N;i>N-K;i--) {
            ans *= i;
            ans %= MOD;
        }

        for(int i=2;i<=K;i++) {
            ans *= inverse(i);
            ans %= MOD;
        }
        System.out.println(ans);
    }

    private static long inverse(int num) {
//        System.out.println("num " + num);

        long result = 1;
        int exp = MOD-2;
        long a = num;
        while(exp > 0) {
//            System.out.println("exp " + exp);
//            System.out.println("result " + result);
//            System.out.println("a " + a);
            if(exp % 2 == 1) {
                result = (result * a) % MOD;
            }

            a = a*a % MOD;
            exp /= 2;
        }

        return result;
    }
}
