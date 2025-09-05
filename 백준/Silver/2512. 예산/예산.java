import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] B; // budgets
    static int tB; //total budget
    static int maxB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        tB = Integer.parseInt(br.readLine());
        int total = 0;
        maxB = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            total += B[i];
            maxB = Math.max(maxB, B[i]);
        }
        if (total <= tB)
            System.out.println(maxB);
        else
            System.out.println(bSrc());
    }

    private static int bSrc() {
        int lo = 0;
        int hi = maxB + 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            int sum = calc(mid);
//            System.out.println("bSrc " + lo + " " + hi + " " + mid + " " + sum);
            if (!(sum <= tB)) // v[i-1] < k <= v[i]
                hi = mid;
            else
                lo = mid;
        }
        return lo;
    }

    private static int calc(int up) {
        int ret = 0;
        for (int i = 0; i < N; i++)
            ret += Math.min(up, B[i]);
        return ret;
    }

}