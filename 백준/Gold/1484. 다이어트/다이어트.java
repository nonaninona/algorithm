import java.io.*;
import java.util.*;

class Main {

    static int G;
    static List<Integer> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());

        for(int r=1;r<Math.sqrt(G);r++) {
            if(G%r==0) {
                int p = G/r;
                int A = Math.min(r, p);
                int B = Math.max(r, p);
                //A = new - old, B = new + old

                if(A%2 == B%2) {
                    int now = (A+B) / 2;
                    ans.add(now);
                }
            }
        }

        if(ans.isEmpty()) {
            System.out.println(-1);
        } else {
            ans.sort(Comparator.naturalOrder());
            for(int a : ans) {
                sb.append(a).append("\n");
            }
            System.out.print(sb);
        }

    }


}
