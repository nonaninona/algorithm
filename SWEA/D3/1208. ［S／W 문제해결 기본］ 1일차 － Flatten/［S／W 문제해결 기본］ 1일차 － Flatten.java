import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1;tc<10+1;tc++) {
            N = Integer.parseInt(br.readLine());

            A = new int[100];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<100;i++)
                A[i] = Integer.parseInt(st.nextToken());

            for(int k=0;k<N;k++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int maxIdx = -1, minIdx = -1;
                for (int i = 0; i < 100; i++) {
                    if (A[i] > max) {
                        max = A[i];
                        maxIdx = i;
                    }
                    if (A[i] < min) {
                        min = A[i];
                        minIdx = i;
                    }
                }
                A[maxIdx]--;
                A[minIdx]++;
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 100; i++) {
                max = Math.max(max, A[i]);
                min = Math.min(min, A[i]);
            }

            System.out.println("#" + tc + " " + (max-min));
        }
    }
}