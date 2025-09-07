import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] values;
    static int ans, vans1, vans2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        values = new int[N];
        for (int i = 0; i < N; i++)
            values[i] = Integer.parseInt(st.nextToken());

        int left = vans1 = 0;
        int right = vans2 = N - 1;
        ans = Math.abs(values[left] + values[right]);

        while (left != right) {
            int sum = values[left] + values[right];
            if (Math.abs(sum) < ans) {
                ans = Math.abs(sum);
                vans1 = left;
                vans2 = right;
            }

            if (sum < 0)
                left++;
            else if (sum > 0)
                right--;
            else
                break;

        }

        System.out.println(values[vans1] + " " + values[vans2]);
    }
}