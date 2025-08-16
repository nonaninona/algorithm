import java.io.*;
import java.util.*;

public class Solution {

    static int T;
    static long N;
    static int check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            N = Long.parseLong(br.readLine());

            check = 0;
            int cnt = 1;
            long originN = N;
            while(true) {
                check();
//                System.out.println(Integer.toBinaryString(check));
//                System.out.println(N);
                if(isEnd())
                    break;
                N += originN;
                cnt++;
            }

            System.out.printf("#%d %d\n", tc, N);

        }



    }

    private static void check() {
        long newN = N;
        while(newN > 0) {
            long r = newN % 10;
            newN /= 10;
            check |= (1 << r);
        }
    }

    private static boolean isEnd() {
        return (check & ((1 << 10) - 1)) == ((1 << 10) - 1);
    }
}