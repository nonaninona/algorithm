import java.util.*;
import java.io.*;

public class Main {

    //내 생각엔 트리 깊이랑 관련이 있는 듯
    static List<Integer>[] M;
    static class Node {
        int id;
        int maxD;
        Node parent;
        List<Node> children;
    }
    static int N, S, D;
    static Node[] T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        M = new List[N];
        for(int i=0;i<N;i++)
            M[i] = new ArrayList<>();

        int x, y;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            M[x-1].add(y-1);
            M[y-1].add(x-1);
        }

        T = new Node[N];
        for(int i=0;i<N;i++) {
            Node n = new Node();
            n.id = i;
            n.maxD = 0;
            n.parent = null;
            n.children = new ArrayList<>();
            T[i] = n;
        }

        dfs(null, S-1);
        setDepth(S-1, 1);
        int ans = getAns(S-1, 1);
        System.out.println(ans);
    }

    private static int getAns(int id, int depth) {
        int ret = 0;
        Node cur = T[id];
        List<Node> edges = cur.children;
        for(Node n : edges) {
            if(n.maxD - depth <= D)
                continue;
            ret++;
            ret += getAns(n.id, depth+1);
            ret++;
        }
        return ret;
    }

    private static int setDepth(int id, int depth) {
        int maxRet = depth;
        Node cur = T[id];
        List<Node> edges = cur.children;
        for(Node n : edges) {
            maxRet = Math.max(maxRet, setDepth(n.id, depth + 1));
        }
        return cur.maxD = maxRet;
    }

    private static void dfs(Node p, int id) {
        Node cur = T[id];
        cur.parent = p;
        List<Integer> edges = M[id];
        for(int e : edges) {
            if(p != null && p.id == e)
                continue;
            cur.children.add(T[e]);
            dfs(cur, e);
        }
    }
}