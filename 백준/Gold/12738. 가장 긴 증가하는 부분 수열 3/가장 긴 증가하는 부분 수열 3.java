import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> A = new ArrayList<>();
    static List<Integer> dp = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A.add(Integer.parseInt(st.nextToken()));

        int ret = 0;
        for(int i=0;i<N;i++) {
            int num = A.get(i);
            int pos = check(num);
            dp.add(pos);
            ret = Math.max(ret, pos);
        }

        System.out.println(ret);
    }

    private static int check(int num) {
//        System.out.println("num = " + num);
//        System.out.println("list = " + list);

        if(list.isEmpty()) {
            list.add(num);
            return 1;
        }

        int lastIdx = list.size()-1;
        if(list.get(lastIdx) < num) {
            list.add(num);
            return list.size();
        }

        int lo = -1;
        int hi = list.size();

        while(lo + 1 < hi) {
            int mid = (lo+hi)/2;
//            System.out.println("lo = " + lo);
//            System.out.println("hi = " + hi);
//            System.out.println("mid = " + mid);
            int n = list.get(mid);
//            System.out.println("n = " + n);
            if(num <= n)
                hi = mid;
            else
                lo = mid;
        }

        list.set(hi, num);
        return hi+1;
    }
}

