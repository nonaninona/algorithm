import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] S;
    static int ans;
    static boolean[] selected;
    static int s, ns;
    static int[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());

            S = new int[N][N];
            StringTokenizer st;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selected = new boolean[N];
            B = new int[2];
            ans = Integer.MAX_VALUE;
            comb1(0, 0);

            System.out.printf("#%d %d\n", tc, ans);
        }



    }

    private static void comb1(int depth, int start) {
        if(depth == N/2) {
//            System.out.println(Arrays.toString(selected));
            ans = Math.min(ans, calc());
            return;
        }

        for(int i=start;i<N;i++) {
            selected[i] = true;
            comb1(depth+1, i+1);
            selected[i] = false;
        }
    }

    private static int calc() {
        s = 0;
        ns = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(selected[i] != selected[j])
                    continue;

                if(selected[i])
                    s += S[i][j];
                else
                    ns += S[i][j];
            }
        }
//        comb2(0, 0, true);
//        comb2(0, 0, false);

//        System.out.println(s + " " + ns);
        return Math.abs(s-ns);
    }

//    private static void comb2(int depth, int start, boolean isS) {
//        if (depth == 2) {
//            System.out.println(Arrays.toString(B));
//            if (isS)
//                s += S[B[0]][B[1]];
//            else
//                ns += S[B[0]][B[1]];
//            return;
//        }
//
//        for (int i = start; i < N; i++) {
//            if (selected[i] != isS)
//                continue;
//
//            B[depth] = i;
//            comb2(depth + 1, i + 1, isS);
//        }
//
//    }

}