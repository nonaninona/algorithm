# 생각의 흐름
1. weighted sum의 느낌임
2. 다 구하기 + 부분합 배열? 아.. x[i]의 범위가 너무 크다
3. parametric? 아닌 듯(결국 맞았음)
4. 삽질하다가...
5. 계산한 값이 최소값이 있는 이차함수거나 증가, 감소만 하는 일차함수 형태일 거라고 추측
6. 근데 답이 계속 틀림..
7. 그냥 답 봄. 이것도 예전 안테나 문제처럼 중앙값 느낌임
8. 근데 dp 배열을 잘 못 구성해서 계속 틀림
9. 오 다시 풀어보니까 5번 가설로 풀어도 맞음

![Ongoing-444](https://github.com/user-attachments/assets/22f826d7-fc9a-4a72-9bdc-76bf6f0e6c7c)
![Ongoing-445](https://github.com/user-attachments/assets/cbc1cca4-de27-4120-8f52-bb25730fc7ba)
![Ongoing-446](https://github.com/user-attachments/assets/1b359cea-54e1-42e1-8ac8-c86dc48907be)
![Ongoing-447](https://github.com/user-attachments/assets/11fe2bc1-8133-49f2-85f1-59021adaabba)
![Ongoing-448](https://github.com/user-attachments/assets/54f9743e-b29b-4e05-8bf8-c5282f5da4c4)
![Ongoing-449](https://github.com/user-attachments/assets/b40f7538-288b-4ad0-b4d3-c9ba07343fb1)


# 배운점
- Comparator는 int를 리턴해야 함
- 중앙값 문제.. 풀이를 왜 못 떠올리지
- lower bound/upper bound 시 -1~N 범위
