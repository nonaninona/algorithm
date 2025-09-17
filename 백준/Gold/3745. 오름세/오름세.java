import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s != null) s = s.trim();
            else break;

            int n = Integer.parseInt(s);
            int[] lis = new int[n];
            int ptr = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++) {
                int x = Integer.parseInt(st.nextToken());
                if(i == 0 || lis[ptr - 1] < x) {
                    lis[ptr++] = x;
                } else {
                    int key = Arrays.binarySearch(lis, 0, ptr, x);
                    key = key < 0 ? -key - 1 : key;
                    lis[key] = x;
                }
            }
            sb.append(ptr).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}