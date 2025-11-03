import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            //right
            double maxGrad = -1_000_000_001;
            for (int j = i + 1; j < N; j++) {
                double curGrad = (double) (A[j] - A[i]) / (j - i);
//                System.out.println(maxGrad + " " + curGrad);
                if (maxGrad < curGrad) {
                    maxGrad = curGrad;
                    cnt++;
                }
            }
//            System.out.println(cnt);

            //left
            double minGrad = 1_000_000_001;
            for (int j = i - 1; j >= 0; j--) {
                double curGrad = (double) (A[i] - A[j]) / (i - j);
                if (minGrad > curGrad) {
                    minGrad = curGrad;
                    cnt++;
                }
            }
//            System.out.println(cnt);

//            System.out.println(i + " : " + cnt);
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }
}