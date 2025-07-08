import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
            B[i] = Integer.parseInt(st.nextToken());


        int aStart = 0;
        int bStart = 0;
        List<Integer> ret = new ArrayList<>();

        int i = 100;
        while(i>=1) {

            int as = checkA(i, aStart);
            int bs = checkB(i, bStart);

//            System.out.println("i " + i);
//            System.out.println("as " + as);
//            System.out.println("bs " + bs);

            if(as == -1 || bs == -1) {
                i--;
                continue;
            }

            aStart = as;
            bStart = bs;
            ret.add(i);
        }

        System.out.println(ret.size());
        for(int n : ret)
            System.out.print(n + " ");

    }

    private static int checkA(int target, int start) {
        for(int i=start;i<N;i++) {
            if(A[i] == target)
                return i+1;
        }
        return -1;
    }
    private static int checkB(int target, int start) {
        for(int i=start;i<M;i++) {
            if(B[i] == target)
                return i+1;
        }
        return -1;
    }
}