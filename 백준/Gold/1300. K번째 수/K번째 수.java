import java.io.*;
import java.util.*;

public class Main {

    static int N, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int lo = 0;
        int hi = 1_000_000_000;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
//            System.out.println(lo + " " + hi + " " + mid);
            if (check(mid))
                hi = mid;
            else
                lo = mid;
        }

        System.out.println(hi);
    }

    public static boolean check(int num) {
        int count = 0;
        for (int i = 1; i <= Math.min(num, N); i++)
            count += Math.min(N, num/i);
//        System.out.println(count);
        return k <= count;
    }
}
