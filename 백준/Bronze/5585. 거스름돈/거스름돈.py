# 가격 입력 받기, int로 형변환 해줘야 함
price = int(input())
# 거슬러줄 돈 구하기
extraCharges = 1000 - price
# 동전 단위를 저장하는 리스트
unit = [500, 100, 50, 10, 5, 1]
# 거슬러준 동전 개수를 저장하는 변수
count = 0

# 동전 단위를 나타내는 변수
i = 0
# 거슬러줄 돈이 아직 남아 있다면,
while extraCharges > 0:
  # 현재 단위로 거슬러 줄 수 있는 지 확인하고, 못 거슬러 주면 단위를 바꿈
  if extraCharges - unit[i] < 0:
    # 파이썬은 ++이 없는 듯?
    i += 1
    continue
  # 거슬러 줄 수 있으면 거슬러 주고 동전 개수 카운트
  extraCharges -= unit[i]
  count += 1

print(count)
