import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] parents;
    static List<int[]> parties;
    static int[] truth;
    static Set<Integer> rTruth;

    private static int find(int x) {
        if (parents[x] == x)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP == bP)
            return;

        if (aP < bP) {
            parents[bP] = aP;
        } else {
            parents[aP] = bP;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        truth = new int[K];
        for (int i = 0; i < K; i++) {
            truth[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }


        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());

            int[] ps = new int[S];
            for (int j = 0; j < S; j++) {
                ps[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            parties.add(ps);
        }

        for (int[] ps : parties) {
            int a = ps[0];
            for (int i = 0; i < ps.length - 1; i++) {
                int b = ps[i + 1];
                union(a, b);
            }
        }

        rTruth = new HashSet<>();
        for (int i = 0; i < K; i++) {
            rTruth.add(find(truth[i]));
        }

        int ret = 0;
        for (int[] ps : parties) {
            boolean isCountable = true;
            for (int p : ps) {
                if (rTruth.contains(find(p))) {
                    isCountable = false;
                    break;
                }
            }
            if (isCountable)
                ret++;
        }

        System.out.println(ret);
    }
}