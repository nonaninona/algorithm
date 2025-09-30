import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] cnt;
    static int[] A;
    static int max;
    static Set<Integer> S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        max = Integer.MIN_VALUE;
        cnt = new int[1_000_001];
        S = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, A[i]);
            S.add(A[i]);
        }

        for(int a : A) {
            int num = a;
            num += a;
            while(num <= max) {
                if(S.contains(num)) {
                    cnt[a]++;
                    cnt[num]--;
                }
                num += a;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(cnt[A[i]]).append(" ");
        }
        System.out.println(sb);

    }
}