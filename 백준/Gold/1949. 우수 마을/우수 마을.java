import java.io.*;
import java.util.*;

class Main {

    static int N;
    static List<Integer>[] G;
    static Node[] tree;
    static int[][] dp;

    static class Node {
        int id;
        int people;
        List<Node> children = new ArrayList<>();
        Node parent;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        G = new List[N+1];
        for(int i=1;i<=N;i++)
            G[i] = new ArrayList<>();
        tree = new Node[N+1];
        for(int i=1;i<=N;i++)
            tree[i] = new Node();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            tree[i].id = i;
            tree[i].people = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            G[u].add(v);
            G[v].add(u);
        }

        setTree(null, 1);

        dp = new int[N+1][2];
        for(int i=1;i<=N;i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        //그냥 합만 출력하면 되네 최소 최대 없이...
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int n) {
        if(dp[n][0] != -1 && dp[n][1] != -1)
            return;
        Node node = tree[n];
        if(node.children.isEmpty()) {
            dp[n][0] = 0;
            dp[n][1] = node.people;
            return;
        }

        for(Node c : node.children)
            dfs(c.id);

        //내가 우수가 아니면
        //자식 중 하나는 우수여야 함.
        int sum = 0;
        for(Node c : node.children)
            sum += Math.max(dp[c.id][0], dp[c.id][1]);
        dp[n][0] = sum;

        dp[n][1] = node.people; //내가 우수면
        //자식들이 모두 우수가 아니여야 함
        for(Node c : node.children)
            dp[n][1] += dp[c.id][0];
    }

    private static void setTree(Node parent, int n) {
        tree[n].parent = parent;
        for(int e : G[n]) {
            if(parent != null && e == parent.id) continue;
            tree[n].children.add(tree[e]);
            setTree(tree[n], e);
        }
    }
}