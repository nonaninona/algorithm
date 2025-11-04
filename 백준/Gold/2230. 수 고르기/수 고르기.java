import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[] A;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        ans = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        while(left <= right && right < N) {
            int diff = A[right] - A[left];
            if(diff < M)
                right++;
            else {
                left++;
                ans = Math.min(ans, diff);
            }
        }

        System.out.println(ans);
    }


}
