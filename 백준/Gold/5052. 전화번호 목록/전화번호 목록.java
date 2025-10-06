import java.io.*;
import java.util.*;

class Main {

    static int T, N;
    static String[] numbers;

    static class Node {
        boolean isEnd = false;
        Node[] children = new Node[10];
    }

    public static boolean insert(Node root, String num) {
        boolean ret = false;

        Node cur = root;
        for(int i=0;i<num.length();i++) {
            if(cur.isEnd)
                ret = true;
            char c = num.charAt(i);
            if(cur.children[c-'0'] == null) {
                Node next = new Node();
                cur.children[c-'0'] = next;
                cur = next;
            } else {
                cur = cur.children[c - '0'];
            }
        }
        cur.isEnd = true;

        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];
            for(int i=0;i<N;i++)
                numbers[i] = br.readLine();
            Arrays.sort(numbers);

            Node root = new Node();
            boolean ret = false;
            for(String num : numbers) {
                if(insert(root, num)) {
                    ret = true;
                    break;
                }
            }

            if(ret)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
