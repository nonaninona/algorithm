import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int q1 = 0, q2 = 0, q3 = 0, q4 = 0, axis = 0;

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == 0 || y == 0)
                axis++;
            else if(x > 0 && y > 0)
                q1++;
            else if(x < 0 && y > 0)
                q2++;
            else if(x < 0 && y < 0)
                q3++;
            else
                q4++;
        }

        System.out.println("Q1: " + q1);
        System.out.println("Q2: " + q2);
        System.out.println("Q3: " + q3);
        System.out.println("Q4: " + q4);
        System.out.println("AXIS: " + axis);
    }
}