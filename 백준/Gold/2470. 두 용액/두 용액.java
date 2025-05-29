import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        nums.sort((a, b) -> a-b);

        int left = 0;
        int right = N-1;
        int minLeft = 0;
        int minRight = 0;
        int min = 2100000000;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                minRight = right;
                minLeft = left;
            }

            if(sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }


        System.out.println(nums.get(minLeft) + " " + nums.get(minRight));
    }
}