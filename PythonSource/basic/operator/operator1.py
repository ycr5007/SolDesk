# 연산자
"""
    산술연산자 : + · - · * · / (실수) · // (정수) · % · ** (제곱) 
    복합대입연산자 : += · -= ...
    관계연산자 : == · != · > · < · >= · <=
    논리연산자 : and · or · not
    비트연산자 : & · | · > · < 
"""
a, b = 5, 3
print(a+b, a-b, a*b, a/b, a//b, a%b, a**b, sep="\t")

print()

s1, s2, s3 = "100", "100.123", "999999999"
print(s1 + s2 + s3) # 연결 ( 문자열 )
print(float(s1) + float(s2) + float(s3)) # 연산 ( 실후형 )

# print(s1 + 1) # TypeError: can only concatenate str (not "int") to str
print(int(s1) + 1)
print(s1 + str(1))

print()
# =====================================================================
a = 10
a += 5
print("a", a)
a == 5
print("a", a)
a *= 5
print("a", a)
a /= 5
print("a", a)
a //= 5
print("a", a)
a %= 5
print("a", a)
a **= 5
print("a", a)

# 실습 : 777,777 원
# 화폐교환 : 5만원 / 1만원 / 5천원 / 1천원

money = 777777
ftt = money // 50000
money %= 50000
ott = money // 10000
money %= 10000
ft = money // 5000
money %= 5000
ot = money // 1000
money %= 1000

print("오만", "일만", "오천", "일천", "나머지", sep="\t")
print(ftt, ott, ft, ot, money, sep=" 장\t")

print()

# =====================================================================

print("a == b", "a != b", "a > b", "a < b", "a >= b", "a <= b", sep="\t")
a, b = 10, 10.0
print(a == b, a != b, a > b, a < b, a >= b, a <= b, sep="\t")
a, b = 10, 0
print(a == b, a != b, a > b, a < b, a >= b, a <= b, sep="\t")

print()
# =====================================================================

print(100 > 60 and 60 > 15)
print(100 > 60 or 60 < 15)
print(not 60 < 15)
print(not False)
print(not True)

print()
# =====================================================================

print(10 & 7)
print(10 | 7)
print((100 > 60) & (60 > 15))