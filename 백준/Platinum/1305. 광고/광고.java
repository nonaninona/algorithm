import java.io.*;
import java.util.*;

public class Main {

    static int L;
    static String A;
    static int[] pi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        A = br.readLine();
        getPi();

        System.out.println(L - pi[L-1]);
    }

    private static void getPi() {
        pi = new int[L];
        int j = 0;
        for(int i = 1; i<L;i++) {

            while(j > 0 && A.charAt(i) != A.charAt(j)) {
                j = pi[j-1];
            }

            if(A.charAt(i) == A.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
    }
}