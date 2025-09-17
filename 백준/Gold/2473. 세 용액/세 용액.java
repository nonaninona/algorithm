import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static long ans;
    static List<Integer> ansList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

//        System.out.println(Arrays.toString(A));

        ans = Long.MAX_VALUE;
        ansList = new ArrayList<>();
        for(int i=0;i<N;i++) {
            find(i);
        }

        ansList.sort(Comparator.naturalOrder());
        for(int n : ansList) {
            System.out.printf("%d ", n);
        }
    }

    private static void find(int i) {
        int left = 0;
        int right = N-1;

        while(true) {
//            System.out.println("left " + left);
//            System.out.println("right " + right);
//            System.out.println("i " + i);
            if(left == i)
                left++;
            if(right == i)
                right--;

            if(left >= right)
                break;

            long sum = (long) A[left] + A[right] + A[i];
            if(Math.abs(sum) < Math.abs(ans)) {
                ans = Math.abs(sum);
                ansList.clear();
                ansList.add(A[left]);
                ansList.add(A[right]);
                ansList.add(A[i]);
            }

            if(sum < 0)
                left++;
            else
                right--;
        }
    }


}
