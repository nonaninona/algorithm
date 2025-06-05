import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] costs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = costs[0];
        for (int i = 1; i < N; i++) {
            int min = costs[i];
            for (int j = 0; j < (i+1) / 2; j++) {
                min = Math.min(min, dp[j] + dp[i-1-j]);
            }
            dp[i] = min;
        }
        
        System.out.println(dp[N-1]);
    }
}