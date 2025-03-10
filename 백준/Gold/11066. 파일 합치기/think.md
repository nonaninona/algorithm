# 생각의 흐름
어려운 문제다... 내가 아예 못 풀 정도는 아니었던 것 같긴 한데...<br>
문제를 제대로 안 읽어서 DP라는 생각을 못해서 답을 봐버림 ㅋㅋ... ([여기](https://github.com/nonaninona/algorithm/commit/149a8924e5f292c9bf3d8cc3691e831bb9eea2ed) 참고)<br>
1. 뚜렷한 풀이 방법이 안 보임.. 그냥 완전 탐색 해야할 듯
2. 경우의 수에 대해서 좀 알아보다가 결국 부분 구조임을 찾았음(start~end까지의 합을 가지고 구한 합들 중 최소를 찾기)
3. 점화식도 세움
4. 2차원 배열 대각선으로 순회하는 거 짜기만 하면 됨
5. 근데 여기서 1주일 넘게 알고리즘 접어둠 ㅋㅋ..
6. 이제와서 구현하려는데 생각보다 반복문 짜는 게 힘들었음.. 나는 2중 반복문으로 구현하려고 했고 억지로 짰는데, 우리 GPT는 3차원 반복문으로 좀 더 직관성 있게 짜준 듯 함
7. 다른 사람들 풀이를 보면 그냥 2차원으로 한 듯 보임
8. 그런데 시간초과 뜸 => pypy3로 해결
9. 메모리 초과 => dp 배열을 처음에 크게 만들어두고, 최솟값 구하기 전에 inf 값 넣어두는 식으로 변경

![Ongoing-335](https://github.com/user-attachments/assets/48ff84c4-36a1-447f-9845-8c4f7546d5f7)
![Ongoing-336](https://github.com/user-attachments/assets/3386969e-05a2-49c6-b144-b9fcfed29572)
![Ongoing-337](https://github.com/user-attachments/assets/7018acc0-205e-4c99-b674-73d8163bb595)
![Ongoing-338](https://github.com/user-attachments/assets/ead3de5d-649b-4e1d-b1c4-de787e11b91e)
![Ongoing-339](https://github.com/user-attachments/assets/31f4220e-5e6a-4f53-9f2d-3fa83a86c4b2)

# 다른 사람 답 참고
[블로그](https://hseungyeon.tistory.com/313)
