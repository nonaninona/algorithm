import java.io.*;
import java.util.*;

class Main {

    static List<Long> ans;
    static int N, K;
    static Set<Integer> C;
    static String num = "9876543210";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ans = new ArrayList<>();
        C = new HashSet<>();
        for(int i=0;i<10;i++) {
            K = i;
            comb(0, 0);
        }

        ans.sort(Comparator.naturalOrder());
//        System.out.println(ans);

        if(ans.size() < N+1)
            System.out.println(-1);
        else
            System.out.println(ans.get(N));

    }

    private static void comb(int depth, int start) {
        if(depth == K) {
            addNum();
            return;
        }

        for(int i=start;i<10;i++) {
            C.add(i);
            comb(depth+1, i+1);
            C.remove(i);
        }
    }

    private static void addNum() {
        StringBuilder ret = new StringBuilder();
        for(int i=0;i<num.length();i++) {
            if(C.contains(i))
                continue;
            ret.append(num.charAt(i));
        }

        ans.add(Long.parseLong(ret.toString()));
    }
}
