import java.io.*;
import java.util.*;

class Main {

    static boolean[][] nums;
    static int N, K, P, X;
    static int ans;
    static String numStr;

    public static void main(String[] args) throws Exception {
        nums = new boolean[10][7];
        nums[0] = new boolean[] { true, true, true, false, true, true, true };
        nums[1] = new boolean[] { false, false, true, false, false, true, false };
        nums[2] = new boolean[] { true, false, true, true, true, false, true };
        nums[3] = new boolean[] { true, false, true, true, false, true, true };
        nums[4] = new boolean[] { false, true, true, true, false, true, false };
        nums[5] = new boolean[] { true, true, false, true, false, true, true };
        nums[6] = new boolean[] { true, true, false, true, true, true, true };
        nums[7] = new boolean[] { true, false, true, false, false, true, false };
        nums[8] = new boolean[] { true, true, true, true, true, true, true };
        nums[9] = new boolean[] { true, true, true, true, false, true, true };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        numStr = String.valueOf(X);
        numStr = "0".repeat(Math.max(0, K - numStr.length())) + numStr;
//        System.out.println(numStr);

        ans = 0;
        dfs(0, P, "");
        System.out.println(ans);
    }

    private static void dfs(int depth, int p, String numString) {
//        System.out.println(depth + " " + p + " " + numString);
        if(depth == K) {
            int num = Integer.parseInt(numString);
            if(num == X)
                return;
            if(1 <= num && num <= N)
                ans++;
            return;
        }

        int cur = numStr.charAt(depth)-'0';
        for(int i=0;i<=9;i++) {
            if(i == cur)
                continue;
            int diff = getDiff(i, cur);

            if(p >= diff)
                dfs(depth+1, p-diff, numString+i);
        }
        dfs(depth+1, p, numString+cur);
    }

    private static int getDiff(int num1, int num2) {
        int diff = 0;
        for(int i=0;i<7;i++) {
            if(nums[num1][i] != nums[num2][i])
                diff++;
        }
        return diff;
    }


}
