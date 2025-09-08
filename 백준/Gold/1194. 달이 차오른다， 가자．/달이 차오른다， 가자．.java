import java.io.*;
import java.util.*;

public class Main {

    // 열쇠에 도달하면 다시 bfs
    // 현재 열쇠 보유 상황이 중요?
    // 열쇠 개수+1(0에서 시작) * 2의 6승(열쇠보유상황) * NM(bfs)
    // ? * 64 * 2,500 = ? * 160,000 <= 2500 * 160,000 = 400,000,000
    // 흠..

    // 키 리스트, 키 보유 상황
    // 0에서 키 보유 상황 없음 상태에서, 키들 + 1을 향해 향해 진행
    // 키나 1을 만나면, 거기서부터 내가 가지지 않은 키들 + 1을 향해 진행

    // 메모리 초과?
    // 2의 6승 x 2500인디... = 160,000 byte = 160kb

    static int N, M;
    static char[][] board;
    static Queue<int[]> Q;
    static int sy, sx;

    static int[] Dy = {-1, 0, 1, 0};
    static int[] Dx = {0, -1, 0, 1};

    static boolean[][][] V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
//                System.out.println(board[i][j]);
                if (board[i][j] == '0') {
                    sy = i;
                    sx = j;
                }
            }
        }
        V = new boolean[N][M][1 << 7];

        System.out.println(bfs());
    }

    public static int bfs() {
        Q = new ArrayDeque<>();
        V[sy][sx][0] = true;
        Q.offer(new int[]{sy, sx, 0, 0});

        while (!Q.isEmpty()) {
            int[] node = Q.poll();
            int y = node[0];
            int x = node[1];
            int v = node[2];
            int d = node[3];
//            System.out.println(y + " " + x + " " + v + " " + d);

            for (int i = 0; i < 4; i++) {
                int ny = y + Dy[i], nx = x + Dx[i];

                // 범위 나가거나, 이미 방문했거나, 벽이거나, 도착이면 끝
                if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;

                char c = board[ny][nx];
                if (c == '#')
                    continue;
                if (c == '1')
                    return d + 1;

                // 열쇠라면 상태 변경
                int newV = v;
                if ('a' <= c && c <= 'f')
                    newV = v | (1 << (c - 'a'));

                // 방문 체크
                if (V[ny][nx][newV])
                    continue;

                // 문인데, 열쇠가 없는 경우 끝
                if ('A' <= c && c <= 'F' && (newV & (1 << (c - 'A'))) == 0)
                    continue;

                V[ny][nx][newV] = true;
                Q.offer(new int[]{ny, nx, newV, d+1});
            }


        }

        return -1;
    }

}