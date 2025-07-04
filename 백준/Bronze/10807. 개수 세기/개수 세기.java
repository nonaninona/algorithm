import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());

        V = Integer.parseInt(br.readLine());
        int count = 0;
        for(int num : nums) {
            if(num == V)
                count++;
        }

        System.out.println(count);
    }

}

