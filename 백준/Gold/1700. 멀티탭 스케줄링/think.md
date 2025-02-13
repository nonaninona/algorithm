# 생각의 흐름
1. 음... 일단 완탐은 아님 => 2의 100승이라
2. 근데 대충 DP 보다는 그리디로 풀이 가능해보이긴 함. 일단 뒤에 뭐가 나올 지를 대충 알면 될 것 같으니..
3. 대충 규칙은 안보이고 그냥 뒤에서 가장 나중에 나오는 애를 플러그에서 뽑거나 or 스택 활용 같아 보임. 둘 다 시간복잡도는 만족함
4. 스택은 좀 따져보니 수가 안보임..
5. 가장 나중에 나오는 애를 구현까진 했는데 정당성 증명이 살짝 애매함
6. 내가 생각한 정당성 증명<br>
수학적인 엄밀한 증명이라기보단 조금 descriptive함.<br>
핵심은, 현재 꽂혀 있는 것을 나중에 다시 꽂아야할 때 활용할 수 있도록 하는 것<br>
그런데 현재, 누군가 하나는 뽑혀야 함<br>
그러면 다시 꽂아야 하는 경우가 가장 늦게 오는 녀석을 빼는 것이 합리적인 것 같아보이긴 함<br>
왜 그럴지 증명하려면... 아마 더 빠른 답이 있다고 가정하는 것 정도가 있을 듯<br>
그러면 이번에, 가장 늦게 오는 녀석이 아니라 그보다 앞에 있는 애를 뺐을 때 최적인 답이 나오는 경우가 있다고 생각해보자<br>
그 애는, 당장 다음에 필요할 수도 있음. 최소한 가장 늦게 오는 녀석보다는 먼저 필요하게 됨.<br>
근데 이것만으로 증명은 안될 듯...

![image](https://github.com/user-attachments/assets/b1507a15-4174-4a76-a5ef-0f11d8aa4a47)
![image](https://github.com/user-attachments/assets/25b579ca-a530-492c-9d8a-1d836caf6271)
![image](https://github.com/user-attachments/assets/ec0848f1-ace6-4232-bd58-b5f502ecd0fd)
![image](https://github.com/user-attachments/assets/a4cd06ab-76bb-4c28-b548-68207fe96b66)


# 다른 사람 답 참고
내가 LRU 얘기를 했었는데, [여기](https://magentino.tistory.com/88#:~:text=belady%27s%C2%A0min%C2%A0algorithm)도 그런 느낌으로 접근했네<br>
[위키백과](https://en.wikipedia.org/wiki/Cache_replacement_policies#:~:text=%5Bedit%5D-,B%C3%A9l%C3%A1dy%27s%20algorithm,-%5Bedit%5D)에 따르면,<br>
그리고 내가 들었던 수업을 기억해보면, 미래를 예측할 수 있을 때의 최적을 구할 수 있음(cache replacement에서)<br>
그 이론상 최적의 횟수를 구하는 게 이 문제와 거의 동일한 목표임<br>
아니 그래서 정당성 증명은..?<br>

[누군가의 증명](https://developerhan.tistory.com/23#:~:text=%EC%88%98%20%EC%9E%88%EA%B2%8C%20%EB%90%9C%EB%8B%A4.-,%EA%B8%B0%EC%A4%80%EC%97%90%20%EB%8C%80%ED%95%9C%20%EA%B2%80%ED%86%A0%20%2D%20%EC%A6%9D%EB%AA%85,-(%ED%95%B4%EB%8B%B9%20%EC%8B%9C%EC%A0%90%EC%97%90%EC%84%9C)%20%EA%B0%80%EC%9E%A5).. 근데 이정도로 되나?
