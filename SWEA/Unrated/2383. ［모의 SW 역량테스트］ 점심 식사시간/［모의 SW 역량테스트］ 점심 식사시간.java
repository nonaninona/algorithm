import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static PriorityQueue<int[]> PQ1, PQ2;
    static int y1, y2, x1, x2, s1, s2;
    static List<int[]> P;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());

            y1 = -1;
            P = new ArrayList<>();
            M = 0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    if(b == 1) {
                        P.add(new int[]{i, j});
                        M++;
                    } else if(b >= 2) {
                        if(y1 == -1) {
                            y1 = i;
                            x1 = j;
                            s1 = b;
                        } else {
                            y2 = i;
                            x2 = j;
                            s2 = b;
                        }
                    }
                }
            }

            PQ1 = new PriorityQueue<>(Comparator.comparing((int[] l) -> l[0]).thenComparing((int[] l) -> -1 * l[1]));
            PQ2 = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? -1 * (o1[1] - o2[1]) : o1[0]-o2[0]);

            ans = Integer.MAX_VALUE;
            subset(0, new ArrayList<>(), new ArrayList<>());

            System.out.printf("#%d %d\n", tc, ans);
        }


    }

    private static void subset(int depth, List<int[]> first, List<int[]> second) {
        if(depth == M) {
            int ret = calc(first, second);
            ans = Math.min(ans, ret);
            return;
        }

        List<int[]> newFirst = new ArrayList<>(first);
        int[] coor1 = P.get(depth);
        int dist1 = getDist(coor1, y1, x1);
        newFirst.add(new int[] { dist1, 1 }); // 1 - 도착, 2 - 입장, 3 - 퇴장
        subset(depth+1, newFirst, new ArrayList<>(second));

        List<int[]> newSecond = new ArrayList<>(second);
        int[] coor2 = P.get(depth);
        int dist2 = getDist(coor2, y2, x2);
        newSecond.add(new int[] { dist2, 1 });
        subset(depth+1, new ArrayList<>(first), newSecond);
    }

    private static int getDist(int[] coor, int y, int x) {
        return Math.abs(y - coor[0]) + Math.abs(x - coor[1]);
    }

    private static int calc(List<int[]> first, List<int[]> second) {
        for(int[] f : first)
            PQ1.offer(f);
        for(int[] s : second)
            PQ2.offer(s);

        int ret1 = 0;
        int vacant1 = 3;
        while(!PQ1.isEmpty()) {
            int[] node = PQ1.poll();
            int time = node[0];
            int cmd = node[1];

            if(cmd == 1) {
                PQ1.offer(new int[] { time+1, 2 });
            } else if(cmd == 2) {
                if(vacant1 > 0) {
                    vacant1--;
                    PQ1.offer(new int[] { time+s1, 3 });
                } else {
                    PQ1.offer(new int[] { time+1, 2 });
                }
            } else if(cmd == 3) {
                vacant1++;
            }

            ret1 = time;
        }

        int ret2 = 0;
        int vacant2 = 3;
        while(!PQ2.isEmpty()) {
            int[] node = PQ2.poll();
            int time = node[0];
            int cmd = node[1];

            if(cmd == 1) {
                PQ2.offer(new int[] { time+1, 2 });
            } else if(cmd == 2) {
                if(vacant2 > 0) {
                    vacant2--;
                    PQ2.offer(new int[] { time+s2, 3 });
                } else {
                    PQ2.offer(new int[] { time+1, 2 });
                }
            } else if(cmd == 3) {
                vacant2++;
            }

            ret2 = time;
        }

        return Math.max(ret1, ret2);
    }
}