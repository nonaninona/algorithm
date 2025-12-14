import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, H, W, O, F, xStart, yStart, xEnd, yEnd;
    static int[][] B;
    static PriorityQueue<int[]> Q;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            yStart = Integer.parseInt(st.nextToken()) - 1;
            xStart = Integer.parseInt(st.nextToken()) - 1;
            yEnd = Integer.parseInt(st.nextToken()) - 1;
            xEnd = Integer.parseInt(st.nextToken()) - 1;

            B = new int[H][W];
            for(int i=0;i<O;i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken())-1;
                int l = Integer.parseInt(st.nextToken());

                B[y][x] = l;
            }

            Q = new PriorityQueue<>(Comparator.comparing((int[] l) -> -l[2]));
            dist = new int[H][W];
            for(int i=0; i<H; i++) {
                Arrays.fill(dist[i], -1);
            }

            boolean isFinished = dijkstra();
            System.out.println(isFinished ? "잘했어!!" : "인성 문제있어??");
        }

    }

    static boolean dijkstra() {
        if (yStart == yEnd && xStart == xEnd) return true;

        Q.offer(new int[]{yStart, xStart, F});
        dist[yStart][xStart] = F;
        while (!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int f = node[2];

//            for(int i=0;i<H;i++)
//                System.out.println(Arrays.toString(dist[i]));
//            System.out.println(y + " " + x + " " + f);

            if(f < dist[y][x])
                continue;

            for(int i=0;i<4;i++) {
                int nY = y + Dy[i];
                int nX = x + Dx[i];

                if(nY < 0 || nX < 0 || nY >= H || nX >= W)
                    continue;
                if(B[nY][nX] - B[y][x] > f)
                    continue;

                if(f-1 > dist[nY][nX]) {
                    dist[nY][nX] = f-1;
                    if(nY == yEnd && nX == xEnd)
                        return true;
                    if(f-1 > 0)
                        Q.offer(new int[]{nY, nX, f - 1});
                }
            }
        }
        return false;
    }

    static int[] Dy = { -1, 0, 1, 0 };
    static int[] Dx = { 0, -1, 0, 1 };
}