import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];
        dfs(0, 0);
    }

    private static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i=0;i<M;i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }

        for(int i=start;i<N;i++) {
            ans[depth] = i+1;
            dfs(depth+1, i+1);
        }
    }
}