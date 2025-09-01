import java.io.*;
import java.util.*;

public class Main {

    static int N, R, Q;
    static List<Integer>[] G;
    static Node[] nodes;
    static int[] dp;

    static class Node {
        int id;
        Node parent;
        List<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        G = new List[N+1];
        nodes = new Node[N+1];
        for(int i=1;i<=N;i++) {
            G[i] = new ArrayList<>();
            nodes[i] = new Node();
            nodes[i].id = i;
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            G[u].add(v);
            G[v].add(u);
        }

        setTree(R, null);

        dp = new int[N+1];
        Arrays.fill(dp, -1);
        dfs(R);

        for(int i=0;i<Q;i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(dp[q]);
        }
    }

    private static int dfs(int n) {
//        System.out.println("node : " + n);
//        System.out.println(nodes[n].children.size());

        if(dp[n] != -1)
            return dp[n];

        int ret = 1;
        for(Node c: nodes[n].children)
            ret += dfs(c.id);

        return dp[n] = ret;
    }

    private static void setTree(int n, Node p) {
//        System.out.println(n);
        Node node = nodes[n];
//        System.out.println(G[n]);
        for(int e : G[n]) {
            if(p != null && p.id == e)
                continue;
            nodes[e].parent = node;
            node.children.add(nodes[e]);
            setTree(e, node);
        }
    }

}