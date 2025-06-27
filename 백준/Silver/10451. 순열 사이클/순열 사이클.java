import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static List<Integer> graph = new ArrayList<>();
    static List<Boolean> visited = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());


            graph = new ArrayList<>();
            visited = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                graph.add(Integer.parseInt(st.nextToken()));
                visited.add(false);
            }

            int count = 0;
            for(int j=1;j<N+1;j++) {
                if(dfs(j))
                    count++;
            }

            System.out.println(count);
        }

    }

    private static boolean dfs(int n) {
        if(visited.get(n-1))
            return false;

        visited.set(n-1, true);
        int target = graph.get(n-1);
        dfs(target);

        return true;
    }
}

