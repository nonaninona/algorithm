import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<int[]> dots;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        dots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dots.add(new int[]{s, e});
        }


//        dots.sort(Comparator.naturalOrder());
//        Collections.sort(dots);
//        Collections.sort(dots, Comparator.reverseOrder());
//        dots.sort(Comparator.reverseOrder());
        dots.sort(Comparator.comparingInt((int[] d) -> d[0]).thenComparingInt(d -> d[1]));

        int start = dots.get(0)[0];
        int end = dots.get(0)[1];
        int ret = 0;
        for(int i=1;i<N;i++) {
            int s = dots.get(i)[0];
            int e = dots.get(i)[1];
//            System.out.println(start + " " + end + " " + s + " " + e);
            if(end < s) {
                ret += end-start;
                start = s;
                end = e;
                continue;
            }

            end = Math.max(end, e);
        }
        ret += end-start;

        System.out.println(ret);
    }
}