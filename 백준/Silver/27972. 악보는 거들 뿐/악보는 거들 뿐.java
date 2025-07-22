import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        nums = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int upStreak = 1;
        int downStreak = 1;
        int ret = 1;

        for(int i=1;i<M;i++) {
            int d = nums[i] - nums[i-1];
            if(d > 0) {
                upStreak++;
                downStreak = 1;
            } else if(d < 0) {
                upStreak = 1;
                downStreak++;
            }

            ret = Math.max(ret, upStreak);
            ret = Math.max(ret, downStreak);
        }

        System.out.println(ret);
    }
}