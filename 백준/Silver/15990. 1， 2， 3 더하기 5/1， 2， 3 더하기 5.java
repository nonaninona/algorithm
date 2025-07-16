import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static int[][] dp = new int[4][100_001];
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());


        dp[1][1] = 1;
        dp[2][1] = 0;
        dp[3][1] = 0;

        dp[1][2] = 0;
        dp[2][2] = 1;
        dp[3][2] = 0;

        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            dp[1][i] = (dp[2][i-1] + dp[3][i-1])%MOD;
            dp[2][i] = (dp[1][i-2] + dp[3][i-2])%MOD;
            dp[3][i] = (dp[1][i-3] + dp[2][i-3])%MOD;
        }

        for (int i=0;i<T;i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println((((dp[1][num]+dp[2][num])%MOD) + dp[3][num])%MOD);
        }

    }
}