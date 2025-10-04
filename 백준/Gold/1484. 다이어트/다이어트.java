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
        for(int right = 1; right<(G+1)/2+1;right++) {
            while(left < right && right*right - left*left > G) {
                left++;
            }

            if(right*right - left*left == G)
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
