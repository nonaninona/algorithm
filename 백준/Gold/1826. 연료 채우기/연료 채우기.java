import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static List<List<Integer>> gasStation = new ArrayList<>();
    static int L, P;
    static PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(Comparator.comparingInt(list -> list.get(1) * -1));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gasDist = Integer.parseInt(st.nextToken());
            int gasAmount = Integer.parseInt(st.nextToken());
            gasStation.add(List.of(gasDist, gasAmount));
        }

        gasStation = gasStation.stream().sorted((listA, listB) -> listA.get(0) - listB.get(0)).collect(Collectors.toList());
//        System.out.println(gasStation);

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        System.out.println(calc());

    }

    private static int calc() {
        int nextStartIdx = 0;
        int ret = 0;
        while (P < L) {

            for (int i = nextStartIdx; i < N; i++) {
                if (gasStation.get(i).get(0) <= P) {
                    queue.offer(List.of(gasStation.get(i).get(0), gasStation.get(i).get(1)));
                    nextStartIdx = i + 1;
                }
            }

            if(queue.isEmpty())
                return -1;

//            System.out.println(queue);
            List<Integer> station = queue.poll();
            P += station.get(1);
//            System.out.println(P);
            ret++;
        }
        return ret;
    }
}