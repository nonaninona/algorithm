import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] towers;
    static int[] ans;
    static ArrayDeque<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        towers = new int[N];
        for(int i=0;i<N;i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        ans = new int[N];
        ans[0] = 0;
        for(int i=1;i<N;i++) {
            int topIdx = stack.peek();

            if(towers[i] <= towers[topIdx]) {
                stack.push(i);
                ans[i] = topIdx+1;
                continue;
            }

            while(towers[topIdx] < towers[i]) {
                stack.pop();
                if(stack.isEmpty())
                    break;
                topIdx = stack.peek();
            }

            if(stack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = topIdx+1;
            stack.push(i);
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<N;i++) {
            builder.append(ans[i]).append(" ");
        }

        System.out.println(builder);
    }
}