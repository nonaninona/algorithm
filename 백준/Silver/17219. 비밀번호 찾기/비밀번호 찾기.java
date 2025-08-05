import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, String> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String pw = st.nextToken();
            map.put(name, pw);
        }

        for(int i=0;i<M;i++) {
            String name = br.readLine();
            System.out.println(map.get(name));
        }
    }
}