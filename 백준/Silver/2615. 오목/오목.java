import java.util.*;
import java.io.*;

class Main {
	static final int MAX_SIZE = 19;
	static int[][] matrix;
	static int[][][] count;

	// 오른쪽, 오른쪽 대각선, 아래, 왼쪽 대각선 탐색
	static final int[] dx = { 1, 1, 0, -1 };
	static final int[] dy = { 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		matrix = new int[MAX_SIZE + 2][MAX_SIZE + 2];
		count = new int[MAX_SIZE + 2][MAX_SIZE + 2][4];

		for (int i = 1; i < MAX_SIZE + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < MAX_SIZE + 1; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        //왜 이부분을 열 우선 탐색으로 해야 돌아가나요?
		for (int j = 1; j < MAX_SIZE + 1; j++) {
			for (int i = 1; i < MAX_SIZE + 1; i++) {
				if (matrix[i][j] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						if (count[i][j][dir] == 0 && updateCount(i, j, dir) == 5) {
							System.out.printf("%d\n%d %d\n", matrix[i][j], i, j);
							return;
						}
					}
				}
			}
		}

		System.out.println("0");
	}

	static int updateCount(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (matrix[nx][ny] == matrix[x][y]) {
			return count[nx][ny][dir] = updateCount(nx, ny, dir) + 1;
		}
		return 1;
	}
}