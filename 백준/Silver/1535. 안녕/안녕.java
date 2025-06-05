import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 완탐 아닌가 싶긴 함
public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        int[] J = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][101];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            int l = L[i];
            int j = J[i];

            dp[i][100 - l] = Math.max(dp[i][100 - l], j);
            for (int k = 100; k >= 0; k--) {
                if (i - 1 < 0)
                    continue;
                if (dp[i - 1][k] == -1)
                    continue;
                if (k - l >= 0)
                    dp[i][k - l] = Math.max(dp[i][k - l], dp[i - 1][k] + j);
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][k]);
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        int ret = 0;
        for (int i = 1; i < 101; i++) {
            ret = Math.max(ret, dp[N-1][i]);
        }

        System.out.println(ret);
    }
}
