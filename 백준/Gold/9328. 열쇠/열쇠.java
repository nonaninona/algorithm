import java.util.*;
import java.io.*;

public class Main {

    static int T, H, W;
    static char[][] B;
    static boolean[] K;
    static Queue<int[]> Q;
    static boolean[][] V;

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            B = new char[H][W];
            for(int i=0;i<H;i++) {
                String row = br.readLine();
                for(int j=0;j<W;j++) {
                    B[i][j] = row.charAt(j);
                }
            }

            //set initial Q
            V = new boolean[H][W];
            Q = new ArrayDeque<>();
            Q.offer(new int[]{-1, -1});
            for(int i=0;i<H;i++) {
                if(B[i][0] != '*') {
                    Q.offer(new int[]{i, 0});
                    V[i][0] = true;
                }
                if(B[i][W-1] != '*') {
                    Q.offer(new int[]{i, W - 1});
                    V[i][W-1] = true;
                }
            }

            for(int i=0;i<W;i++) {
                if(B[0][i] != '*') {
                    Q.offer(new int[]{0, i});
                    V[0][i] = true;
                }
                if(B[H-1][i] != '*') {
                    Q.offer(new int[]{H - 1, i});
                    V[H-1][i] = true;
                }
            }

            // key set
            K = new boolean[26];
            String keys = br.readLine();
            if(!keys.equals("0")) {
                for(int i = 0;i<keys.length();i++) {
                    K[keys.charAt(i) - 'a'] = true;
                }
            }

            int ans = 0;
            boolean isEnd = false;
            while(!Q.isEmpty()) {
                int[] n = Q.poll();
                int y = n[0];
                int x = n[1];
//                System.out.println(y + " " + x);
                if(y == -1 && x == -1) {
                    if(isEnd) break;
                    else isEnd = true;
                    Q.offer(new int[]{-1, -1});
                    continue;
                }

                if(B[y][x] == '$') {
                    B[y][x] = '.';
                    ans++;
                    isEnd = false;
                } else if(B[y][x] != '.') {
                    if(B[y][x] <= 'Z') {
                        int idx = B[y][x] - 'A';
                        if(K[idx]) {
                            B[y][x] = '.';
                            isEnd = false;
                        } else {
                            Q.offer(new int[] { y, x });
                            continue;
                        }
                    } else {
                        K[B[y][x] - 'a'] = true;
                        isEnd = false;
                    }
                }

                for(int i=0;i<4;i++) {
                    int ny = y + Dy[i];
                    int nx = x + Dx[i];

                    if(ny < 0 || nx < 0 || ny >= H || nx >= W)
                        continue;
                    if(B[ny][nx] == '*')
                        continue;
                    if(V[ny][nx])
                        continue;

                    Q.offer(new int[] { ny, nx });
                    isEnd = false;
                    V[ny][nx] = true;
                }
            }
            System.out.println(ans);
        }
    }
}