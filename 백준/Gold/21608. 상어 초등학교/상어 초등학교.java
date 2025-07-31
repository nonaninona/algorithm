import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] likes;
    static Map<Integer, Integer> likeMap;
    static int[][] board;

    static int[] Dy = {-1, 1, 0, 0};
    static int[] Dx = {0, 0, -1, 1};

    static int[][] score;
    static int[] score2;

    static List<int[]> dots;
    static List<int[]> dots2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        likes = new int[N*N][5];
        likeMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                likes[i][j] = Integer.parseInt(st.nextToken());
            likeMap.put(likes[i][0], i);
        }

        for (int stu = 0; stu < N*N; stu++) {
//            System.out.println("stu : " + stu);
//            printBoard();

            score = new int[N][N];
            int max = calcScore1(stu);
            dots = new ArrayList<>();
            setDots(max);
//            printDots(dots);
            if (checkDot(dots, stu)) continue;

            score2 = new int[dots.size()];
            max = calcScore2(dots);
            dots2 = new ArrayList<>();
            setDots2(max);
//            printDots(dots2);
            if (checkDot(dots2, stu)) continue;

            dots2.sort(Comparator.comparingInt((int[] l) -> l[0])
                    .thenComparingInt((int[] l) -> l[1])
            );
            int[] dot = dots2.get(0);
            board[dot[0]][dot[1]] = likes[stu][0];
        }


//        printBoard();

//        System.out.println(likeMap);

        int ret = 0;
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + Dy[k];
                    int nx = j + Dx[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N)
                        continue;

//                    System.out.println(board[i][j]);
                    if (contains(board[ny][nx], likeMap.get(board[i][j])))
                        sum++;
                }
                if(sum == 1)
                    ret += 1;
                else if(sum == 2)
                    ret += 10;
                else if(sum == 3)
                    ret += 100;
                else if(sum == 4)
                    ret += 1000;
            }
        }

        System.out.println(ret);
    }

    private static boolean checkDot(List<int[]> dots, int stu) {
        if (dots.size() == 1) {
            int[] dot = dots.get(0);
            board[dot[0]][dot[1]] = likes[stu][0];
            return true;
        }
        return false;
    }

    private static void printDots(List<int[]> dots) {
        for (int[] dot : dots) {
            System.out.println(Arrays.toString(dot));
        }
        System.out.println();
    }

    private static void printBoard() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static void setDots2(int max) {
        for (int i = 0; i < score2.length; i++)
            if (score2[i] == max)
                dots2.add(new int[]{dots.get(i)[0], dots.get(i)[1]});
    }

    private static int calcScore2(List<int[]> dots) {
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < dots.size(); j++) {
            int[] dot = dots.get(j);
            int y = dot[0];
            int x = dot[1];

            if(board[y][x] != 0)
                continue;

            for (int i = 0; i < 4; i++) {
                int ny = y + Dy[i];
                int nx = x + Dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    continue;

                if (board[ny][nx] == 0)
                    score2[j]++;
            }
            max = Math.max(max, score2[j]);
        }
        return max;
    }

    private static void setDots(int max) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == 0 && score[i][j] == max)
                    dots.add(new int[]{i, j});
    }

    private static int calcScore1(int stu) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != 0)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int ny = i + Dy[k];
                    int nx = j + Dx[k];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                        continue;

                    if (contains(board[ny][nx], stu))
                        score[i][j]++;
                }
                max = Math.max(max, score[i][j]);
            }
        }
        return max;
    }

    private static boolean contains(int student, int stu) {
        for (int i = 1; i < 5; i++) {
            if (student == likes[stu][i])
                return true;
        }
        return false;
    }
}
