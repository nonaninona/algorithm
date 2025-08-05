import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, Integer> map1;
    static Map<Integer, String> map2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for(int i=0;i<N;i++) {
            String name = br.readLine();
            map1.put(name, i+1);
            map2.put(i+1, name);
        }

        for(int i=0;i<M;i++) {
            String name = br.readLine();
            if('0' <= name.charAt(0) && name.charAt(0) <= '9')
                System.out.println(map2.get(Integer.parseInt(name)));
            else
                System.out.println(map1.get(name));
        }
    }
}