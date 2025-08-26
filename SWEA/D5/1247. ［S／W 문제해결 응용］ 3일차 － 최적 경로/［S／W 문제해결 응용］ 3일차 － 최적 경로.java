import java.util.*;
import java.io.*;

class Solution {

    static int T, N;
    static int sy, sx, ey, ex;
    static int[][] clients;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            clients = new int[N][2];
            for(int i=0;i<N;i++) {
                clients[i][1] = Integer.parseInt(st.nextToken());
                clients[i][0] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N][1<<N];
            for(int i=0;i<N;i++)
                Arrays.fill(dp[i], -1);

            int ans = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                int dist = getDist(clients[i][0], clients[i][1], sy, sx);
                ans = Math.min(ans, dist + dfs(1 << i, i));
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    static int[][] dp;

    public static int dfs(int visited, int cur) {
        // 지금까지 이렇게 방문했고, 지금 어디고, 앞으로 어딜 방문할 거임
        // 순열을 줄일 수 있음

        if(dp[cur][visited] != -1)
            return dp[cur][visited];

        boolean isLast = true;

        int ret = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            if((visited & (1 << i)) == 0) {
                int dist = getDist(clients[cur][0], clients[cur][1], clients[i][0], clients[i][1]);
                ret = Math.min(ret, dfs(visited | (1 << i), i) + dist);
                isLast = false;
            }
        }

        if(isLast)
            return dp[cur][visited] = getDist(clients[cur][0], clients[cur][1], ey, ex);

        return dp[cur][visited] = ret;
    }

    private static int getDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}