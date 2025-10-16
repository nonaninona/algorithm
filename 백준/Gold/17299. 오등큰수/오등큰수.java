import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] A;
    static int[] ans;
    static int[] C;
    static Deque<Integer> S;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        ans = new int[N];
        C = new int[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            C[A[i]]++;
        }

        S = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
//            System.out.println(S);

            if (S.isEmpty()) {
                S.offerLast(A[i]);
                ans[i] = -1;
                continue;
            }

            while (!S.isEmpty() && C[A[i]] >= C[S.peekLast()]) {
                S.pollLast();
            }

            if (S.isEmpty())
                ans[i] = -1;
            else
                ans[i] = S.peekLast();
            S.offerLast(A[i]);
        }

        sb = new StringBuilder();
        for(int a : ans)
            sb.append(a).append(" ");
        System.out.println(sb);
    }
}