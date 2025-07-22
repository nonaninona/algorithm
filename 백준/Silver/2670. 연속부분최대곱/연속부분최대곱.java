import java.io.*;

public class Main {

    static int N;
    static double[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new double[N];
        for(int i=0;i<N;i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        double curMax = nums[0];
        double ret = curMax;
        for(int i=1;i<N;i++) {
            curMax = Math.max(curMax * nums[i], nums[i]);
            ret = Math.max(ret, curMax);
        }

        System.out.printf("%.3f", ret);
    }
}