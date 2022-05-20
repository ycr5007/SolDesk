# 변수 - 타입 X (할당하면 타입이 생성)
"""
    숫자형 : 정수, 실수, 8진수, 16진수 ...
"""

a = 13
a = -7
a = 0
a = 1.2
a = 0b0101 # 2 진수
a = 0o177 # 8 진수
a = 0x1aa # 16 진수

# 사칙연산
# a = 3
# b = 4
a, b = 3, 4 # Python 에서 가능한 변수 선언 방법
print(a + b)
print(a / b) # result > 0.75 :: 실수 개념으로 계산 ( 정수 나눗셈 X )
print(a // b) # result > 0 :: 정수 나눗셈
print(a % b) # result > 3 :: 나머지 
print(a ** b) # result > 81 :: 3^4 ( 제곱계산 )