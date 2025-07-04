import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String str;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        String max = "";
        int count = 0;
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c == 'K') {
                max += "5" + "0".repeat(count);
                count = 0;
            } else {
                count++;
            }
        }
        max += "1".repeat(count);


        String min = "";
        count = 0;
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c == 'K') {
                if(count >= 1)
                    min += "1" + "0".repeat(count-1);
                min += "5";
                count = 0;
            } else {
                count++;
            }
        }
        if(count >= 1)
            min += "1" + "0".repeat(count-1);


        System.out.println(max);
        System.out.println(min);
    }

}

