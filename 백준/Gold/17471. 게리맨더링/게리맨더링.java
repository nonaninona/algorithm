import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] V;
    static List<Integer>[] G;
    static boolean[] selected;
    static boolean[] visited;
    static int ret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        V = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            V[i] = Integer.parseInt(st.nextToken());

        G = new List[N];
        for(int i=0;i<N;i++) {
            G[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++)
                G[i].add(Integer.parseInt(st.nextToken())-1);
        }

        selected = new boolean[N];
        ret = Integer.MAX_VALUE;
        subset(0);

        if(ret == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ret);

    }

    private static void subset(int depth) {
        if(depth == N) {
//            System.out.println(Arrays.toString(selected));
            if(isOk()) {
                int left = 0;
                int right = 0;
                for(int i=0;i<N;i++) {
                    if(selected[i])
                        left += V[i];
                    else
                        right += V[i];
                }
                ret = Math.min(ret, Math.abs(left-right));
            }
            return;
        }

        selected[depth] = true;
        subset(depth+1);
        selected[depth] = false;
        subset(depth+1);
    }

    private static boolean isOk() {
        int trueStart = -1;
        int falseStart = -1;

        for(int i=0;i<N;i++) {
            if(selected[i] && trueStart == -1)
                trueStart = i;
            if(!selected[i] && falseStart == -1)
                falseStart = i;
        }

//        System.out.println(trueStart + " " + falseStart);

        if(trueStart == -1 || falseStart == -1)
            return false;

        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            if(!selected[i])
                visited[i] = true;
        }
        dfs(trueStart);
//        System.out.println("1" + Arrays.toString(visited));
        for(int i=0;i<N;i++)
            if(!visited[i])
                return false;

        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            if(selected[i])
                visited[i] = true;
        }
        dfs(falseStart);
//        System.out.println("2" + Arrays.toString(visited));
        for(int i=0;i<N;i++)
            if(!visited[i])
                return false;

//        System.out.println("OK");
        return true;
    }

    private static void dfs(int n) {
        visited[n] = true;
        List<Integer> edges = G[n];
        for(int e : edges) {
            if(!visited[e])
                dfs(e);
        }
    }
}