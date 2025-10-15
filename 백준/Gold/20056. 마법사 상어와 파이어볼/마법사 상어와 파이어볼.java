import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;

    static int[] Dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] Dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static List<Fireball>[][] A;

    static class Fireball {
        int y, x, m, d, s;

        public Fireball(int y, int x, int m, int s, int d) {
            this.y = y;
            this.x = x;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = createBoard();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            A[y][x].add(new Fireball(y, x, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            move();
            merge();
        }


        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fireball fb : A[i][j]) {
                    ans += fb.m;
                }
            }
        }

        System.out.println(ans);
    }

    private static void merge() {
        var newA = createBoard();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = A[i][j].size();
//                System.out.println(cnt + " ");
                if (cnt == 0)
                    continue;
                else if (cnt == 1) {
                    newA[i][j].add(A[i][j].get(0));
                    continue;
                }

//                System.out.println(i + " " + j);

                boolean isSame = true;
                int d = A[i][j].get(0).d % 2;
                int mSum = 0;
                int sSum = 0;
                for (Fireball fb : A[i][j]) {
                    mSum += fb.m;
                    sSum += fb.s;
                    if (isSame && d != fb.d % 2)
                        isSame = false;
                }

                int newM = mSum / 5;
                int newS = sSum / cnt;
                int dBase = isSame ? 0 : 1;
                if (newM > 0) {
                    for (int f = 0; f < 4; f++) {
                        newA[i][j].add(
                                new Fireball(
                                        i, j,
                                        newM,
                                        newS,
                                        2 * f + dBase
                                )
                        );
                    }
                }
            }
        }
        A = newA;
    }


    private static void move() {
        var newA = createBoard();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fireball fb : A[i][j]) {
                    int ny = i + Dy[fb.d] * fb.s;
                    int nx = j + Dx[fb.d] * fb.s;

                    while (ny < 0) ny += N;
                    while (nx < 0) nx += N;
                    if (ny >= N) ny %= N;
                    if (nx >= N) nx %= N;

//                    System.out.println(ny + " " + nx);

                    Fireball newFB = new Fireball(ny, nx, fb.m, fb.s, fb.d);
                    newA[ny][nx].add(newFB);
                }
            }
        }
        A = newA;
    }

    public static List<Fireball>[][] createBoard() {
        List<Fireball>[][] ret = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret[i][j] = new ArrayList<>();
            }
        }
        return ret;
    }
}