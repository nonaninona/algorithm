import java.io.*;
import java.util.*;

public class Main {	static int N;
    static ArrayDeque<int[]> stack;
    static int[] H;
    static int[] ansCount;
    static int[] ansDist;
    static int[] ansIdx;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException, Exception {
//        System.setIn(new FileInputStream("Test5.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        H = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            H[i] = Integer.parseInt(st.nextToken());

        ansCount = new int[N];
        ansDist = new int[N];
        ansIdx = new int[N];
        Arrays.fill(ansDist, Integer.MAX_VALUE);

        stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            solve(i);
        stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--)
            solve(i);

        for (int i = 0; i < N; i++) {
            if (ansCount[i] == 0)
                builder.append(0);
            else
                builder.append(ansCount[i]).append(" ").append(ansIdx[i]);
            builder.append("\n");
        }

        System.out.println(builder);
    }

    private static void solve(int i) {
        if (stack.isEmpty()) {
            stack.push(new int[] { i, H[i] });
            return;
        }

        int[] top = stack.peek();

        while (H[i] >= top[1]) {
            int[] node = stack.pop();

            if (stack.isEmpty())
                break;

            top = stack.peek();
        }

        if (stack.isEmpty()) {
            stack.push(new int[] { i, H[i] });
            return;
        }

        ansCount[i] += stack.size();
        int d = Math.abs(i - top[0]);
        if (d < ansDist[i]) {
            ansDist[i] = d;
            ansIdx[i] = top[0] + 1;
        } else if (d == ansDist[i]) {
            ansIdx[i] = Math.min(ansIdx[i], top[0] + 1);
        }

        stack.push(new int[] { i, H[i] });
    }

}