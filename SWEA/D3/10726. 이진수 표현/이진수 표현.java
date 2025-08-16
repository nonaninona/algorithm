import java.io.*;
import java.util.*;

public class Solution {

    static int T;
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int target = (1 << N) - 1;
//            System.out.println(Integer.toBinaryString(target));
            boolean check = (M & target) == target;

            if(check)
                System.out.printf("#%d ON\n", tc);
            else
                System.out.printf("#%d OFF\n", tc);
        }
    }
}