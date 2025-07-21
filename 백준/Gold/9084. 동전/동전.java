import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[] types;
    static int[] dp;
    static int minimum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            types = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                types[i] = Integer.parseInt(st.nextToken());
            }
            minimum = types[0];

            M = Integer.parseInt(br.readLine());

            dp = new int[10_001];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < M + 1; j++) {
                    if (j - types[i] >= 0) {
                        dp[j] += dp[j - types[i]];
                    }
                }
            }

            System.out.println(dp[M]);
        }


    }
}