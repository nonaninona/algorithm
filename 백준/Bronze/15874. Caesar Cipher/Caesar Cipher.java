import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()) % 26;

        StringBuilder builder = new StringBuilder();
        String str = br.readLine();

        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c == '.' || c == ',' || c == ' ')
                builder.append(c);
            else if(97 <= c)
                builder.append((char)((c - 97 + k) % 26 + 97));
            else
                builder.append((char)((c - 65 + k) % 26 + 65));
        }

        System.out.println(builder);
    }
}