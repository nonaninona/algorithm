import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<T;i++) {
            int ret = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1)
                    ret += num;
            }
            System.out.println("#" + (i+1) + " " + ret);
        }
    }
}