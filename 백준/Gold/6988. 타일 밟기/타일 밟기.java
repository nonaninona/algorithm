import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] num;

    static short[][] len;
    static long[][] sum;

    static long ans; 
    static int[] pos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if (input == null) return;
        N = Integer.parseInt(input);

        num = new int[N + 1];
        pos = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            num[i] = n;
            pos[n] = i;
        }

        len = new short[N + 1][N + 1];
        sum = new long[N + 1][N + 1];

        ans = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                int diff = num[i] - num[j];

                len[i][j] = 2;
                sum[i][j] = (long)num[j] + num[i];

                int target = num[j] - diff;
                if (target >= 1 && target <= 1000000 && pos[target] != 0) {
                    int p = pos[target];

                        short prevLen = len[j][p];
                        long prevSum = sum[j][p];

                        len[i][j] = (short)(prevLen + 1);
                        sum[i][j] = prevSum + num[i];
                }

                if (len[i][j] >= 3) {
                    ans = Math.max(ans, sum[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}