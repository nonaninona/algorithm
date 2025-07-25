import java.io.*;
import java.util.*;

public class Solution {

    static int N, T;
    static int[] heights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<T+1;tc++) {
            N = Integer.parseInt(br.readLine());

            heights = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, heights[i]);
            }

            int twoCount = 0;
            int oneCount = 0;
            for (int i = 0; i < N; i++) {
                int remain = max - heights[i];
                twoCount += remain / 2;
                oneCount += remain % 2;
            }

            if(oneCount > twoCount) {
                System.out.println("#" + tc + " " + (oneCount * 2 - 1));
            } else {
                int total = (twoCount * 2 + oneCount);
                int d = total / 3;
                int r = total % 3;
                if(r == 0)
                    System.out.println("#" + tc + " " + d * 2);
                else if(r == 1)
                    System.out.println("#" + tc + " " + (d*2+1));
                else if(r == 2)
                    System.out.println("#" + tc + " " + ((d+1) * 2));
            }
        }
    }
}