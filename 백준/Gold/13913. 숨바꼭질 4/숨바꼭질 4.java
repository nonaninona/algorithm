import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int K;
    static int[] dp = new int[100_001];
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<100_001;i++)
            dp[i] = -1;

        bfs();

        List<Integer> path = new ArrayList<>();
        int num = K;
        while(true) {
            path.add(num);

            if(num == N)
                break;

            num = dp[num];
        }

        List<Integer> newPath = new ArrayList<>();
        for(int i=path.size()-1;i>=0;i--)
            newPath.add(path.get(i));
        
        System.out.println(newPath.size()-1);
        System.out.println(String.join(" ", newPath.stream().map(String::valueOf).collect(Collectors.toList())));
    }

    private static void bfs() {
        q.offer(N);

        while(!q.isEmpty()) {
            int num = q.poll();

            int nNum = num-1;
            offer(nNum, num);

            nNum = num+1;
            offer(nNum, num);

            nNum = num*2;
            offer(nNum, num);
        }
    }

    private static void offer(int nNum, int num) {
        if(0 <= nNum && nNum <= 100_000) {
            if(dp[nNum] == -1) {
                q.offer(nNum);
                dp[nNum] = num;
            }
        }
    }
}
