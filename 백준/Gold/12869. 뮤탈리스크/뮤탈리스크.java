import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] health;
    static int ans;
    static boolean[][][] visited;
    static Queue<int[]> Q;
    static List<int[]> perms = new ArrayList<>();
    static int[] value = new int[]{9, 3, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[61][61][61];

        health = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        health[3] = 0;

        getPerms();
//        for(int[] a : perms) {t
//            System.out.println(Arrays.toString(a));
//        }

        Q = new ArrayDeque<>();
        Q.offer(health);
        visited[health[0]][health[1]][health[2]] = true;
        while (!Q.isEmpty()) {
            // 종료 조건
            int[] curH = Q.poll();
//            System.out.println(Arrays.toString(curH));
            if (allDead(curH)) {
                ans = curH[3];
                break;
            }

            for (int[] p : perms) {
                int[] nextH = Arrays.copyOf(curH, 4);

                //p = 1 2 0 => 각 인덱스의 피격 순서
                //pos = 2 0 1 => 순서에 해당하는 숫자의 위치
//                int[] pos = new int[4];
//                for (int i = 0; i < N; i++) {
//                    pos[p[i]] = i;
//                }
//                if (N >= 2) {
//                    if (health[pos[0]] == 0)
//                        continue;
//                    //첫번째는 0이 아니어야 함.
//                }
//                if (N >= 3) {
//                    if (health[pos[2]] != 0 && health[pos[1]] == 0)
//                        continue;
//                    //3번째가 0이 아니면 2번째도 아니어야 함.
//                }

                for (int i = 0; i < N; i++) {
                    nextH[i] = Math.max(0, nextH[i] - value[p[i]]);
                }

                if(visited[nextH[0]][nextH[1]][nextH[2]]) {
//                    System.out.println("visited");
                    continue;
                }

                visited[nextH[0]][nextH[1]][nextH[2]] = true;
                nextH[3]++;
                Q.offer(nextH);

            }
        }

        System.out.println(ans);
    }

    static boolean[] V;
    static int[] p;

    private static void getPerms() {
        V = new boolean[N];
        p = new int[N];
        perm(0);
    }

    //permutation 구하기
    private static void perm(int depth) {
        if (depth == N) {
            perms.add(Arrays.copyOf(p, N));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (V[i])
                continue;
            p[depth] = i;
            V[i] = true;
            perm(depth + 1);
            V[i] = false;
        }
    }

    private static boolean allDead(int[] health) {
        for (int i = 0; i < N; i++) {
            if (health[i] != 0)
                return false;
        }
        return true;
    }


}
