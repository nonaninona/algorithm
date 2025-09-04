import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static PriorityQueue<Event> PQ;
    static Atom[] aList;
    static boolean[] V;

    static int U = 0, D = 1, L = 2, R = 3; // U -> y 증가, D -> y 감소

    static class Atom {
        int id;
        int y;
        int x;
        int d;
        int k;

        public Atom(int id, int y, int x, int d, int k) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }

    static class Event {
        int id1;
        int id2;
        int time;

        public Event(int id1, int id2, int time) {
            this.id1 = id1;
            this.id2 = id2;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            aList = new Atom[N];
            PQ = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
            V = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                Atom a = new Atom(i, y, x, d, k);
//                System.out.println(a.id);
                aList[i] = a;
            }

            for (int i = 0; i < N; i++) {
                Atom a = aList[i];
                for (int j = i + 1; j < N; j++) {
//                    System.out.println(i + " " + j + " " + PQ.size());
                    Atom na = aList[j];

                    if (a.x == na.x) {
                        if (a.y < na.y && a.d == U && na.d == D || na.y < a.y && a.d == D && na.d == U) {
                            double time = Math.abs(na.y - a.y) / 2.0;
                            PQ.add(new Event(a.id, na.id, (int) (time * 2)));
                        }
                        continue;
                    }

                    if (a.y == na.y) {
                        if (a.x < na.x && a.d == R && na.d == L || na.x < a.x && a.d == L && na.d == R) {
                            double time = Math.abs(na.x - a.x) / 2.0;
                            PQ.add(new Event(a.id, na.id, (int) (time * 2)));
                        }
                        continue;
                    }

                    if (a.y < na.y) {
                        if (a.x < na.x) {
                            if (a.d == U && na.d == L || a.d == R && na.d == D) {
                                if (Math.abs(a.y - na.y) == Math.abs(a.x - na.x)) {
                                    int time = Math.abs(a.y - na.y);
                                    PQ.add(new Event(a.id, na.id, (time * 2)));
                                }
                            }
                        } else {
                            if (a.d == L && na.d == D || a.d == U && na.d == R) {
                                if (Math.abs(a.y - na.y) == Math.abs(a.x - na.x)) {
                                    int time = Math.abs(a.y - na.y);
                                    PQ.add(new Event(a.id, na.id, (time * 2)));
                                }
                            }
                        }
                    } else {
                        if (a.x < na.x) {
                            if (a.d == R && na.d == U || a.d == D && na.d == L) {
                                if (Math.abs(a.y - na.y) == Math.abs(a.x - na.x)) {
                                    int time = Math.abs(a.y - na.y);
                                    PQ.add(new Event(a.id, na.id, (time * 2)));
                                }
                            }
                        } else {
                            if (a.d == L && na.d == U || a.d == D && na.d == R) {
                                if (Math.abs(a.y - na.y) == Math.abs(a.x - na.x)) {
                                    int time = Math.abs(a.y - na.y);
                                    PQ.add(new Event(a.id, na.id, (time * 2)));
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("size " + PQ.size());

            int curTime = -1;
            Set<Integer> S = new HashSet<>();
            int ans = 0;
            while (!PQ.isEmpty()) {
                Event e = PQ.peek();
//                System.out.println("event : " + e.id1 + " " + e.id2 + " " + e.time);
                if (curTime < e.time) {
                    for (int id : S) {
                        ans += aList[id].k;
                        V[id] = true;
                    }
                    S.clear();
                    curTime = e.time;
                    continue;
                }

                if (curTime == e.time) {
                    PQ.poll();
                    if (!V[e.id1] && !V[e.id2]) {
                        S.add(e.id1);
                        S.add(e.id2);
                    }
                }
            }

            for (int id : S) {
                V[id] = true;
                ans += aList[id].k;
            }

            System.out.printf("#%d %d\n", tc, ans);

        }
    }
}