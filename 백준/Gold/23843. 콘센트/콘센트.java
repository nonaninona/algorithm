import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static Integer[] T;
    static int[] charger;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        T = new Integer[N];
        for(int i=0;i<N;i++)
            T[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(T, Comparator.reverseOrder());

        charger = new int[M];

        if(N <= M) {
            int ret = Integer.MIN_VALUE;
            for(int t : T)
                ret = Math.max(ret, t);
            System.out.println(ret);
            return;
        }

        for(int i=0;i<M;i++)
            charger[i] = T[i];

        long ans = getAns();

        int max = getMax();
        ans += max;
        System.out.println(ans);
    }

    private static long getAns() {
        long ans = 0;
        int next = M;
        List<Integer> zeroIdx = new ArrayList<>();
        while(true) {
            int min = getMin();
            ans += min;
            for(int i=0;i<M;i++) {
                charger[i] -= min;
                if(charger[i] == 0)
                    zeroIdx.add(i);
            }

            for(int idx: zeroIdx) {
                charger[idx] = T[next++];
                if(next == N) {
                    return ans;
                }
            }
            zeroIdx.clear();
        }
    }

    private static int getMax() {
        int ret = Integer.MIN_VALUE;
        for(int c : charger) {
            if(c == 0)
                continue;
            ret = Math.max(ret, c);
        }
        return ret;
    }

    private static int getMin() {
        int ret = Integer.MAX_VALUE;
        for(int c : charger) {
            if(c == 0)
                continue;
            ret = Math.min(ret, c);
        }
        return ret;
    }


}
