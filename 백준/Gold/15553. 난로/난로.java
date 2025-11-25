import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        T = new int[N];
        for(int i=0;i<N;i++)
            T[i] = Integer.parseInt(br.readLine());

        int total = T[N-1] - T[0];

        int[] diff = new int[N-1];
        for(int i=0;i<N-1;i++)
            diff[i] = T[i+1]-T[i];

        Arrays.sort(diff);

        for(int i=0;i<K-1;i++)
            total -= (diff[N - 2 - i] - 1);
        System.out.println(total+1);
    }
}