import java.util.*;
import java.io.*;

class Solution {

    static int T, N, M, K;

    //dir = 0 -> north / 1 -> south / 2 -> west / 3 -> east
    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    enum DIR {
        NORTH(0), SOUTH(1), WEST(2), EAST(3);

        int value;

        DIR(int v) {
            this.value = v;
        }

        static DIR from(int v) {
            if(v == 0)
                return DIR.NORTH;
            else if(v == 1)
                return DIR.SOUTH;
            else if(v == 2)
                return DIR.WEST;
            else
                return DIR.EAST;
        }
    }

    static class Swarm {
        int y;
        int x;
        int cnt;
        DIR dir;

        public Swarm(int y, int x, int cnt, DIR dir) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    static PriorityQueue<Swarm>[][] PQ1, PQ2, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            PQ1 = new PriorityQueue[N][N];
            PQ2 = new PriorityQueue[N][N];
            temp = new PriorityQueue[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    PQ1[i][j] = new PriorityQueue<>(Comparator.comparing((Swarm s) -> -s.cnt));
                    PQ2[i][j] = new PriorityQueue<>(Comparator.comparing((Swarm s) -> -s.cnt));
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                DIR dir = DIR.from(Integer.parseInt(st.nextToken()) - 1);

                PQ1[y][x].offer(new Swarm(y, x, cnt, dir));
            }


            for (int t = 0; t < M; t++) {
                move();
                devour();
                temp = PQ1;
                PQ1 = PQ2;
                PQ2 = temp;
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    while (!PQ1[i][j].isEmpty()) {
                        Swarm s = PQ1[i][j].poll();
                        ans += s.cnt;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void devour() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(PQ2[i][j].size() > 1) {
                    Swarm p = PQ2[i][j].poll();
                    while (!PQ2[i][j].isEmpty()) {
                        Swarm s = PQ2[i][j].poll();
                        p.cnt += s.cnt;
                    }
                    PQ2[i][j].offer(p);
//                    System.out.println("devour " + i + " " + j + " " + p.y + " " + p.x + " " + p.cnt + " " + p.dir);
                }
            }
        }
    }

    private static void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!PQ1[i][j].isEmpty()) {
                    Swarm s = PQ1[i][j].poll();
                    s.y += Dy[s.dir.value];
                    s.x += Dx[s.dir.value];
                    if (s.y == 0 || s.x == 0 || s.y == N - 1 || s.x == N - 1)
                        s.cnt /= 2;
                    if (s.cnt == 0)
                        continue;

                    if (s.dir == DIR.NORTH && s.y == 0)
                        s.dir = DIR.SOUTH;
                    else if (s.dir == DIR.SOUTH && s.y == N - 1)
                        s.dir = DIR.NORTH;
                    else if (s.dir == DIR.WEST && s.x == 0)
                        s.dir = DIR.EAST;
                    else if (s.dir == DIR.EAST && s.x == N - 1)
                        s.dir = DIR.WEST;

                    PQ2[s.y][s.x].offer(s);
//                    System.out.println("move " + i + " " + j + " " + s.y + " " + s.x + " " + s.cnt + " " + s.dir);
                }
            }
        }
    }
}