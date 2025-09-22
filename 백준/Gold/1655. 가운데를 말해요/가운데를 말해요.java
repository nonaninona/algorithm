import java.io.*;
import java.util.*;

class Main {

    static PriorityQueue<Integer> min, max;
    static int N;

    public static void main(String[] args) throws Exception {
        min = new PriorityQueue<>(Comparator.naturalOrder());
        max = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
//            System.out.println("ans : " + max.peek());
//            printMax();
//            printMin();
//            System.out.println("=".repeat(30));

            int num = Integer.parseInt(br.readLine());
            if(max.size() == min.size()) {
                max.offer(num);
            } else {
                min.offer(num);
            }

            Integer left = max.peek();
            Integer right = min.peek();
            if(!min.isEmpty() && right < left) {
                int maxNum = max.poll();
                int minNum = min.poll();
                max.offer(minNum);
                min.offer(maxNum);
            }

            System.out.println(max.peek());
        }
    }

    private static void printMax() {
        PriorityQueue<Integer> newMax = new PriorityQueue<>(Comparator.reverseOrder());
        while(!max.isEmpty()) {
            int num = max.poll();
            System.out.print(num + " ");
            newMax.offer(num);
        }
        System.out.println();
        max = newMax;
    }

    private static void printMin() {
        PriorityQueue<Integer> newMin = new PriorityQueue<>(Comparator.naturalOrder());
        while(!min.isEmpty()) {
            int num = min.poll();
            System.out.print(num + " ");
            newMin.offer(num);
        }
        System.out.println();
        min = newMin;
    }


}