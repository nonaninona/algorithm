import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        nums.sort((a, b) -> a - b);
        int max = 0;
        double ret = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            ret += (double) num / 2;
        }
        ret += (double) max / 2;

        if(ret == (int) ret)
            System.out.println((int) ret);
        else
            System.out.println(ret);
    }
}