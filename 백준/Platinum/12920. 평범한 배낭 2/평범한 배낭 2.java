import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] V, C, K;
    static List<Integer> newV = new ArrayList<>();
    static List<Integer> newC = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N];
        C = new int[N];
        K = new int[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 1;
            while(true) {
                if(k - count < 0)
                    break;
                newV.add(v * count);
                newC.add(c * count);
                k-=count;
                count *= 2;
            }
            if(k > 0) {
                newV.add(v * k);
                newC.add(c * k);
            }
        }

        int newN = newV.size();
        dp = new int[newN+1][M+1];

//        System.out.println(newV);
//        System.out.println(newC);

        for(int i=1;i<newN+1;i++) {
            int v = newV.get(i-1);
            int c = newC.get(i-1);
            for(int j=1;j<M+1;j++) {
                if(j-v >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v] + c);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

//        for(int i=0;i<newN+1;i++)
//            System.out.println(Arrays.toString(dp[i]));

        System.out.println(dp[newN][M]);
    }
}