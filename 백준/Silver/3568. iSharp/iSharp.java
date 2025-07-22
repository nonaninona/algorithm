import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        for (int i = 1; i < tokens.length; i++) {
            String target = tokens[i].strip()
                    .replace(",", "")
                    .replace(";", "");

            int idx = -1;
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if (c == '[' || c == '*' || c == '&') {
                    idx = j;
                    break;
                }
            }
            if (idx == -1)
                idx = target.length();

            String vName = target.substring(0, idx);
            StringBuilder type = new StringBuilder(target
                    .substring(idx)
                    .strip()
                    .replace("]", "|")
                    .replace("[", "]")
                    .replace("|", "[")
            ).reverse();

            System.out.println(tokens[0] + type + " " + vName + ";");
        }

    }
}