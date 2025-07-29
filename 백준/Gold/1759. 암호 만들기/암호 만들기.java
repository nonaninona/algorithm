import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static List<String> moList = new ArrayList<>(List.of("a", "e", "i", "o", "u"));
    static String[] chars;
    static String[] ans;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);

//        System.out.println(Arrays.toString(chars));
        ans = new String[L];
        dfs(0, 0);
        System.out.println(builder);
    }

    public static void dfs(int depth, int start) {
        if(depth == L) {
            if(checkAns()) {
                toStr();
            }
            return;
        }

        for(int i=start;i<C;i++) {
            ans[depth] = chars[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static void toStr() {
        for(int i=0;i<L;i++)
            builder.append(ans[i]);
        builder.append("\n");
    }

    private static boolean checkAns() {
        int jaCount = 0;
        int moCount = 0;
        for(int i=0;i<L;i++) {
            if (moList.contains(ans[i]))
                moCount++;
            else
                jaCount++;
        }

        return jaCount >= 2 && moCount >= 1;
    }
}