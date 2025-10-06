import java.io.*;
import java.util.*;

class Main {

    static int T, N;
    static String[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];
            for(int i=0;i<N;i++)
                numbers[i] = br.readLine();
            Arrays.sort(numbers);

            boolean ret = false;
            for(int i=0;i<N-1;i++) {
                if(compare(numbers[i], numbers[i+1])) {
                    ret = true;
                    break;
                }
            }

            if(ret)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

    public static boolean compare(String n1, String n2) {
        for(int i=0;i<Math.min(n1.length(), n2.length());i++) {
            if(n1.charAt(i) != n2.charAt(i))
                return false;
        }
        return true;
    }


}
