import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static boolean[] V;
    static Queue<Integer> Q;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());

            D = new int[N+2][2];
            Q = new ArrayDeque<>();
            V = new boolean[N+2];
            for(int i=0;i<N+2;i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                D[i][0] = y;
                D[i][1] = x;
            }

            boolean ret = bfs();
            if(ret)
                System.out.println("happy");
            else
                System.out.println("sad");

        }

    }

    private static boolean bfs() {
        Q.offer(0);
        V[0] = true;
        while(!Q.isEmpty()) {
            int idx = Q.poll();
            for(int i=0;i<N+2;i++) {
                if(!V[i] && getDist(idx, i) <= 1000) {
                    if(i == N+1)
                        return true;

                    V[i] = true;
                    Q.offer(i);
                }
            }
        }
        return false;
    }

    private static int getDist(int s, int e) {
        if(s == e)
            return 0;

        return Math.abs(D[s][0] - D[e][0]) + Math.abs(D[s][1] - D[e][1]);
    }
}