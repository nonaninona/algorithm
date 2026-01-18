import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int dir, k;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        // 증가할 때
        int k1 = 0;
        for(int i=0;i<N-1;i++) {
           if(A[i] > A[i+1]) {
               if(k1 != 0) {
                   k1 = -1;
                   break;
               }

               if(A[N-1] > A[0]) {
                   k1 = -1;
                   break;
               }

               k1 = i+1;
           }
        }

        int k2 = 0;
        for(int i=0;i<N-1;i++) {
            if(A[i] < A[i+1]) {
                if(k2 != 0) {
                    k2 = -1;
                    break;
                }

                if(A[N-1] < A[0]) {
                    k2 = -1;
                    break;
                }

                k2 = i+1;
            }
        }

        if(k1 == -1 && k2 == -1) {
            System.out.println(-1);
        } else if(k1 == -1) {
            System.out.println(k2);
        } else if(k2 == -1) {
            System.out.println(k1);
        } else {
            System.out.println(Math.min(k1, k2));
        }



    }

}