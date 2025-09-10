import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static boolean[][] G;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            G = new boolean[N][N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                G[s][e] = true;
            }
            for(int i=0;i<N;i++)
                G[i][i] = true;

            for(int k=0;k<N;k++) {
                for(int i=0;i<N;i++) {
                    for(int j=0;j<N;j++) {
                        if(G[i][k] && G[k][j])
                            G[i][j] = true;
                    }
                }
            }

            int ans = 0;
            for(int i=0;i<N;i++) {
                int count = 0;
                for(int j=0;j<N;j++) {
                    if(i==j) continue;
                    if(G[i][j] || G[j][i])
                        count++;
                }
                if(count == N-1)
                    ans++;
            }

            System.out.printf("#%d %d\n", tc, ans);
            }
    }
}