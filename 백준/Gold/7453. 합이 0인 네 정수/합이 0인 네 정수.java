import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] A, B, C, D;
    static int[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        arr1 = new int[N*N];
        arr2 = new int[N*N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr1[i*N+j] = A[i] + B[j];
                arr2[i*N+j] = C[i] + D[j];
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));

        int left = 0;
        int right = N*N-1;
        long ans = 0;
        while(right >= 0 && left < N*N) {
//            System.out.println(arr1[left] + " " + arr2[right]);
            int sum = arr1[left] + arr2[right];
            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                int num1 = arr1[left];
                int num2 = arr2[right];

                int cnt1 = 0;
                int cnt2 = 0;
                while(left < N*N && arr1[left] == num1) {
                    cnt1++;
                    left++;
                }
                while(right >= 0 && arr2[right] == num2) {
                    cnt2++;
                    right--;
                }

                ans += (long) cnt1 * cnt2;
            }
        }

        System.out.println(ans);
    }


}
