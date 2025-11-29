import java.io.*;
import java.util.*;

class Main {

    static class Node {
        public Node(int id) {
            this.id = id;
            this.parent = null;
            this.children = new ArrayList<>();
            this.depth = 0;
        }

        int id;
        Node parent;
        List<Node> children;
        int depth;
    }

    static int N, M;
    static Node[] tree;
    static List[] G;

    static int dp[][];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        G = new List[N+1];
        for(int i=1;i<N+1;i++)
            G[i] = new ArrayList<>();

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
            G[b].add(a);
        }

        tree = new Node[N+1];
        for(int i=1;i<N+1;i++) {
            tree[i] = new Node(i);
        }

        V = new boolean[N+1];
        dp = new int[N+1][18];

        V[1] = true;
        tree[1].depth = 0;
        dp[1][0] = 0;
        makeTree(1, -1, 0);

//        for(int i=0;i<N;i++) {
//            System.out.println(tree[i].id + " " + (tree[i].parent == null ? "null" : tree[i].parent.id) + " " + Arrays.toString(tree[i].children.stream().mapToInt(c -> c.id).toArray()));
//        }

        for(int i=1;i<18;i++) {
            for(int j=1;j<N+1;j++) {
                int newJ = dp[j][i-1];
                if(newJ != 0)
                    dp[j][i] = dp[newJ][i-1];
            }
        }


        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.println(sb);
    }

    private static int lca(int a, int b) {
        Node na = tree[a];
        Node nb = tree[b];

        if(a == b)
            return a;

        if(na.depth > nb.depth) {
            int diff = na.depth - nb.depth;

            for(int i=17;i>=0;i--) {
                int filter = 1 << i;
                if((diff & filter) != 0) {
                    diff -= filter;
                    a = dp[a][i];
                }
            }

            if(a == b)
                return a;

            for(int i=17;i>=0;i--) {
                if(dp[a][i] != dp[b][i]) {
                    a = dp[a][i];
                    b = dp[b][i];
                }
            }

            return dp[a][0];
        } else if(na.depth < nb.depth) {
            int diff = nb.depth - na.depth;

            for(int i=17;i>=0;i--) {
                int filter = 1 << i;
                if((diff & filter) != 0) {
                    diff -= filter;
                    b = dp[b][i];
                }
            }


            if(a == b)
                return a;

            for(int i=17;i>=0;i--) {
                if(dp[a][i] != dp[b][i]) {
                    a = dp[a][i];
                    b = dp[b][i];
                }
            }

            return dp[a][0];
        } else {
            for(int i=17;i>=0;i--) {
                if(dp[a][i] != dp[b][i]) {
                    a = dp[a][i];
                    b = dp[b][i];
                }
            }

            return dp[a][0];
        }
    }

    static boolean[] V;

    public static void makeTree(int n, int p, int d) {
        if(p != -1) {
            tree[n].parent = tree[p];
            tree[p].children.add(tree[n]);
            tree[n].depth = d;
            dp[n][0] = p;
        }

        List<Integer> edges = G[n];
        for(int e : edges) {
            if(V[e]) continue;
            V[e] = true;
            makeTree(e, n, d+1);
        }
    }

}
