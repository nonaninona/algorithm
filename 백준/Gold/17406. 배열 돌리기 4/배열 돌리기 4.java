import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A, originalA;
    static int[][] operations;
    static int[] B;
    static boolean[] visited;
    static int ret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        originalA = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                originalA[i][j] = Integer.parseInt(st.nextToken());
        }

        operations = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                operations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = Integer.MAX_VALUE;
        B = new int[K];
        visited = new boolean[K];
        perm(0);

        System.out.println(ret);
    }

    private static void perm(int depth) {
        if (depth == K) {
            ret = Math.min(ret, calc());
            return;
        }

        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;
            B[depth] = i;
            visited[i] = true;
            perm(depth+1);
            visited[i] = false;
        }
    }

    private static int calc() {
        A = new int[N][];
//        System.out.println(Arrays.toString(B));

        for(int i=0;i<N;i++)
            A[i] = Arrays.copyOf(originalA[i], M);

        for(int k=0;k<K;k++) {
//            System.out.println(B[k]);
            int[] ops = operations[B[k]];
            int r = ops[0]-1;
            int c = ops[1]-1;
            int s = ops[2];

            for(int i=0;i<(2*s+1)/2;i++) {
                rotate(r, c, s, i);
//                printA();
            }

        }

        int ret = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            int sum = 0;
            for(int j=0;j<M;j++)
                sum+=A[i][j];
            ret = Math.min(ret, sum);
        }
        return ret;
    }

    private static void printA() {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(A[i]));
        System.out.println();
    }

    private static void rotate(int r, int c, int s, int l) {
//        System.out.println(r + " " + c + " " + s + " " + l);
        int temp = A[r-s+l][c-s+l];
        for(int i=r-s+l;i<r+s-l;i++)
            A[i][c-s+l] = A[i+1][c-s+l];
        for(int j=c-s+l;j<c+s-l;j++)
            A[r+s-l][j] = A[r+s-l][j+1];
        for(int i=r+s-l;i>r-s+l;i--)
            A[i][c+s-l] = A[i-1][c+s-l];
        for(int j=c+s-l;j>c-s+1+l;j--)
            A[r-s+l][j] = A[r-s+l][j-1];
        A[r-s+l][c-s+1+l] = temp;
    }
}