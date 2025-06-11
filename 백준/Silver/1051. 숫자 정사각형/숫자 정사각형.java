import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for(int i=0;i<N;i++) {
            String[] row = br.readLine().split("");
//            System.out.println(Arrays.toString(row));
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        int ret = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int max = Math.max(N, M);
                for(int s=0;s<max;s++) {
//                    System.out.println(i + " " + j + " " + s);
                    if(M <= j+s || N <= i+s)
                        break;

                    if(board[i][j] == board[i][j+s] && board[i][j] == board[i+s][j] && board[i][j] == board[i+s][j+s])
                        ret = Math.max(ret, (s+1)*(s+1));
                }
            }
        }

        System.out.println(ret);
    }
}

