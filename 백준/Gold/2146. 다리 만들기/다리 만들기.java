import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] B;
    static boolean[][] V;
    static Map<Integer, List<int[]>> islands;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        B = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        islands = new HashMap<>();
        V = new boolean[N][N];
        int num = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!V[i][j] && B[i][j] == 1) {
                    islands.put(num, new ArrayList<>());
                    V[i][j] = true;
                    dfs(i, j, num++);
                }
            }
        }

//        for(int key : islands.keySet()) {
//            System.out.println("=".repeat(30));
//            System.out.println(key);
//            for(int[] value : islands.get(key)) {
//                System.out.println(Arrays.toString(value));
//            }
//        }

        int ans = Integer.MAX_VALUE;
        List<Integer> islandNums = new ArrayList<>(islands.keySet());
        int S = islandNums.size();
        for(int i=0;i<S;i++) {
            for(int j=i+1;j<S;j++) {
                List<int[]> srcDots = islands.get(islandNums.get(i));
                List<int[]> trgDots = islands.get(islandNums.get(j));

                for(int[] src : srcDots) {
                    for(int[] trg : trgDots) {
                        int dist = Math.abs(src[0] - trg[0]) + Math.abs(src[1] - trg[1]);
                        ans = Math.min(ans, dist);
                    }
                }
            }
        }

        System.out.println(ans-1);

    }

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, 1, 0, -1};

    private static void dfs(int y, int x, int n) {
        islands.get(n).add(new int[] { y, x });

        int ny, nx;
        for(int i=0;i<4;i++) {
            ny = y + Dy[i];
            nx = x + Dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;
            if(V[ny][nx])
                continue;
            if(B[ny][nx] == 0)
                continue;

            V[ny][nx] = true;
            dfs(ny, nx, n);
        }

    }


}
