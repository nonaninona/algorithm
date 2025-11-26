import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[] P;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        P = new int[M];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            int num = 0;
            for(int j=0;j<count;j++) {
                int q = Integer.parseInt(st.nextToken()) - 1;
                num = num | (1 << q);
            }

            P[i] = num;
        }

        ans = 100;
        dfs(0, 0, 0);
        if(ans == 100)
            ans = -1;
        System.out.println(ans);

    }

    private static void dfs(int depth, int state, int cnt) {
        if(ans <= cnt)
            return;

        if(depth == M) {
            if(state == (1 << N) - 1)
                ans = Math.min(ans, cnt);
            return;
        }

        dfs(depth+1, state, cnt);
        dfs(depth+1, state | P[depth], cnt+1);
    }

}
