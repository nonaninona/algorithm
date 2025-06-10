import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i < N+1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int idx = T[i-1] + i - 1;
            if(idx <= N)
                dp[idx] = Math.max(dp[idx], P[i-1] + dp[i-1]);
        }

        System.out.println(dp[N]);
    }
}

