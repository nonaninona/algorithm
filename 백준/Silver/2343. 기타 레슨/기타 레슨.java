import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> nums = new ArrayList();
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums.add(Integer.parseInt(st.nextToken()));

        int lo = nums.stream().mapToInt(n->n).max().orElse(0);
        int hi = 1_000_000_000;

        while(lo + 1 < hi) {
//            System.out.println("lo = " + lo);
//            System.out.println("hi = " + hi);

            int mid = (lo+hi) / 2;
            boolean possible = check(mid);

//            System.out.println("mid = " + mid);
//            System.out.println("possible = " + possible);

            if(possible)
                hi = mid;
            else
                lo = mid;
        }

        if(check(lo))
            System.out.println(lo);
        else
            System.out.println(hi);
    }

    private static boolean check(int mid) {
        int sum = 0;
        int count = 1;
        for(int n: nums) {
            if(sum+n > mid) {
                count++;
                sum = n;
                continue;
            }
            sum += n;
        }
        return count <= M;
    }
}

