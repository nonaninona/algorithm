import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = Y*100/X;


        long lo = -1;
        long hi = 1_000_000_001;

        while(lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            long newZ = (Y+mid)*100/(X+mid);

            if(newZ <= Z)
                lo = mid;
            else
                hi = mid;
        }


        if(hi == 1_000_000_001)
            System.out.println(-1);
        else
            System.out.println(hi);

    }
}

