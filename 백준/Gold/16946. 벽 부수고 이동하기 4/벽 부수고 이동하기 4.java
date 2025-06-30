import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map = null;
    static boolean[][] visited = null;
    static int[][] areaMap = null;
    static List<Integer> areas = new ArrayList<>();
    static int[][] ret = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        areaMap = new int[N][M];

        for(int i=0;i<N;i++) {
            String row = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        areas.add(-1);
        int order = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    int area = dfs(i, j, order);
                    if (area == -1)
                        continue;
                    areas.add(area);
                    order++;
                }
            }
        }

//        for(int i=0;i<N;i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }
//
//        for(int i=0;i<N;i++) {
//            System.out.println(Arrays.toString(areaMap[i]));
//        }
//
//        System.out.println(area);

        ret = new int[N][M];
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 1) {
                    int a = calc(i, j);
                    ret[i][j] = a % 10;
                }
                builder.append(ret[i][j]);
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    private static int calc(int y, int x) {
//        System.out.println(y + " " + x);

        Set<Integer> s = new HashSet<>();
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(areaMap[ny][nx] == 0)
                continue;
            s.add(areaMap[ny][nx]);
        }

        int ret = 1;
        for (int a : s)
            ret += areas.get(a);
        return ret;
    }

    private static int dfs(int y, int x, int o) {
//        System.out.println(y + " " + x);
        if(visited[y][x])
            return -1;

        visited[y][x] = true;
        areaMap[y][x] = o;

        int ret = 1;
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if(map[ny][nx] == 1)
                continue;
            if(visited[ny][nx])
                continue;
            ret += dfs(ny, nx, o);
        }

        return ret;
    }
}

