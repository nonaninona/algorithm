totalCount = 0
totalGrade = 0
gradeName = ["A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"]
gradeVal = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0]
for i in range(20):
    (name, count, grade) = input().split()
    if grade == "P":
        continue

    totalCount += float(count)
    for n, v in zip(gradeName, gradeVal):
        if n == grade:
            totalGrade += v * int(float(count))
            break

print(totalGrade/totalCount)