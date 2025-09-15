import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static String[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());

            S = new String[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
                S[i] = st.nextToken();

            int f = 0;
            int s = N/2;
            if(N%2 == 1)
                s++;

            sb.append("#").append(tc).append(" ");
            for(int i=0;i<N/2;i++) {
                sb.append(S[f++]).append(" ");
                sb.append(S[s++]).append(" ");
            }
            if(N%2 == 1)
                sb.append(S[f]);
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
