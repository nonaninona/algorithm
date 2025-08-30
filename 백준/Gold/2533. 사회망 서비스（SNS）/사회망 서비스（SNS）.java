import java.io.*;
import java.util.*;

class Main {

    static int N;
    static List<Integer>[] G = new List[1_000_001];
    static Node[] nodes = new Node[1_000_001];
    static int[][] dp = new int[1_000_001][2];

    static class Node {
        List<Node> children = new ArrayList<>();
        Node parent = null;
        int id = -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= 1_000_000; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
            G[i] = new ArrayList<>();
        }

        int rootIdx = -1;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            G[u].add(v);
            G[v].add(u);
//            nodes[v].parent = nodes[u];
//            nodes[u].children.add(nodes[v]);
            rootIdx = v;
        }
        setTree(null, rootIdx);

        for (int i = 1; i <= 1_000_000; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        int ret1 = dfs(nodes[rootIdx], false);
        int ret2 = dfs(nodes[rootIdx], true);
        System.out.println(Math.min(ret1, ret2));
    }

    private static void setTree(Node p, int n) {
        nodes[n].parent = p;
        for(int e : G[n]) {
            if(p != null && e == p.id) continue;
            nodes[n].children.add(nodes[e]);
            setTree(nodes[n], e);
        }
    }

    private static int dfs(Node n, boolean isEA) {
//        System.out.println(n.id + " " + isEA);
        int tfIdx = isEA ? 0 : 1;
        if (dp[n.id][tfIdx] != -1)
            return dp[n.id][tfIdx];

        int ret = 0;
        if (isEA) {
            ret++;
            for (Node child : n.children) {
                ret += Math.min(dfs(child, false), dfs(child, true));
            }
            dp[n.id][0] = ret;
        } else {
            for (Node child : n.children) {
                ret += dfs(child, true);
            }
            dp[n.id][1] = ret;
        }

        return ret;
    }
}