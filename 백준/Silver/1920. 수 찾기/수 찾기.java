import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, Boolean> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            map.put(st.nextToken(), true);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            System.out.println((map.containsKey(st.nextToken())?1:0));
        }
    }
}