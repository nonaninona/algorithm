# 배운점
- 로봇을 "동시에" 옮겨야 한다는 사실을 생각을 못헀음.
- 사실 생각했어도 시간 초과가 났을 수도?
- 처음에 나는 완전히 문제에서 요구한 그대로 구현함. => 순서를 LinkedList로 관리. 로봇의 위치는 A와 같은 방식으로 배열로 관리
- 그런데 왜 시간 초과가 났지?? 아마... 로봇이 idx=2에 먼저 놓이고, 로봇이 idx=3에 놓인 경우에는, idx=2에 있는 로봇이 한 템포 늦게 움직여서 그런가보다.
- 그러니까 정확성이 빠그러지면서 시간도 같이 터진 듯?? 하필 예제들은 그렇게 역순으로 주어지는 경우가 없었나 봄.. 다 답이 잘 나왔었음
- 아무튼 "동시에" 옮겨야 하고, 한 칸 밖에 못 움직이는 상황이라서 사실 "로봇이 놓인 순서"는 중요하지가 않음.
- 가장 뒤에 있는 로봇 부터 옮긴다면, N만 탐색해서 모든 로봇을 한 step 이동 시킬 수 있음.

\+ deque를 이용한 풀이가 상당히 직관적이라 맘에 듦
```
import java.util.*;
import java.io.*;

class Main {

    static int N, K, L;
    static int brokeCnt;

    static Deque<Cell> top, bot;

    static class Cell {
        boolean hasR;
        int d;

        public Cell(int d) {
            this.d = d;
            this.hasR = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = 2 * N;

        top = new ArrayDeque<>();
        bot = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Cell c = new Cell(Integer.parseInt(st.nextToken()));
            if(c.d == 0)
                brokeCnt++;
            top.offerLast(c);
        }
        for(int i=0;i<N;i++) {
            Cell c = new Cell(Integer.parseInt(st.nextToken()));
            if(c.d == 0)
                brokeCnt++;
            bot.offerFirst(c);
        }

        int step = 1;
        while (true) {
            Cell c = top.pollLast();
            bot.offerLast(c);
            c = bot.pollFirst();
            top.offerFirst(c);

            ArrayList<Cell> topArr = new ArrayList<>(top);
            topArr.get(N-1).hasR = false;
            for(int i=N-2;i>=0;i--) {
                Cell next = topArr.get(i+1);
                Cell cur = topArr.get(i);

                if(cur.hasR && !next.hasR && next.d > 0) {
                    cur.hasR = false;
                    next.hasR = true;
                    next.d--;
                    if(next.d == 0)
                        brokeCnt++;
                }
            }
            topArr.get(N-1).hasR = false;

            Cell first = topArr.get(0);
            if(!first.hasR && first.d > 0) {
                first.hasR = true;
                first.d--;
                if(first.d == 0)
                    brokeCnt++;
            }

            if (brokeCnt >= K)
                break;

            step++;
        }

        System.out.println(step);
    }

}
```
