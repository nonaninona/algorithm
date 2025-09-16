import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, R;
    static int MOD = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            long ans = 1;
            for(int i=N;i>N-R;i--) {
                ans *= i;
                ans %= MOD;
            }

            for(int i=R;i>=1;i--) {
                ans *= inverse(i);
                ans %= MOD;
            }

            System.out.printf("#%d %d\n", tc, ans);

        }

    }

    private static long inverse(int a) {
        long result = 1;
        int p = MOD-2;
        long reduce = a;

        //exp를 이진수로 봤을 때,
        while(p > 0) {

            //맨 오른쪽 비트가 1이면 result에 포함
            if(p % 2 == 1) {
                result = (result * reduce) % MOD;
            }

            reduce = (reduce * reduce) % MOD;
            //오른쪽으로 shift
            p /= 2;
        }

        return result;
    }

}
