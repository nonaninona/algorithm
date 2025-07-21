import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dp;
    static String code;
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine().strip();

        dp = new int[code.length() + 1];
        if (code.charAt(0) != '0') {
            dp[0] = 1;
            dp[1] = 1;
        }
        for (int i = 2; i < code.length() + 1; i++) {
            if (code.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int v = Integer.parseInt(code.substring(i - 2, i));
            if (code.charAt(i - 2) != '0' && 1 <= v && v <= 26)
                dp[i] += dp[i - 2];
            dp[i] %= MOD;
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[code.length()]);
    }
}