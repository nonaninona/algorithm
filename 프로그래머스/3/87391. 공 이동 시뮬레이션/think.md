# 생각의 흐름
1차적으로는 아이디어를 생각해내는 게 힘들었고<br>
2차적으로는 패턴을 정리하는 게 힘들었다<br>
1. 일단 숫자가 너무 커서, 모든 시작점에 대해서 판단하는 것은 힘듦.
2. 그렇다면 아무래도 거꾸로 가야하곘지.
3. 그런데... 거꾸로 해도 숫자가 너무 많은데? 벽에 붙어서 벽 방향으로 이동하는 경우에는, 경우의 수가 늘어남. 그런데 이 경우의 수는 10^9 x 10^9까지 그냥 늘어나버릴 수 있음..
4. 이래서는 어떤 시작점이 정답인지 판단하는 건... 그냥 시작점 모두에 대해서 판단하는 거랑 다를 게 없어지는데..
5. 모르겠어서 풀이 찾아봄. "가능한 시작점의 너비"만 구하면 되는 거라서, 각각의 시작점을 경우의 수로 계산할 필요가 없음. 그저 경우의 수의 면적만 신경쓰면 됨 => 아무래도 직사각형이니까 l, r, u, d로 판단가능해보임
6. 근데 이쯤에서 패턴을 정리하는 게 좀 힘들었음.. 이전 문제들도 푸느라, 머리가 좀 힘들어서인지 패턴이 너무 복잡해 보였음...
7. 다다음날 다시 풀면서 패턴을 정리해보니 어려울 게 없었음. 특정 방향으로 이동하게 될 때, 그 방향의 끝에 붙어있으면 확장 / 아니면 이동 처리를 하면 됨. 그런데 확장 또는 이동 시, 보드를 넘어가지 않게만 설정해주면 됨.
8. 보드를 넘어가지 않게만 설정해주는 걸 그냥 각각의 점 4개에 따로 적용해도 되는 이유(=u가 d보다 클 수 없는 이유) => u에 덧셈을 할 때는, 무조건 d에도 같이 덧셈이 이루어짐.
9. 어라 근데 제출했는데 한 번 틀림. 예외가 있나? 엣지케이스를 위해 경곗값을 생각해봤지만.. 잘 모르겠음
10. 생각을 좀 더 해보니 isZero에서의 판단을 and가 아니라 or로 했어야 했던 것임. (ex. [u=3, l=1, d=3, r=3]이어도 끝나야 함)

![Ongoing-348](https://github.com/user-attachments/assets/1551ff25-d9ee-45aa-92a1-12136e127196)
![Ongoing-349](https://github.com/user-attachments/assets/87bc6a0f-91b0-46a8-945b-602e7756da42)
![Ongoing-350](https://github.com/user-attachments/assets/f1ae2329-0b36-4ed9-9548-ad585e2871cf)
![Ongoing-351](https://github.com/user-attachments/assets/88fcc2a4-a64c-408c-8b61-507a0a20b511)
![Ongoing-352](https://github.com/user-attachments/assets/ca63f588-a753-407f-9f5f-dcc2fdfc454a)
![Ongoing-353](https://github.com/user-attachments/assets/c05c6817-084b-4428-9254-8777198b7a2e)
![Ongoing-354](https://github.com/user-attachments/assets/9c0226eb-db85-4e36-a72a-e1109399cb15)
![Ongoing-355](https://github.com/user-attachments/assets/10591901-c3fd-40bb-9242-f288eccf9d0f)


# 다른 사람 답 참고
[여기 위에서 확장/축소라는 관점을 참고함](https://school.programmers.co.kr/questions/79866)
