import java.io.*;
import java.util.*;

class Main {

    static int N;
    static String A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = br.readLine();

        int[] cnts = new int[26];
        int size = 0;
        int left = 0;
        int ans = Integer.MIN_VALUE;
        for(int right=0;right<A.length();right++) {
            char c = A.charAt(right);
            int cIdx = c - 'a';
            cnts[cIdx]++;
            if(cnts[cIdx] == 1)
                size++;
            while(size > N) {
                c = A.charAt(left);
                cIdx = c - 'a';
                cnts[cIdx]--;
                if(cnts[cIdx] == 0)
                    size--;
                left++;
            }

//            System.out.println(left + " " + right + " " + size);
//            System.out.println(Arrays.toString(cnts));
            ans = Math.max(ans, right-left+1);
        }

        System.out.println(ans);
    }


}
