N, M = map(int, input().split())
customers = []
for i in range(M):
    customers.append(int(input()))
customers.sort(reverse=True)

maximum = 0
maximum_price = 0
for i in range(N):
    if i == M:
        break
    income = customers[i] * (i+1)
    if maximum < income:
        maximum = income
        maximum_price = customers[i]

print(maximum_price, maximum)