import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] operator;
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
        operator = new int[4];
        for(int i=0;i<4;i++)
            operator[i] = Integer.parseInt(st.nextToken());

        dfs(0, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int v) {
//        System.out.println(depth + " " + v);

        if(depth == N-1) {
            max = Math.max(max, v);
            min = Math.min(min, v);
            return;
        }

        int nextV = v;
        for(int i=0;i<4;i++) {
            if(operator[i] > 0)
                operator[i]--;
            else
                continue;

            if(i == 0) {
                nextV += A[depth+1];
            } else if(i == 1) {
                nextV -= A[depth+1];
            } else if(i == 2) {
                nextV *= A[depth+1];
            } else if(i == 3) {
                nextV /= A[depth+1];
            }

            dfs(depth+1, nextV);

            operator[i]++;
            nextV = v;
        }
    }
}