import java.util.*;
import java.io.*;

class Main {

    static int N, K, L;
    static int[] A;
    static int brokeCnt;
    static boolean[] R;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = 2 * N;

        A = new int[L];
        st = new StringTokenizer(br.readLine());
        brokeCnt = 0;
        for (int i = 0; i < L; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] == 0)
                brokeCnt++;
        }

        R = new boolean[L];

        int putPos = 0;
        int takePos = N - 1;

        int step = 1;
        while (true) {
            putPos = putPos - 1 >= 0 ? putPos - 1 : putPos - 1 + L;
            takePos = takePos - 1 >= 0 ? takePos - 1 : takePos - 1 + L;

//            while(it.hasNext()) {
//                r.offset++;
//
//            }

            if(R[takePos])
                R[takePos] = false;

            int idx = takePos-1 >= 0 ? takePos - 1 : takePos - 1 + L;
            for (int i = 0; i < N-1; i++) {
                if (R[idx] && !R[(idx + 1) % L] && A[(idx + 1) % L] > 0) {
                    R[(idx + 1) % L] = true;
                    R[idx] = false;
                    A[(idx + 1) % L]--;
                    if (A[(idx + 1) % L] == 0)
                        brokeCnt++;
                }

                idx = idx - 1 >= 0 ? idx - 1 : idx - 1 + L;
            }

            if(R[takePos])
                R[takePos] = false;

//                System.out.println("r.index " + r.index);

            if (!R[putPos] && A[putPos] > 0) {
                R[putPos] = true;
                A[putPos]--;
                if (A[putPos] == 0)
                    brokeCnt++;
            }

            if (brokeCnt >= K)
                break;

            step++;
        }
//            System.out.println("pos " + putPos + " " + takePos);
//            System.out.println("A " + Arrays.toString(A));
//            System.out.println("R " + Arrays.toString(R));
//            if(step == 31)
//                break;

        System.out.println(step);
    }

}