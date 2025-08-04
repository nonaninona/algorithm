import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;

public class Solution {

    static int N;

    static class Node {
        String operator = "";
        int number = -1;
        int left = -1;
        int right = -1;
    }

    static Node[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<10+1;tc++) {
            N = Integer.parseInt(br.readLine());

            tree = new Node[N+1];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                tree[idx] = new Node();
                String n = st.nextToken();
                if (n.equals("+") || n.equals("-") || n.equals("/") || n.equals("*")) {
                    tree[idx].operator = n;
                } else {
                    tree[idx].number = Integer.parseInt(n);
                }

                int order = 0;
                while (st.hasMoreTokens()) {
                    if (order == 0) {
                        tree[idx].left = Integer.parseInt(st.nextToken());
                        order++;
                    } else {
                        tree[idx].right = Integer.parseInt(st.nextToken());
                    }
                }
            }

            System.out.println("#" + tc + " " + (dfs(1) ? 1 : 0));
        }


    }

    private static boolean dfs(int n) {
        int left = tree[n].left;
        int right = tree[n].right;
        int number = tree[n].number;

//        System.out.println(n + " " + number + " " + left + " " + right);
        if(left == -1 && right == -1) {
//            System.out.println(n + " " + (number == -1));
            return number != -1;
        }

        String oper = tree[n].operator;
        if(left == -1 || right == -1)
            return false;
        if(left != -1)
            if(!dfs(left))
                return false;
        if(right != -1)
            if(!dfs(right))
                return false;

//        System.out.println(n + " " + ret);
        return true;
    }
}