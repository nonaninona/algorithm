import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] nums = null;
    static int[] dp = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i < N+1; i++) {
            int prev = dp[nums[i]-1]+1;
            dp[nums[i]] = prev;
            max = Math.max(max, prev);
        }

        int ret = N - max;
        System.out.println(ret);
    }
}