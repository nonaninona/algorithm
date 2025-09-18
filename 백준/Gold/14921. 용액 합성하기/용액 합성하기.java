import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        ans = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        while(left < right) {
            int sum = A[left] + A[right];
            if(Math.abs(sum) < Math.abs(ans)) {
                ans = sum;
            }

            if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans);
    }


}
