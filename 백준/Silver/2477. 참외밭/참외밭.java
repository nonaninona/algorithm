import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int[][] info;

    public static void main(String[] args) throws FileNotFoundException, Exception {
//		System.setIn(new FileInputStream("Test3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        info = new int[6][2];
        StringTokenizer st;
        for(int i=0;i<6;i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = -1, maxHeightIdx = -1;
        for(int i=0;i<6;i++) {
            if(info[i][0] == 1 || info[i][0] == 2) {
                if(maxWidth < info[i][1]) {
                    maxWidth = info[i][1];
                    maxWidthIdx = i;
                }
            }
            else if(info[i][0] == 3 || info[i][0] == 4) {
                if(maxHeight < info[i][1]) {
                    maxHeight = info[i][1];
                    maxHeightIdx = i;
                }
            }
        }
//		System.out.println(maxWidth + " " + maxHeight + " " + maxWidthIdx + " " + maxHeightIdx);

        int m = 0;

        if((maxWidthIdx + 1)%6 == maxHeightIdx) {
            m = maxHeightIdx;
        } else {
            m = maxWidthIdx;
        }
//		System.out.println(m);
        int smallWidth = info[(m+2)%6][1];
        int smallHeight = info[(m+3)%6][1];
//		System.out.println(smallWidth + " " + smallHeight + " " + ((m+1)%6) + " " + ((m+2)%6));

        System.out.println(K * (maxWidth*maxHeight - smallWidth*smallHeight));
    }
}