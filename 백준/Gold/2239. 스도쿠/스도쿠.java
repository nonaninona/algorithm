import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] board = new int[9][9];
    static List<List<Integer>> blanks = new ArrayList<>();

    private static boolean dfs(int idx) {

        if(idx == blanks.size())
            return true;

        List<Integer> dot = blanks.get(idx);
        int y = dot.get(0);
        int x = dot.get(1);


        for(int i=1;i<10;i++) {
            board[y][x] = i;
            if(!validate(y, x))
                continue;
            if(dfs(idx + 1))
                return true;
            board[y][x] = 0;
        }
        board[y][x] = 0;
        return false;
    }

    private static boolean validate(int y, int x) {
        int[] nums = new int[9];
        for(int i=0;i<9;i++) {
            int num = board[y][i];
            if(num == 0)
                continue;

            nums[num-1]++;
            if(nums[num-1] > 1)
                return false;
        }

        nums = new int[9];
        for(int i=0;i<9;i++) {
            int num = board[i][x];
            if(num == 0)
                continue;

            nums[num-1]++;
            if(nums[num-1] > 1)
                return false;
        }

        nums = new int[9];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                int num = board[(y/3*3)+i][(x/3*3)+j];
                if (num == 0)
                    continue;

                nums[num - 1]++;
                if (nums[num - 1] > 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
                if (board[i][j] == 0)
                    blanks.add(List.of(i, j));
            }
        }


        int idx = 0;
        dfs(idx);

        for(int i=0;i<9;i++) {
            String s = "";
            for(int j=0;j<9;j++)
                s += board[i][j];
            System.out.println(s);
        }


    }
}

