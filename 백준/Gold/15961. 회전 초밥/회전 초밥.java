import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c;
    static int[] A;
    static Map<Integer, Integer> M;
    static int ans, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        A = new int[N+k];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());
        for(int i=N;i<N+k;i++)
            A[i] = A[i-N];

        M = new HashMap<>();
        int left = 0;
        ans = Integer.MIN_VALUE;
        cnt = 0;
        for (int right = 0; right < N+k; right++) {
            if (right - left >= k) {
                int v = M.get(A[left]);
                M.put(A[left], v - 1);
                if (v == 1)
                    cnt--;
                left++;
            }

            Integer v = M.get(A[right]);
            if (v == null || v == 0) {
                M.put(A[right], 1);
                cnt++;
            } else {
                M.put(A[right], v + 1);
            }

//            System.out.println(M);
//            System.out.println(cnt);
            Integer coupon = M.get(c);
            ans = Math.max(ans, cnt + ((coupon == null || coupon == 0) ? 1 : 0));
        }

        System.out.println(ans);
    }
}
