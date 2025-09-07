import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] values;
    static int ans, vans1, vans2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        values = new int[N];
        for (int i = 0; i < N; i++)
            values[i] = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            int v1 = values[i];
            int v2 = bSrc(i);

//            System.out.println(v1 + " " + v2);

            if(Math.abs(v1 + v2) < ans) {
                ans = Math.abs(v1 + v2);
                if(v1 < v2) {
                    vans1 = v1;
                    vans2 = v2;
                } else {
                    vans1 = v2;
                    vans2 = v1;
                }
            }
        }

        System.out.printf("%d %d", vans1, vans2);
    }

    private static int bSrc(int idx) {
        int v = values[idx];

        int lo = -1;
        int hi = N;

        while(lo + 1 < hi) {
            int mid = (lo+hi)/2;
            if(-v <= values[mid])
                hi = mid;
            else
                lo = mid;
        }

        if(lo == idx)
            lo -= 1;
        if(hi == idx)
            hi += 1;

        if(lo <= -1)
            return values[hi];
        if(hi >= N)
            return values[lo];

        if(Math.abs(v + values[hi]) < Math.abs(v + values[lo]))
            return values[hi];
        else
            return values[lo];
    }
}