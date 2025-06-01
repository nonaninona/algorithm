import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        long[] nums = new long[(int) N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long ret = 0;
        if (B > C) {
            for (int i = 0; i < N; i++) {
                while (nums[i] > 0) {
                    if(i+2 < N && nums[i+1] > nums[i+2]) {
                        long m = Math.min(nums[i+1]-nums[i+2], nums[i]);
                        nums[i] -= m;
                        nums[i+1] -= m;
                        ret += m * (B + C);
                    } else if(i+2 < N && nums[i] > 0 && nums[i+1] > 0 && nums[i+2] > 0) {
                        long temp = Math.min(nums[i], nums[i+1]);
                        long m = Math.min(temp, nums[i + 2]);
                        nums[i] -= m;
                        nums[i+1] -= m;
                        nums[i+2] -= m;
                        ret += m * (B + 2 * C);
                    } else if(i+1 < N && nums[i] > 0 && nums[i+1] > 0) {
                        long m = Math.min(nums[i], nums[i + 1]);
                        nums[i] -= m;
                        nums[i+1] -= m;
                        ret += m * (B + C);
                    } else {
                        ret += nums[i] * B;
                        nums[i] = 0;
                    }
                }
            }
        } else {
            for(int i=0;i<N;i++) {
                ret += nums[i];
            }
            ret *= B;
        }
        System.out.println(ret);
    }
}