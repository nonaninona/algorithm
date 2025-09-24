import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] A, dp;
    static Set<Integer> S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        for(int i=1;i<=N;i++)
            dp[i] = dp[i-1] + A[i-1];

        S = new HashSet<>();

        // 0 2 0 2 0
        // dp[i] - dp[j] = K;
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        map.put(0, 1); // dp[0] = 0, 1개.

        for(int i=1; i<=N; i++) {
            // 현재 dp[i]에 대해, 파트너 dp[j]를 찾는다.
            // 파트너의 값은 dp[i] - K
            int target = dp[i] - K;

            // 이전에 target 값이 몇 번이나 나왔는지 센다.
            ans += map.getOrDefault(target, 0);

            // 현재 dp[i] 값을 미래를 위해 기록한다.
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }

        System.out.println(ans);
    }


}
