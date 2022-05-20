# for [변수] in 범위 
# 범위 : range, list ...

# range
print(range(5))
print(list(range(5)))
print(list(range(1, 5)))
print(list(range(0, 10, 2)))
print(list(range(10, 0, -2)))


for i in range(10) :
    print(i, end="\t")
print()

oddSum, evenSum, totalSum = 0, 0, 0
for i in range(1, 101) :
    if i % 2 != 0 :
        oddSum += i
    else :
        evenSum += i
    totalSum += i

print(oddSum)
print(evenSum)
print(totalSum)

# 실습
# 사용자로부터 입력받은 후 1 ~ 입력 값 까지의 합계
# total = 0;
# for i in range(int(input("1 ~ x 의 합계 :: ")) + 1) :
#     total += i
# print(total)

print(sum(range(1, 100 + 1)))

# 문자열 for
word = "dreams"
for s in word :
    print(s)

# 2 중 for 문
for i in range(3) :
    for j in range(3) :
        print(j, end = " ")
    print()

print()

# 구구단
for i in range(1, 10) :
    for j in range(1, 10) :
        print("%d x %d = %d" % (i, j, i * j), end="\t")
    print()

print()

for i in range(1, 4) :
    for j in range(1, 10) :
        for q in range(i, 10, 3) :
            print("%d x %d = %d" % (q, j, q * j), end="\t")
        print()
    print()

# break / continue
i = 1
while i <= 10 :
    if i == 5 :
        break
    print(i, end="\t")
    i += 1
print()
i = 1
while i <= 10 :
    i += 1
    if i % 2 == 0 :
        continue
    print(i, end="\t")

print()

# 실습
# 1 ~ 10 까지 출력, i = 5 출력 X
for i in range(1, 11) :
    if i == 5 :
        continue
    print(i, end="\t")