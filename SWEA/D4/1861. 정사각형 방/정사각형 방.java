import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] A;
    static int[][] indegrees;

    static int[] Dx = { -1, 0, 1, 0 };
    static int[] Dy = { 0, 1, 0, -1 };

    static Queue<int[]> Q;
    static int[][] ans;
    static int[][][] ret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            indegrees = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    for(int k=0;k<4;k++) {
                        int ny = i+Dy[k], nx = j+Dx[k];
                        if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                            continue;
                        if(A[i][j] == A[ny][nx] + 1)
                            indegrees[i][j]++;
                    }
                }
            }


//            for(int i=0;i<N;i++) {
//                System.out.println(Arrays.toString(indegrees[i]));
//            }
//            System.out.println();

            Q = new ArrayDeque<>();
            ans = new int[N][N];
            ret = new int[N][N][2];

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(indegrees[i][j] == 0) {
                        Q.offer(new int[]{i, j});
                        ans[i][j] = 1;
                        ret[i][j][0] = i;
                        ret[i][j][1] = j;
                    }
                }
            }


//            for(int i=0;i<N;i++) {
//                System.out.println(Arrays.toString(ans[i]));
//            }
//            System.out.println();


            while(!Q.isEmpty()) {
                int[] pos = Q.poll();
                int y = pos[0];
                int x = pos[1];

                for(int k=0;k<4;k++) {
                    int ny = y+Dy[k], nx = x+Dx[k];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                        continue;
                    if(A[y][x] + 1 == A[ny][nx]) {
                        indegrees[ny][nx]--;
                        if(ans[ny][nx] < ans[y][x] + 1) {
                            ans[ny][nx] = ans[y][x] + 1;
                            ret[ny][nx][0] = ret[y][x][0];
                            ret[ny][nx][1] = ret[y][x][1];
                        }
                        if(indegrees[ny][nx] == 0)
                            Q.offer(new int[]{ny, nx});
                    }
                }
            }



//            for(int i=0;i<N;i++) {
//                System.out.println(Arrays.toString(ans[i]));
//            }
//            System.out.println();
//
//
//
//
//            for(int i=0;i<N;i++) {
//                for(int j=0;j<N;j++) {
//                    System.out.print(Arrays.toString(ret[i][j]) + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();




            int max = Integer.MIN_VALUE;
            int maxY = -1, maxX = -1;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(max < ans[i][j]) {
                        max = ans[i][j];
                        maxY = i;
                        maxX = j;
                    } else if(max == ans[i][j]) {
                        if(A[maxY][maxX] > A[i][j]) {
                            maxY = i;
                            maxX = j;
                        }
                    }
                }
            }

            int startY = ret[maxY][maxX][0];
            int startX = ret[maxY][maxX][1];
            System.out.printf("#%d %d %d\n", tc, A[startY][startX], ans[maxY][maxX]);


        }
    }
}