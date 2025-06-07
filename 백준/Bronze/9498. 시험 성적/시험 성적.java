import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());
        String ret = "";
        if(score >= 90) {
            ret = "A";
        } else if(score >= 80) {
            ret = "B";
        } else if(score >= 70) {
            ret = "C";
        } else if(score >= 60) {
            ret = "D";
        } else {
            ret = "F";
        }

        System.out.println(ret);

    }
}