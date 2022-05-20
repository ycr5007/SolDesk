# while : tab 단위로 블럭 표시

# 1 ~ 10 출력
i = 1 # 초기화
while i < 11 : # 조건
    print(i)
    i += 1 # 증감 ( i++ 불가 )

# 1 ~ 100 중 짝수만 출력
i = 2
while i < 101 :
    print(i, end="\t")
    i += 2

print()
# 2 ~ 100 중 홀수 출력
i = 1
while i < 101 :
    if i % 2 != 0 :
        print(i, end="\t")
    i += 1

print()

i = 1
sum1 = 0
while i < 101 :
    sum1 += i
    i += 1
print(sum1)

# sum 함수  
# range(시작 숫자, 끝나는 숫자, 증감)
print(sum(range(1, 101, 1)))

print()

i = 1
while i < 10 :
    j = 1
    while j < 10 :
        print("%d x %d = %d" %(i, j, i * j), end="\t")
        if j % 3 == 0 :
            print()
        j += 1
    if i % 3 == 0 :
        print()
    i += 1