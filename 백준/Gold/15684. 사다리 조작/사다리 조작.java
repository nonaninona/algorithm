import java.io.*;
import java.util.*;

public class Main {

    static int N, M, H;
    static boolean[][] ladders;
    static int ans = 5;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladders = new boolean[H][N-1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            ladders[a][b] = true;
        }

        if(isEnd()) {
            System.out.println(0);
            return;
        }

        dfs(0, 0, 0);
        if(ans == 5)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    private static void dfs(int cnt, int y, int x) {
        if(cnt == 3)
            return;

        if(y == H-1 && x == N-1)
            return;

        if(x == N-1) {
            dfs(cnt, y+1, 0);
            return;
        }

        if(!checkIsPlaceable(y, x)) {
            dfs(cnt, y, x + 1);
            return;
        }

        dfs(cnt, y, x+1);

        ladders[y][x] = true;
        if(isEnd()) {
            ans = Math.min(ans, cnt+1);
            ladders[y][x] = false;
            return;
        }

        dfs(cnt+1, y, x+1);
        ladders[y][x] = false;
    }

    private static boolean checkIsPlaceable(int y, int x) {
        if(ladders[y][x])
            return false;
        if(x-1 >= 0) {
            if(ladders[y][x-1]) {
                return false;
            }
        }
        if(x+1 < N-1) {
            if(ladders[y][x+1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEnd() {
        for(int i=0;i<N;i++) {
            if(downLadder(i) != i)
                return false;
        }
        return true;
    }

    private static int downLadder(int startIdx) {
        for(int i=0;i<H;i++) {
            if(startIdx - 1 >= 0 && ladders[i][startIdx-1]) {
                startIdx--;
            } else if(startIdx < N-1 && ladders[i][startIdx]) {
                startIdx++;
            }
        }
        return startIdx;
    }
}