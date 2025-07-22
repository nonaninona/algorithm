import java.io.*;

public class Main {

    static int T;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String s = br.readLine();
            System.out.println(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length()-1)));
        }
    }
}