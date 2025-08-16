import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static List<Integer> L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = 10;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            L = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                L.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                String oper = st.nextToken();
                if(oper.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0;j<y;j++) {
                        int s = Integer.parseInt(st.nextToken());
                        L.add(x+j, s);
                    }
                } else if(oper.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0;j<y;j++) {
                        L.remove(x);
                    }

                } else if(oper.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0;j<y;j++) {
                        int s = Integer.parseInt(st.nextToken());
                        L.add(s);
                    }
                }
            }

            System.out.printf("#%d ", tc);
            for(int i=0;i<10;i++)
                System.out.printf("%d ", L.get(i));
            System.out.println();
        }
    }

}