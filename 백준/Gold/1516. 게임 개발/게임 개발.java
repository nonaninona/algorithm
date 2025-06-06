import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N = -1;
    static int[] times = null;
    static List<List<Integer>> dependency = new ArrayList<>();
    static int[] dp = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            List<Integer> dependent = new ArrayList<>();
            while(st.hasMoreTokens()) {
                int d = Integer.parseInt(st.nextToken());
                if(d == -1)
                    break;
                dependent.add(d-1);
            }
            dependency.add(dependent);
        }

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < N; i++) {
            dp[i] = calcTime(i);
        }

        for (int i = 0; i <N; i++) {
            System.out.println(dp[i]);
        }
    }

    private static int calcTime(int i) {
        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int max = 0;
        for(int d : dependency.get(i)) {
            max = Math.max(max, calcTime(d));
        }

        return dp[i] = max + times[i];
    }
}

