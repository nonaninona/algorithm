import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        nums = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ret = 1;
        int count = 1;
        int prevD = 0;
//        System.out.println(count);

        if(M > 1) {
            int curD = nums[1] - nums[0];
            if(curD == 0) {
                count = 1;
            } else {
                count = 2;
            }
            prevD = curD;
            ret = Math.max(ret, count);
        }
//        System.out.println(count);

        for(int i=2;i<M;i++) {
            int curD = nums[i] - nums[i-1];
            if(0 < curD) {
                if(0 < prevD) {
                    count++;
                } else {
                    count = 2;
                }
            } else if(curD < 0) {
                if(prevD < 0) {
                    count++;
                } else {
                    count = 2;
                }
            }

//            System.out.println(count);

            ret = Math.max(ret, count);

            if(curD != 0)
                prevD = curD;
        }

        System.out.println(ret);
    }
}