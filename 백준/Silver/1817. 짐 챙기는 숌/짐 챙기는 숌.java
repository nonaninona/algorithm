import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(0);
        } else {

            int[] books = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                books[i] = Integer.parseInt(st.nextToken());
            }

            int box = 0;
            int cur = 0;
            for (int i = 0; i < N; i++) {
                if (cur + books[i] > M) {
                    box += 1;
                    cur = books[i];
                    continue;
                }

                cur += books[i];
            }
            if (cur > 0)
                box += 1;

            System.out.println(box);
        }
    }
}

