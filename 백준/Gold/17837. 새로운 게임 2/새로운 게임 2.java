import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] B;
    static Piece[][] A;
    static Map<Integer, Piece> P;

    static class Piece {
        int id;
        Piece next;
        int y, x;
        int d;

        public Piece(Piece next, int d, int y, int x, int id) {
            this.next = next;
            this.d = d;
            this.y = y;
            this.x = x;
            this.id = id;
        }

        public String toString() {
            return id + " " + d + " " + next + " " + y + " " + x;
        }
    }

    static int[] Dy = {0, 0, -1, 1};
    static int[] Dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 보드 색상
        B = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 보드 LL head 구성
        A = new Piece[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                A[i][j] = new Piece(null, -1, i, j, 0);
            }
        }

        // Piece를 prev Map과 LL 보드에 추가
        P = new HashMap<>();
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            Piece p = new Piece(null, d, y, x, i+1);

            Piece prev = A[y][x];
            while(prev.next != null) {
                prev = prev.next;
            }
            prev.next = p;

            P.put(i+1, prev);
        }

//        for(int k : P.keySet()) {
//            System.out.println(P.get(k).next);
//        }
        int turn = 1;
        while(turn < 1000) {
            for (int k = 0; k < K; k++) {
//                System.out.println("=".repeat(3) + (k+1) + "=".repeat(3));

                //prev와 target p get
                Piece prev = P.get(k+1);
                Piece p = prev.next;

                //이동 위치 계산
                int ny = p.y + Dy[p.d];
                int nx = p.x + Dx[p.d];

                //blue거나 나가면
                if((ny < 0 || nx < 0 || ny >= N || nx >= N) || B[ny][nx] == 2) {
                    int newD = getNewD(p.d);
                    ny = p.y + Dy[newD];
                    nx = p.x + Dx[newD];

                    //이동하려는 칸이 blue거나 나가면 이동 x
                    p.d = newD;
                    if((ny < 0 || nx < 0 || ny >= N || nx >= N) || B[ny][nx] == 2) continue;

//                    //이동하려는 칸의 뒤에 붙이기
//                    prev.next = null;
//                    Piece targetPrev = A[ny][nx];
//                    while(targetPrev.next!=null) {
//                        targetPrev = targetPrev.next;
//                    }
//                    targetPrev.next = p;
//                    P.put(k + 1, targetPrev);
//
//                    //y, x 업데이트
//                    while(targetPrev.next != null) {
//                        targetPrev = targetPrev.next;
//                        targetPrev.y = ny;
//                        targetPrev.x = nx;
//                    }
//
//                    int c = count(ny, nx);
////                    System.out.print(c + " ");
//                    if(c >= 4) {
////                        System.out.println(turn);
//                        return;
//                    }
                }

                if(B[ny][nx] == 0) {
                    //이동하려는 칸의 뒤에 붙이기
                    prev.next = null;
                    Piece targetPrev = A[ny][nx];
                    while(targetPrev.next!=null) {
                        targetPrev = targetPrev.next;
                    }
                    targetPrev.next = p;
                    P.put(k + 1, targetPrev);

                    //y, x 업데이트
                    while(targetPrev.next != null) {
                        targetPrev = targetPrev.next;
                        targetPrev.y = ny;
                        targetPrev.x = nx;
                    }

                    int c = count(ny, nx);
//                    System.out.print(c + " ");
                    if(c >= 4) {
                        System.out.println(turn);
                        return;
                    }
                } else if(B[ny][nx] == 1) {
                    // 역순 구성을 위한 리스트 생성 및 y, x 변경
                    List<Piece> list = new ArrayList<>();
                    list.add(p);
                    p.y = ny;
                    p.x = nx;
                    while(p.next != null) {
                        p = p.next;
                        list.add(p);
                        p.y = ny;
                        p.x = nx;
                    }

                    // 추가할 위치 찾기
                    prev.next = null;
                    Piece targetPrev = A[ny][nx];
                    while(targetPrev.next!=null) {
                        targetPrev = targetPrev.next;
                    }

                    // 역순으로 추가
                    for(int i=list.size()-1;i>=0;i--) {
                        targetPrev.next = list.get(i);
                        P.put(list.get(i).id, targetPrev);
                        targetPrev = targetPrev.next;
                    }
                    targetPrev.next = null;

                    int c = count(ny, nx);
//                    System.out.print(c + " ");
                    if(c >= 4) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
            turn++;
        }
        System.out.println(-1);
    }

    private static int getNewD(int d) {
        if(d == 0)
            return 1;
        else if(d == 1)
            return 0;
        else if(d == 2)
            return 3;
        else if(d == 3)
            return 2;
        return -1;
    }

    private static int count(int y, int x) {
        int ret = 0;
        Piece p = A[y][x];
        while(p.next != null) {
            ret++;
            p = p.next;
        }
        return ret;
    }
}