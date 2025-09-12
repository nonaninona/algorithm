import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] dp1, dp2;
    static Map<Integer, Integer> m1, m2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        dp1 = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            dp1[i] = dp1[i - 1] + Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        dp2 = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            dp2[i] = dp2[i - 1] + Integer.parseInt(st.nextToken());

        m1 = new HashMap<>();
        m2 = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                int k = dp1[i] - dp1[j];
                int v = m1.computeIfAbsent(k, l -> 0);
                m1.put(k, v + 1);
            }
        }

        long ans = 0;
        for (int i = 1; i < M + 1; i++) {
            for (int j = 0; j < i; j++) {
                int k = dp2[i] - dp2[j];
                ans += (long) m1.getOrDefault(T - k, 0);
            }
        }

        System.out.println(ans);
    }

}
