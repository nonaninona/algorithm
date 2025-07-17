import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int[] nums;
    static List<Integer> tail;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        tail = new ArrayList<>();

        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        tail.add(nums[0]);
        for(int i=1;i<N;i++) {
            calc(i);
        }

        System.out.println(N - tail.size());
    }

    private static int calc(int i) {
        int num = nums[i];

        if(tail.get(tail.size()-1) < num) {
            tail.add(num);
            return tail.size();
        }

        int lo = -1;
        int hi = tail.size();
        while(lo + 1 < hi) {
            int mid = (lo+hi)/2;
            if(!(num <= tail.get(mid)))
                lo = mid;
            else
                hi = mid;
        }

        tail.set(hi, num);

        return hi+1;
    }
}