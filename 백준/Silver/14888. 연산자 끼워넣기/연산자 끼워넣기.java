import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] ops;
    static int[] operator;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ops = new int[4];
        for(int i=0;i<4;i++)
            ops[i] = Integer.parseInt(st.nextToken());

        operator = new int[N-1];
        int idx = 0;
        int p = 0;
        while(p < 4) {
            if(ops[p] > 0) {
                ops[p]--;
            } else {
                p++;
                continue;
            }

            operator[idx] = p;
            idx++;
        }

        visited = new boolean[N-1];
        dfs(0, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int v) {
        if(depth == N-1) {
            max = Math.max(max, v);
            min = Math.min(min, v);
            return;
        }

        int prevV = v;
        for(int i=0;i<N-1;i++) {
            if(visited[i]) continue;
            if(operator[i] == 0) {
                v += A[depth+1];
            } else if(operator[i] == 1) {
                v -= A[depth+1];
            } else if(operator[i] == 2) {
                v *= A[depth+1];
            } else if(operator[i] == 3) {
                v /= A[depth+1];
            }
            visited[i] = true;
            dfs(depth+1, v);
            visited[i] = false;
            v = prevV;
        }
    }
}