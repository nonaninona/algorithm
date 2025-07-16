import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        dp = new int[N];

        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }


        int ret = 0;
        dp[0] = 1;
        for(int i=1;i<N;i++) {
            int length = 0;
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i])
                    length = Math.max(dp[j], length);
            }
            dp[i] = length+1;
            ret = Math.max(dp[i], ret);
        }

        System.out.println(N - ret);
    }
}