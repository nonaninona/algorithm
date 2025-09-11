import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] A, dp;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        A = new int[N];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            dp[i] = A[i - 1] + dp[i - 1];

        ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right=0;right<N;right++) {
            sum += A[right];

            while(sum >= S) {
                ans = Math.min(ans, right - left + 1);

                sum -= A[left];
                left++;
            }
        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
