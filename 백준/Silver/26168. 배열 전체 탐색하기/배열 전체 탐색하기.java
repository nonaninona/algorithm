import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<Long> nums = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        nums = Arrays.stream(br.readLine().strip().split(" "))
                .mapToLong(Long::parseLong).boxed()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long method = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if(method == 1) {
                System.out.println(findEqualAndOver(k));
            } else if(method == 2) {
                System.out.println(findOver(k));
            } else {
                long j = Long.parseLong(st.nextToken());
                System.out.println(findEqualAndOver(k) - findOver(j));
            }
        }
    }

    private static long findEqualAndOver(long k) {
        int l = -1;
        int r = nums.size();

        while (l+1<r) {
            int mid = (l + r) / 2;
            if(!(k <= nums.get(mid))) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums.size() - r;
    }


    private static long findOver(long k) {
        int l = -1;
        int r = nums.size();

        while (l+1<r) {
            int mid = (l + r) / 2;
            if(!(k < nums.get(mid))) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums.size() - r;
    }
}