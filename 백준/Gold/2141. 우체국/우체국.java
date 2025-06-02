import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Long>> V = new ArrayList<>();
    static List<Long> dp = new ArrayList<>();
    static int N = -1;

    private static long binarySearch() {
        int left = -1;
        int right = V.size();

        long target = dp.get(dp.size()-1);
        if(target % 2 == 1)
            target = (target + 1) / 2;
        else
            target = target/2;

        while(left + 1 < right) {
            int mid = (left+right)/2;
            long cost = dp.get(mid+1);
            if(!(target <= cost))
                left = mid;
            else
                right = mid;
        }

        return V.get(right).get(0);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            V.add(List.of(x, a));
        }
        V.sort((a,b) -> (int) (a.get(0) - b.get(0)));

        dp.add(0L);
        for (int i = 0; i < N; i++) {
            dp.add(V.get(i).get(1) + dp.get(i));
        }

        System.out.println(binarySearch());
    }
}