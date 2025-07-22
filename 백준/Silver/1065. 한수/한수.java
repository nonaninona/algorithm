import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int num=1;num<=N;num++) {
            String numStr = String.valueOf(num);

            if(numStr.length() == 1) {
                cnt++;
                continue;
            }

            int diff = numStr.charAt(1) - numStr.charAt(0);
            boolean isCnt = true;
            for(int i=2;i<numStr.length();i++) {
                if(diff != numStr.charAt(i) - numStr.charAt(i-1)) {
                    isCnt = false;
                    break;
                }
            }

            if(isCnt)
                cnt++;
        }

        System.out.println(cnt);

    }
}