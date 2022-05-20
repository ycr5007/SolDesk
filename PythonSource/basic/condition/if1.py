# 파이썬 : {} 사용 X => 들여쓰기 사용
# if 문 
if True:
    print("True")

a = 200
if a < 100:
    print("a는 100 보다 작다")
    print("그래서 나는 안나오지 ~")
print("조건문에서 들여쓰기가 중요하다.")

if a >= 100 and a <= 200:
    print("a는 100 보다 크거나 같고, 200 보다는 작다")

if 100 <= a <= 200:
    print("a는 100 보다 크거나 같고, 200 보다는 작다")

# 실습
a, b, c = 12, 6, 18
# 가장 큰 수 출력하기
max = a
if max < b:
    max = b;
if max < c:
    max = c;
print(max)

if True :
    print("True")
else :
    print("False")

a = 55
if a < 100 :
    print("a는 100 보다 작다")
else :
    print("a는 100 보다 크다")

print()
score, grade = 90, "A"
if score >= 90 and grade == "A" :
    print("합")
else : 
    print("불합")

print()
# 실습 ( 짝수 홀수 구분 )
# num = int(input("숫자 : "))
# if num % 2 == 0 :
#     print("짝")
# else :
#     print("홀")

import datetime

now = datetime.datetime.now()
print(now) # 2022-05-20 15:11:45.596367
print("{}년 {}월 {}일 {}:{}:{}" .format(now.year, now.month, now.day, now.hour, now.minute, now.second))
if now.hour > 12 :
    print("PM")
else :
    print("AM")

# 삼항연산자 ( [True 실행] if [조건] else [False실행] )
str = "안녕하세요" if True else "반갑습니다"
print(str)
print("PM" if now.hour > 12 else "AM")

# 중첩 if
a = 55
if a > 50 :
    if a < 100 :
        print("50 < %d < 100" % a)
    else :
        print("100 초과")
else :
    print("50 미만")

num = 90
if num >= 90 :
    print("A", num)
elif num >= 80 :
    print("B", num)
elif num >= 70 :
    print("C", num)
elif num >= 60 :
    print("D", num)
else :
    print("E", num)

print()

age, height = 27, 180

if age >= 20 :
    if height >= 170 :
        print("A 지망 가능")
    elif height >= 160 :
        print("B 지망 가능")
    else :
        print("지원 불가")
else :
    print("20세 이상만 지원 가능")

# 실습
# 사용자에게 점수를 입력받고 학점 출력
# > 80 A , > 60 B , > 40 C , > 20 D , else E
# score = int(input("score : "))
# if score > 80 :
#     print("A")
# elif score > 60 :
#     print("B")
# elif score > 40 :
#     print("C")
# elif score > 20 :
#     print("D")
# else :
#     print("E")
# 사칙 계산기 ( + - * / % // ** ) 입력 받아 연산한 후 결과 출력
n1 = int(input("number1 : "))
op = input("( + - * / % // ** ) : ")
n2 = int(input("number1 : "))

if op == "+" :
    print(n1 + n2)
elif op == "-" :
    print(n1 - n2)
elif op == "*" :
    print(n1 * n2)
elif op == "/" :
    print(n1 / n2)
elif op == "%" :
    print(n1 % n2)
elif op == "//" :
    print(n1 // n2)
elif op == "**" :
    print(n1 ** n2)
else :
    print("잘못 입력 했습니다.")
