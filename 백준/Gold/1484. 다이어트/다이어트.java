import java.io.*;
import java.util.*;

class Main {

    static int G;
    static List<Integer> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());

        int left = 1;
        int diff = -1;
        for(int right = 1; right<100_000;right++) {
            diff = right*right - left*left;

            while(left < right && diff > G) {
                left++;
                diff = right*right - left*left;
            }

            diff = right*right - left*left;
            if(diff == G)
                ans.add(right);
        }

        if(ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for(int a : ans)
                sb.append(a).append("\n");
            System.out.print(sb);
        }

    }


}
