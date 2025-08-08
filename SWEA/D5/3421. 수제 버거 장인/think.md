# 배운점
- 왜 조합으로 접근했니? 부분집합 문제는 dfs라고 외워두자. 그리고 사실 조합 문제가 나올 빈도 자체가 낮은데..
- 아무튼 근데 조합으로 접근해도 맞추긴 하는데 이건 항상 테케가 부족한 SWEA니까 그러려니 하자. 시간복잡도 넘치는 게 맞으니 더 생각해봐야 함
- 일단 내 풀이는 dfs + hash 정도로 요약이 가능한데, isCount 메서드가 최대 20번의 연산만 수행한다는 것이 핵심이다(Set.contains는 O(1)이므로)
- 그리고 배우님 풀이가 인상깊어서 정리해서 가져와보자면 아래와 같다. 백트래킹인데, boolean이 아니라 int 배열을 활용했다.
  ```
  import java.io.*;
  import java.util.*;
  
  public class Main {
      static int answer, n, m;
      static List<Integer>[] rules;
      static int[] used;
  
      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int T = Integer.parseInt(br.readLine());
          for (int tc = 1; tc <= T; tc++) {
              StringTokenizer nm = new StringTokenizer(br.readLine());
              n = Integer.parseInt(nm.nextToken());
              m = Integer.parseInt(nm.nextToken());
              rules = new List[n + 1];
              for (int i = 1; i <= n; i++) rules[i] = new ArrayList<>();
              used = new int[n + 1];
              for (int i = 0; i < m; i++) {
                  StringTokenizer line = new StringTokenizer(br.readLine());
                  int a = Integer.parseInt(line.nextToken());
                  int b = Integer.parseInt(line.nextToken());
                  if (a > b) rules[b].add(a);
                  else rules[a].add(b);
              }
              
              answer = 0;
              dfs(1);
              System.out.printf("#%d %d\n", tc, answer);
          }
      }
      
      static void dfs(int cnt) {
          if (cnt == n + 1) {
              answer++;
              return;
          }
          if (used[cnt] == 0) { // 전에 안사용됨
              // 사용하는 상황
              for (Integer num : rules[cnt]) {
                  used[num]++;
              }
              dfs(cnt + 1);
              for (Integer num : rules[cnt]) {
                  used[num]--;
              }
          }
          // 전에 사용됨
          dfs(cnt + 1); // 사용하지 않는 상황
      }
  }
  ```
