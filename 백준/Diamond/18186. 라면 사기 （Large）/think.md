# 생각의 흐름
1. 라면 사기 small 제대로 못 푼 게 분해서 풀어봄
2. 근데 그리디가 중요하진 않았음
3. B와 C의 크기에 따라 전략이 달라질 것 같은데? 따져봄
4. B < C -> 합쳐서 사는 게 손해. B == C -> 어떻게 사던 같음
5. 따라서 B > C 아닌 이상 그냥 숫자의 총 합 * B가 답임.
6. B > C 일때 크기 차이에 따라 바뀌는 게 있나? => 없어보임 1 2 1 1 애 대해 B=100, C=1로 해도 차이가 없음
7. 사실 (B+C) + (B+C+C) = 2B+3C vs (B+C+C) + B + B = 3B+2C라서 어떻게 묶냐에 대한 싸움일 뿐
8. 묶는 건 small 문제에서 이미 풀었고.
9. 틀려서 논리 다시 점검해도 문제 없어보임 => 타입 문제? ㅇㅇ long으로 바꾸니 맞음

![Ongoing-436](https://github.com/user-attachments/assets/ded6f3cc-d327-4263-ab6a-0a79fe97602d)
![Ongoing-437](https://github.com/user-attachments/assets/958fbae6-fa49-4ef7-a27d-51f512531bfb)
![Ongoing-438](https://github.com/user-attachments/assets/c2278f5c-4ec1-4caf-b5d4-f62222447775)

# 배운점
- java에서는 자료형 크기 잘 확인하자
