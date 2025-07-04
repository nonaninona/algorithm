import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String str;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        System.out.println(calc());
    }

    private static int calc() {
        int cursor = 0;
        int num = 0;
        while(true) {
            num++;
            String numStr = String.valueOf(num);
            int size = numStr.length();

            for (int i=0;i<size;i++) {
                if(numStr.charAt(i) == str.charAt(cursor)) {
                    cursor++;
                    if (cursor == str.length())
                        return num;
                }
            }
        }
    }

}

