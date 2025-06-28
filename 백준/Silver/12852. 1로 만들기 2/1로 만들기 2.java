import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int[] dp = null;
    static int end = -1;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        end = Integer.parseInt(br.readLine());
        dp = new int[end+1];
        for(int i=0;i<end+1;i++)
            dp[i] = -1;

        bfs();

        int num = end;
        List<Integer> path = new ArrayList<>();
        while(num != 0) {
            path.add(num);
            num = dp[num];
        }

        System.out.println(path.size()-1);
        System.out.println(String.join(" ", path.stream().map(String::valueOf).collect(Collectors.toList())));

    }

    private static void bfs() {
        q.offer(1);
        dp[1] = 0;

        while(!q.isEmpty()) {
            int num = q.poll();

            if(num * 3 <= end) {
                int nNum = num * 3;
                if(dp[nNum] == -1) {
                    dp[nNum] = num;
                    q.offer(nNum);
                }
            }
            if(num * 2 <= end) {
                int nNum = num * 2;
                if(dp[nNum] == -1) {
                    dp[nNum] = num;
                    q.offer(nNum);
                }
            }
            if(num + 1 <= end) {
                int nNum = num + 1;
                if (dp[nNum] == -1) {
                    dp[nNum] = num;
                    q.offer(nNum);
                }
            }
        }
    }
}

