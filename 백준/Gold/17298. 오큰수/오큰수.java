import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] ans;
    static Deque<Integer> stack;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ans = new int[N];
        stack = new ArrayDeque<>();
        ans[N - 1] = -1;
        stack.push(A[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            Integer top = stack.peek();
            if (A[i] < top) {
                ans[i] = top;
                stack.push(A[i]);
                continue;
            }

            while (A[i] >= top) {
                stack.pop();

                if (stack.isEmpty())
                    break;
                top = stack.peek();
            }

            if (!stack.isEmpty())
                ans[i] = top;
            else
                ans[i] = -1;

            stack.push(A[i]);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(ans[i]).append(" ");
        }
        System.out.println(builder);
    }
}