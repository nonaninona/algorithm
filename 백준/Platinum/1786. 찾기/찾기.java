import java.io.*;
import java.util.*;

public class Main {

    static String T, P;
    static int[] pi;
    static List<Integer> ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();

        getPi();
        getAns();

        sb.append(ans.size()).append("\n");
        for(int a : ans) {
            sb.append(a+1).append(" ");
        }
        System.out.println(sb);
    }

    private static void getAns() {
        ans = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < T.length(); i++) {

            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    ans.add(i - P.length() + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    private static void getPi() {
        pi = new int[P.length()];

        int j = 0;
        for (int i = 1; i < P.length(); i++) {

            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (P.charAt(i) == P.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }

//        System.out.println(Arrays.toString(pi));

    }
}