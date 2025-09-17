import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] U;
    static Set<Integer> S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        U = new int[N];
        for (int i = 0; i < N; i++)
            U[i] = Integer.parseInt(br.readLine());
        Arrays.sort(U);

        S = new HashSet<>();
        set();
        int ans = find();

        System.out.println(ans);
    }

    private static void set() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S.add(U[i] + U[j]);
            }
        }
    }

    private static int find() {
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (S.contains(U[i] - U[j])) return U[i];
            }
        }
        return -1;
    }


}
