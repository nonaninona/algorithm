import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] ans;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];
        dfs(0);
        System.out.println(builder);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i=0;i<M;i++)
                builder.append(ans[i]).append(" ");
            builder.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            ans[depth] = i+1;
            dfs(depth+1);
        }
    }
}