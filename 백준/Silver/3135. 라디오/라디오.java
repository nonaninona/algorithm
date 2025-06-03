import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] costs;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] channels = new int[N];
        for (int i = 0; i < N; i++)
            channels[i] = Integer.parseInt(br.readLine());

        int ret = Math.abs(A-B);
        for(int i=0;i<N;i++)
            ret = Math.min(ret, Math.abs(channels[i]-B)+1);

        System.out.println(ret);
    }
}