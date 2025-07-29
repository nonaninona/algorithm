import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static boolean[] visitedCol, visitedDiagRightDown, visitedDiagRightUp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visitedCol = new boolean[N];
        visitedDiagRightDown = new boolean[N + N - 1];
        visitedDiagRightUp = new boolean[N + N - 1];
        C = 0;

        dfs(0);
        System.out.println(C);
    }

    private static void dfs(int row) {
        if(row == N) {
            C++;
            return;
        }

        for(int j=0;j<N;j++) {
            if(isPlaceable(row, j)) {
                visitedCol[j] = true;
                visitedDiagRightDown[row+j] = true;
                visitedDiagRightUp[row-j+N-1] = true;
                dfs(row+1);
                visitedCol[j] = false;
                visitedDiagRightDown[row+j] = false;
                visitedDiagRightUp[row-j+N-1] = false;
            }
        }
    }

    private static boolean isPlaceable(int y, int x) {
        return !(visitedCol[x] || visitedDiagRightDown[y+x] || visitedDiagRightUp[y-x+N-1]);
    }
}