import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] A;

    public static void main(String[] args) throws FileNotFoundException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int times = Math.min(N / 2, M / 2);
        for (int i = 0; i < times; i++) {
            int cycleLength = 2 * (N - 2 * i) + 2 * (M - 2 * i) - 4;
//            System.out.println(cycleLength);
            rotate(i, R % cycleLength, cycleLength);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                builder.append(A[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static void rotate(int l, int r, int cl) {
//        System.out.println(N + " " + M + " " + r + " " + l);
        List<Integer> list = new ArrayList<>(cl);
        for (int j = l; j < M - 1 - l; j++)
            list.add(A[l][j]);
        for (int i = l; i < N - 1 - l; i++)
            list.add(A[i][M - 1 - l]);
        for (int j = M - 1 - l; j > l; j--)
            list.add(A[N - 1 - l][j]);
        for (int i = N - 1 - l; i > l; i--)
            list.add(A[i][l]);
        Collections.rotate(list, -r);

        int idx = 0;
        for (int j = l; j < M - 1 - l; j++)
            A[l][j] = list.get(idx++);
        for (int i = l; i < N - 1 - l; i++)
            A[i][M - 1 - l] = list.get(idx++);
        for (int j = M - 1 - l; j > l; j--)
            A[N - 1 - l][j] = list.get(idx++);
        for (int i = N - 1 - l; i > l; i--)
            A[i][l] = list.get(idx++);
    }
}