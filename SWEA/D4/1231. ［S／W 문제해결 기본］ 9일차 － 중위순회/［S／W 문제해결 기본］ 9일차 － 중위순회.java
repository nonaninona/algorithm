import java.util.*;
import java.io.*;

class Solution {

    static int N;
    static Node[] nodes = new Node[101];

    static class Node {
        Node left, right;
        char c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=1;i<=100;i++)
            nodes[i] = new Node();
        
        for(int tc=1;tc<=10;tc++){
            N = Integer.parseInt(br.readLine());

            for(int i=1;i<=100;i++) {
                nodes[i].left = null;
                nodes[i].right = null;
                nodes[i].c = '.';
            }

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                nodes[n].c = c;
                if(st.hasMoreTokens()) {
                    int left = Integer.parseInt(st.nextToken());
                    nodes[n].left = nodes[left];
                }
                if(st.hasMoreTokens()) {
                    int right = Integer.parseInt(st.nextToken());
                    nodes[n].right = nodes[right];
                }
            }

            dfs(nodes[1]);

            System.out.printf("#%d %s\n", tc, dfs(nodes[1]));
        }
    }

    public static String dfs(Node n) {
        Node left = n.left;
        Node right = n.right;

        String ret = "";
        if(n.left != null && n.left.c != '.')
            ret += dfs(n.left);
        ret += n.c;
        if(n.right != null && n.right.c != '.')
            ret += dfs(n.right);
        return ret;
    }
}