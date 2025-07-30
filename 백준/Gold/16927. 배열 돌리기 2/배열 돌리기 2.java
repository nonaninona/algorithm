import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] A;

    public static void main(String[] args) throws FileNotFoundException, Exception {
//		System.setIn(new FileInputStream("Test4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int times = Math.min(N/2,  M/2);
        for(int i=0;i<times;i++) {
            int cycleLength = 2 * (N - 2 * i) + 2 * (M - 2 * i) - 4;
//            System.out.println(cycleLength);
            rotate(i, R%cycleLength);
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                builder.append(A[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static void rotate(int l, int r) {
//        System.out.println(N + " " + M + " " + r + " " + l);
        for(int k=0;k<r;k++) {
            int temp = A[l][l];
            for(int j=l;j<M-1-l;j++)
                A[l][j] = A[l][j+1];
            for(int i=l;i<N-1-l;i++)
                A[i][M-1-l] = A[i+1][M-1-l];
            for(int j=M-1-l;j>l;j--)
                A[N-1-l][j] = A[N-1-l][j-1];
            for(int i=N-1-l;i>l+1;i--)
                A[i][l] = A[i-1][l];
            A[l+1][l] = temp;
        }
    }
}