import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static boolean[] isOk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isOk = new boolean[10];
        Arrays.fill(isOk, true);

        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx;
            for (int i = 0; i < M; i++) {
                idx = Integer.parseInt(st.nextToken());
                isOk[idx] = false;
            }
        }

//        System.out.println(Arrays.toString(isOk));

        int min = Integer.MAX_VALUE;
        for (int n = 0; n < 1_000_000; n++) {
            if (canMake(n)) {
//                System.out.println(n);
                int diff = Math.abs(n - N);
                min = Math.min(min, String.valueOf(n).length() + diff);
            }
        }

        int diff = Math.abs(100 - N);
        min = Math.min(min, diff);

        System.out.println(min);
    }

    private static boolean canMake(int n) {
        String str = String.valueOf(n);
            for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (!isOk[c - '0'])
                return false;
        }
        return true;
    }


}
