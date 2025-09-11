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
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        ans = 0;
        for(int i=0;i<N;i++) {
            int left = 0;
            int right = N-1;
            while(left < right) {
                if(left == i)
                    left++;
                if(right == i)
                    right--;

                if(!(left < right))
                    break;

                int sum = A[left] + A[right];
                if(sum == A[i]) {
//                    System.out.println(A[i] + " " + A[left] + " " + A[right]);
                    ans++;
                    break;
                } else if(sum > A[i]) {
                    right--;
                } else if(sum < A[i]) {
                    left++;
                }
            }
        }

        System.out.println(ans);
    }
}
