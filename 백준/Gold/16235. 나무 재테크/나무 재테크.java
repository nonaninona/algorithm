import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] A;
    static PriorityQueue<Tree>[][] T;
    static int[][] L;

    static class Tree {
        int age;

        public Tree(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T = new PriorityQueue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                T[i][j] = new PriorityQueue<>(Comparator.comparing((Tree t) -> t.age));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            T[x][y].offer(new Tree(z));
        }

        L = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(L[i], 5);

        for (int t = 0; t < K; t++) {
            // 봄 + 여름
            grow();
//            System.out.println("grow");
//            printL();
//            printCount();
            // 가을
            reproduce();
//            System.out.println("reproduce");
//            printL();
//            printCount();
            // 겨울
            fertilize();
//            System.out.println("fertilize");
//            printL();
//            printCount();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                var PQ = T[i][j];
                ans += PQ.size();
            }
        }

        System.out.println(ans);
    }

    private static void printCount() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(T[i][j].size() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printL() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(L[i]));
        }
        System.out.println();
    }

    private static void fertilize() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                L[i][j] += A[i][j];
            }
        }
    }

    static int[] Dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] Dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void reproduce() {
        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                var PQ = T[i][j];

                var it = PQ.iterator();
                while(it.hasNext()) {
                    Tree t = it.next();
                    if (t.age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = i + Dy[d];
                            int nx = j + Dx[d];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                                continue;

                            trees.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        for(int[] dot : trees) {
            int y = dot[0];
            int x = dot[1];

            T[y][x].offer(new Tree(1));
        }
    }

    private static void grow() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                var PQ = T[i][j];
                var newPQ = new PriorityQueue<>(Comparator.comparing((Tree t) -> t.age));

                int dNutrition = 0;
                while (!PQ.isEmpty()) {
                    Tree t = PQ.poll();
                    if (L[i][j] < t.age) {
                        dNutrition += t.age / 2;
                        continue;
                    }

                    L[i][j] -= t.age;
                    t.age += 1;

                    newPQ.offer(t);
                }
                T[i][j] = newPQ;
                L[i][j] += dNutrition;
            }
        }
    }
}