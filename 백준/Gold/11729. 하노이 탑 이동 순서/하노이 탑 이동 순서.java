import java.util.*;
import java.io.*;

class Main {

    static int N, ans;
    static StringBuilder builder = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ans = 0;
        dfs(N, 1, 3, 2);
        System.out.println(ans);
        System.out.print(builder);
    }

    private static void dfs(int n, int from, int to, int via) {
        if(n == 1) {
            builder.append(from).append(" ").append(to).append('\n');
            ans++;
            return;
        }

        dfs(n-1, from, via, to);
        builder.append(from).append(" ").append(to).append('\n');
        ans++;
        dfs(n-1, via, to, from);
    }
}