import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static List<Integer> tails = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());

        tails.add(nums[0]);
        for(int i=1;i<N;i++) {
            calc(nums[i]);
//            System.out.println(tails);
        }

        System.out.println(tails.size());
    }

    private static void calc(int num) {
        if(tails.get(tails.size()-1) < num) {
            tails.add(num);
            return;
        }

        int lo = -1;
        int hi = tails.size();

        while(lo + 1 < hi) {
            int mid = (lo+hi)/2;
            if(!(num <= tails.get(mid)))
                lo = mid;
            else
                hi = mid;
        }

        tails.set(hi, num);
    }
}