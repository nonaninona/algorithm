import java.util.*;
import java.io.*;

class Solution {

    static int T, H, W, N;
    static int cy, cx;
    static char[][] board;
    static char[] cmds;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];
            for(int i=0;i<H;i++) {
                String row = br.readLine();

                for(int j=0;j<W;j++) {
                    board[i][j] = row.charAt(j);
                    if(board[i][j] == '<' || board[i][j] == '>' || board[i][j] == '^' || board[i][j] == 'v') {
                        cy = i;
                        cx = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String row = br.readLine();
            cmds = new char[N];
            for(int i=0;i<N;i++)
                cmds[i] = row.charAt(i);

            for(int i=0;i<N;i++) {
                char cmd = cmds[i];

                if(cmd == 'U') {
                    board[cy][cx] = '^';

                    int ny = cy - 1; int nx = cx;
                    if(ny < 0)
                        continue;
                    if(board[ny][nx] == '.') {
                        board[ny][nx] = board[cy][cx];
                        board[cy][cx] = '.';
                        cy = ny;
                    }
                } else if(cmd == 'D') {
                    board[cy][cx] = 'v';

                    int ny = cy + 1; int nx = cx;
                    if(ny >= H)
                        continue;
                    if(board[ny][nx] == '.') {
                        board[ny][nx] = board[cy][cx];
                        board[cy][cx] = '.';
                        cy = ny;
                    }
                } else if(cmd == 'L') {
                    board[cy][cx] = '<';

                    int ny = cy; int nx = cx - 1;
                    if(nx < 0)
                        continue;
                    if(board[ny][nx] == '.') {
                        board[ny][nx] = board[cy][cx];
                        board[cy][cx] = '.';
                        cx = nx;
                    }
                } else if(cmd == 'R') {
                    board[cy][cx] = '>';

                    int ny = cy; int nx = cx + 1;
                    if(nx >= W)
                        continue;
                    if(board[ny][nx] == '.') {
                        board[ny][nx] = board[cy][cx];
                        board[cy][cx] = '.';
                        cx = nx;
                    }
                } else if(cmd == 'S') {
                    int dy = 0, dx = 0;
                    if(board[cy][cx] == '^')
                        dy = -1;
                    else if(board[cy][cx] == 'v')
                        dy = 1;
                    else if(board[cy][cx] == '>')
                        dx = 1;
                    else if(board[cy][cx] == '<')
                        dx = -1;

                    int ny = cy + dy;
                    int nx = cx + dx;
                    while(!(ny < 0 || nx < 0 || ny >= H || nx >= W)) {
//                        System.out.println(ny + " " + nx);
//                        System.out.println(board[ny][nx]);
                        if(board[ny][nx] == '#')
                            break;
                        if(board[ny][nx] == '*') {
                            board[ny][nx] = '.';
                            break;
                        }

                        ny += dy;
                        nx += dx;
//                        System.out.println(!(ny < 0 || nx < 0 || ny >= H || nx >= W));
                    }
                }

//                for(int j=0;j<H;j++)
//                    System.out.println(Arrays.toString(board[j]));
//                System.out.println();
            }

            System.out.printf("#%d ", tc);
            for(int i=0;i<H;i++)
                System.out.println(new String(board[i]));
        }


    }
}