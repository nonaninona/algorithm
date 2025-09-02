import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, C;
    static int[][] board;
    static List<int[]> L1, L2;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[10][10];
        L1 = new ArrayList<>();
        L2 = new ArrayList<>();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MIN_VALUE;
//            System.out.println(123123123);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    for (int m = 0; m < M; m++) {
                        L1.add(new int[]{i, j + m});
                    }

                    for (int i2 = 0; i2 < N; i2++) {
                        for (int j2 = 0; j2 < N - M + 1; j2++) {
                            boolean isOk = true;
                            for (int m2 = 0; m2 < M; m2++) {
                                int[] target = new int[]{i2, j2 + m2};
                                isOk = check(i2, j2, m2);
                                if (!isOk) break;
                                L2.add(target);
                            }


                            if (!isOk) {
                                L2.clear();
                                continue;
                            }

//                            System.out.println("=".repeat(10));
//                            for (int[] d : L1)
//                                System.out.print(Arrays.toString(d) + " ");
//                            System.out.println();
//
//                            for (int[] d : L2)
//                                System.out.print(Arrays.toString(d) + " ");
//                            System.out.println();
//                            System.out.println("=".repeat(10));

                            calc();
                            ans = Math.max(ans, maxRet1 + maxRet2);

                            L2.clear();
                        }
                    }

                    L1.clear();
                }
            }

            System.out.printf("#%d %d\n", tc, ans);


        }

    }

    private static boolean check(int i2, int j2, int m2) {
        for (int[] d : L1) {
            int y = d[0];
            int x = d[1];
            if (y == i2 && j2 + m2 == x)
                return false;
        }
        return true;
    }

    static int ret1, ret2;
    static int pRet1, pRet2;
    static int maxRet1, maxRet2;

    private static void calc() {
        ret1 = 0;
        pRet1 = 0;
        maxRet1 = Integer.MIN_VALUE;
        subset1(0);

        ret2 = 0;
        pRet2 = 0;
        maxRet2 = Integer.MIN_VALUE;
        subset2(0);

//        System.out.println(maxRet1 + maxRet2);
    }

    private static void subset1(int depth) {
        if (depth == L1.size()) {
//            System.out.println(ret1 + " " + pRet1);
            if (ret1 <= C)
                maxRet1 = Math.max(maxRet1, pRet1);
            return;
        }

        subset1(depth + 1);

        int[] dot = L1.get(depth);
        int y = dot[0];
        int x = dot[1];
        ret1 += board[y][x];
        pRet1 += board[y][x] * board[y][x];
        subset1(depth + 1);
        ret1 -= board[y][x];
        pRet1 -= board[y][x] * board[y][x];
    }

    private static void subset2(int depth) {
        if (depth == L2.size()) {
            if (ret2 <= C)
                maxRet2 = Math.max(maxRet2, pRet2);
            return;
        }

        subset2(depth + 1);

        int[] dot = L2.get(depth);
        int y = dot[0];
        int x = dot[1];
        ret2 += board[y][x];
        pRet2 += board[y][x] * board[y][x];
        subset2(depth + 1);
        ret2 -= board[y][x];
        pRet2 -= board[y][x] * board[y][x];
    }
}