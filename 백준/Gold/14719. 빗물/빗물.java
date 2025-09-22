import java.io.*;
import java.util.*;

class Main {

    static int H, W;
    static int[] A;
    static Deque<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[W];
        for(int i=0;i<W;i++)
            A[i] = Integer.parseInt(st.nextToken());

        stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < W; i++) {
            int curH = A[i];

            if(stack.isEmpty()) {
//                System.out.println("offer " + i);
                stack.offerLast(i);
                continue;
            }

            int lastIdx = stack.peekLast();
            if(curH <= A[lastIdx]) {
                stack.offerLast(i);
//                System.out.println("offer " + i);
                continue;
            }

            int botIdx = lastIdx;
            while(A[botIdx] < curH) {
                botIdx = stack.pollLast();
//                System.out.println("poll " + botIdx);
                int botH = A[botIdx];

                if(stack.isEmpty())
                    break;

                int leftIdx = stack.peekLast();
                int leftH = A[leftIdx];

                ans += (i - leftIdx - 1) * (Math.min(leftH, curH) - botH);

                botIdx = leftIdx;

            }
            stack.offerLast(i);
        }
        System.out.println(ans);
    }


}
