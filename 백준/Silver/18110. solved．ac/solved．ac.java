import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }

        scores.sort((a, b) -> a-b);
        int start = (int) Math.round(N * 0.15);
        int end = (int) (N - Math.round(N * 0.15));

        int result = 0;
        for (int i = start; i < end; i++) {
            result += scores.get(i);
        }
        System.out.println(Math.round((double) result /(end-start)));
    }
}