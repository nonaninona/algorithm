import java.util.*;
import java.io.*;

public class Main {

    static int T, M;
    static PriorityQueue<Integer> min, max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            M = Integer.parseInt(br.readLine());

            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Comparator.reverseOrder());

            sb.append((M+1) / 2).append("\n");
            for(int i=0;i<M;i++) {
                if(i%10 == 0)
                    st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());

                if(max.isEmpty()) {
                    max.offer(num);
                } else {
                    max.offer(num);
                    if (max.size() - min.size() > 1) {
                        min.offer(max.poll());
                    }

                    while (max.peek() > min.peek()) {
                        int temp = max.poll();
                        max.offer(min.poll());
                        min.offer(temp);
                    }
                }

                if(i%2 == 0) {
                    sb.append(max.peek()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}