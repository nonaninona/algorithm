import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();

        dp = new int[l1+1][l2+1];

        if(s1.charAt(0) == s2.charAt(0))
            dp[1][1] = 1;

        for(int i=1;i<l1+1;i++) {
            for(int j=1;j<l2+1;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < l1 + 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int i = s1.length();
        int j = s2.length();

        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--; j--;
            }
            else {
                if(dp[i-1][j] < dp[i][j-1])
                    j--;
                else
                    i--;
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(sb.reverse().toString());
    }
}