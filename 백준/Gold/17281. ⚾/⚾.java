import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] scores;
    static int[] entry;
    static boolean[] visited;
    static int maxScore;
    static int C = 0;
    static int[] base;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        scores = new int[N][9];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++)
                scores[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[9];
        entry = new int[9];
        visited[0] = true;
        maxScore = 0;
        perm(0);
        System.out.println(maxScore);
    }

    private static void perm(int depth) {
        if(depth == 9) {
            maxScore = Math.max(maxScore, getScore());
//            System.exit(0);
            return;
        }

        if(depth == 3) {
            entry[depth] = 0;
            perm(depth+1);
            return;
        }

        for(int i=0;i<9;i++) {
            if(visited[i]) continue;
            entry[depth] = i;
            visited[i] = true;
            perm(depth+1);
            visited[i] = false;
        }
    }

    private static int getScore() {
        int score = 0;
        int p = 0;
        for(int i=0;i<N;i++) {
            base = new int[3];
//            System.out.println("이닝 : " + i);
//            System.out.println(Arrays.toString(scores[i]));
//            System.out.println(Arrays.toString(entry));
//            System.out.println(score);
            int out = 0;
            while(out < 3) {
//                System.out.println(p + " " + entry[p] + " " + scores[i][entry[p]] + " " + out);
                int hit = scores[i][entry[p]];
                if(hit == 0) {
                    out++;
                } else if(hit == 4) {
                    int s = 1;
                    for(int j=0;j<3;j++) {
                        s += base[j];
                        base[j] = 0;
                    }
                    score += s;
                } else {
                    int s = 0;
                    for (int j = 2; j >= 0; j--) {
                        if (j + hit >= 3) {
                            if(base[j] == 1) {
                                s++;
                                base[j] = 0;
                            }
                            continue;
                        }
                        base[j + hit] = base[j];
                        base[j] = 0;
                    }
                    base[hit - 1] = 1;
                    score += s;
                }
                p++;
                p%=9;
            }
        }
        return score;
    }
}