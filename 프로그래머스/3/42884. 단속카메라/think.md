# 생각의 흐름
1. 흠.. 일단 완전탐색을 해보기가 어려움..<br>
감시카메라 설치 경우의 수는 거의 무제한;;
2. 강의실 배정이랑 느낌이 비슷함. 그리디임.
3. 딱 봐도 가장 먼저 나가는 차의 위치에 설치하면 될 듯 함<br>
그리고 그 다음 차는, 이전에 설치한 위치에 영향을 받는지 확인하면 될 듯
4. 정당성은 대충 이렇게 말할 수 있을 듯<br>
내 답의 sequence : a1, a2, a3 .. an<br>
최적 답의 sequence : b1, b2, b3, ... bn<br>
이떄 E(a1) <= E(a2) ... <= E(an)<br>
가장 먼저 나가는 차의 위치에 설치한다는 정의 상 E(b1) <= E(a1)<br>
b도 첫번째 차가 카메라에 찍히도록 해야하므로 b1은 무조건 첫번쨰 차의 시점, 종점 사이에 있음<br>
따라서 a는 b보다 같은 차를 챙기면서도 더 오래 지속됨 = 다음 차를 포함할 가능성이 높아짐<br>

![image](https://github.com/user-attachments/assets/21895406-fb72-4cf8-b579-1e53bbb0a3f0)
![image](https://github.com/user-attachments/assets/6ade1c32-cd29-4093-bc18-e2731368d8fb)
![image](https://github.com/user-attachments/assets/e53692f0-33fe-48eb-a54b-6cde18ea9c51)



# 다른 사람 답 참고
[셀프 참고](https://nonaninona.tistory.com/75)
