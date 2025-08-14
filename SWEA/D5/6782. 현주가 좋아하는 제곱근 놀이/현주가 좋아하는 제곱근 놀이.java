import java.io.*;
import java.util.*;

public class Solution {

    static int T;
    static long N;
    static Queue<long[]> Q;
    static long[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        nums = new long[1000000];
        for(long i=1;i<=1000000;i++)
            nums[(int) i-1] = i*i;
        for (int tc = 1; tc <= T; tc++) {
            N = Long.parseLong(br.readLine());
            Q = new ArrayDeque<>();

            long ans = bfs();
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    public static long bfs() {
        if(N == 2)
            return 0;

        Q.offer(new long[]{N, 0});
        while (!Q.isEmpty()) {
            long[] node = Q.poll();
            long cnt = node[1];
//            System.out.println(node[0] + " " + node[1]);

            long nextN = biSearch(node[0]);
            long diff = nextN - node[0];
            if (nextN == 2) {
                return cnt + diff;
            } else {
                Q.offer(new long[]{nextN, cnt + diff});
            }

            double sqrt = Math.sqrt(node[0]);
            if(sqrt != (int) sqrt)
                continue;
            nextN = (int) sqrt;
            if(nextN == 2) {
                return cnt + 1;
            } else {
                Q.offer(new long[]{ nextN, cnt+1 });
            }
        }

        return -1;
    }

    private static long biSearch(long n) {

        int lo = -1;
        int hi = 1000000;
        while(lo + 1 < hi) {
//            System.out.println(lo + " " + hi);
            int mid = (lo+hi) / 2;
            // v[i-1] < k <= v[i]
            if(!(n <= nums[mid]))
                lo = mid;
            else
                hi = mid;
        }

        return nums[hi];
    }
}