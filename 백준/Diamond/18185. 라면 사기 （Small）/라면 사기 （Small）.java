import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int i = 0; i < N; i++) {
            while(nums[i] > 0) {
                if(i+2 < N && nums[i+1] > nums[i+2]) {
                    int temp = nums[i+1] - nums[i+2];
                    int min = Math.min(nums[i], temp);
                    nums[i] -= min;
                    nums[i+1] -= min;
                    ret += 5*min;
                }
                else if (i+2 < N && nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0) {
                    int a = Math.min(nums[i], nums[i+1]);
                    int min = Math.min(a, nums[i+2]);
                    nums[i]-=min;
                    nums[i + 1]-=min;
                    nums[i + 2]-=min;
                    ret += 7*min;
                } else if (i+1 < N && nums[i] > 0 && nums[i+1] > 0) {
                    int min = Math.min(nums[i], nums[i+1]);
                    nums[i] -= min;
                    nums[i+1] -= min;
                    ret += 5*min;
                } else {
                    ret += 3 * nums[i];
                    nums[i] = 0;
                }
            }
        }
        System.out.println(ret);

    }
}