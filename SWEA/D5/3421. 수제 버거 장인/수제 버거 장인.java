import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static Set<Integer> S;
    static int ret;
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for (int i = 0; i < N; i++)
                map.put(i, new HashSet<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                map.get(a).add(b);
                map.get(b).add(a);
            }

            ret = 0;
            S = new HashSet<>();
            dfs(0);

            System.out.printf("#%d %d\n", tc, ret);
        }
    }

    private static void dfs(int depth) {
        if(depth == N) {
            ret++;
            return;
        }

        if(isCount(depth)) {
            S.add(depth);
            dfs(depth+1);
            S.remove(depth);
        }
        dfs(depth+1);
    }

    private static boolean isCount(int depth) {
        for(int s : map.get(depth))
            if(S.contains(s))
                return false;
        return true;
    }
}