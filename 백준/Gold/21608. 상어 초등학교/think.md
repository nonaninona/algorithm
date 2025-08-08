# 배운점
- 파이썬에서 자바로 바꾼 이후 구현력이 떨어진 것 같다. 구현 훈련이 필요할 듯 함.
- 실제 시험에서는 테케가 적고, 시간이 촉박하기 때문에 내가 스스로 테케를 만들거나 주어진 테케를 변화시켜보고, 시간 내에 푸는 연습을 해보는 것이 좋을 것 같다.
- pq를 이용하면 더 쉽게 풀 수 있다. map이나 set도 많이 활용해보자
  ```
  import java.io.*;
  import java.util.*;
  
  public class Main {
  
      static int N;
      static Map<Integer, Set<Integer>> infos;
      static int[][] board;
      static PriorityQueue<int[]> pq;
      static int[] order;
      static int[] score = {0, 1, 10, 100, 1000};
  
      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          N = Integer.parseInt(br.readLine());
          order = new int[N*N];
          infos = new HashMap<>();
          StringTokenizer st;
          for(int i=0;i<N*N;i++) {
              st = new StringTokenizer(br.readLine());
              int n = Integer.parseInt(st.nextToken());
              Set<Integer> s = new HashSet<>();
              for(int j=0;j<4;j++)
                  s.add(Integer.parseInt(st.nextToken()));
              infos.put(n, s);
              order[i] = n;
          }
  
          board = new int[N][N];
  
          for(int k=0;k<N*N;k++) {
              pq = new PriorityQueue<>(Comparator.comparingInt((int[] l) -> -l[0]).thenComparing((int[] l) -> -l[1]).thenComparing((int[] l) -> l[2]).thenComparing((int[] l) -> l[3]));
              int s = order[k];
              for (int i = 0; i < N; i++) {
                  for (int j = 0; j < N; j++) {
                      if(board[i][j] != 0)
                          continue;
                      int l = calcL(s, i, j);
                      int b = calcB(i, j);
                      pq.offer(new int[]{l, b, i, j});
                  }
              }
  //            System.out.println(pq.stream().sorted(Comparator.comparingInt((int[] l) -> -l[0]).thenComparing((int[] l) -> -l[1]).thenComparing((int[] l) -> l[2]).thenComparing((int[] l) -> l[3])).map(a -> Arrays.toString(a)).toList());
              int[] node = pq.poll();
              board[node[2]][node[3]] = s;
  //            for(int i=0;i<N;i++)
  //                System.out.println(Arrays.toString(board[i]));
          }
  
  //        for(int i=0;i<N;i++)
  //            System.out.println(Arrays.toString(board[i]));
  
          int ans = 0;
          for (int i = 0; i < N; i++)
              for (int j = 0; j < N; j++)
                  ans += score[calcL(board[i][j], i, j)];
          System.out.println(ans);
      }
  
      static int[] Dy = {-1, 1, 0, 0};
      static int[] Dx = {0, 0, -1, 1};
  
      private static int calcL(int s, int y, int x) {
          int ret = 0;
          Set<Integer> likes = infos.get(s);
          for(int i=0;i<4;i++) {
              int ny = y + Dy[i], nx = x + Dx[i];
              if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                  continue;
              if(likes.contains(board[ny][nx]))
                  ret++;
          }
  //        System.out.println(y + " " + x + " " + ret);
          return ret;
      }
  
      private static int calcB(int y, int x) {
          int ret = 0;
          for(int i=0;i<4;i++) {
              int ny = y + Dy[i], nx = x + Dx[i];
              if(ny < 0 || nx < 0 || ny >= N || nx >= N)
                  continue;
              if(board[ny][nx] == 0)
                  ret++;
          }
          return ret;
  
      }
  }
  ```
