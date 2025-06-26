import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int C;
    static List<Integer> houses = new ArrayList();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++)
            houses.add(Integer.parseInt(br.readLine()));

        houses = houses.stream().sorted().collect(Collectors.toList());

        int lo = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++)
            lo = Math.min(lo, houses.get(i + 1) - houses.get(i));
        int hi = 1_000_000_000;

        while(lo + 1 < hi) {
//            System.out.println("lo = " + lo);
//            System.out.println("hi = " + hi);
            int mid = (lo+hi)/2;
//            System.out.println("mid = " + mid);
            if(check(mid))
                lo = mid;
            else
                hi = mid;
        }

        if(check(hi))
            System.out.println(hi);
        else
            System.out.println(lo);
    }

    private static boolean check(int mid) {
        int prev = houses.get(0);
        int count = 1;
        for(int i=1;i<N;i++) {
            if(houses.get(i) - prev >= mid) {
                count++;
                prev = houses.get(i);
            }
        }

//        System.out.println(count >= C);
        return count >= C;
    }
}