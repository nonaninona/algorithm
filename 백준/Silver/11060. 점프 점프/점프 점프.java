import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            int a = A[i];
            int maxIdx = Math.min(N, i+a+1);
            for (int j = i+1; j < maxIdx; j++) {
                if (dp[j] == Integer.MAX_VALUE && dp[i] == Integer.MAX_VALUE)
                    dp[j] = Integer.MAX_VALUE;
                else
                    dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        if (dp[N-1] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[N-1]);
    }
}