import java.io.*;
import java.util.*;

public class Main {

    static String T, P;
    static int[] pi;
    static List<Integer> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();

        getPi();
        getAns();

        System.out.println(ans.size());
        for(int a : ans) {
            System.out.print((a+1) + " ");
        }
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