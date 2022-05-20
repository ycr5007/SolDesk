# type() : 변수 타입 확인

a = 3.5
print(type(a))
# <class 'float'>

b = True
print(type(b))
# <class 'bool'>

c = 123
print(type(c))
# <class 'int'> 

d = "123"
print(type(d))
# <class 'str'> 


# 형변환 : str(), int(), float(), bool()
print()
print(str(True), type(str(True)))
print(str(1), type(str(1)))
print(str(3.14), type(str(3.14)))
print()
print(int(True), type(int(True)))
print(int("1"), type(int("1")))
# print(int("abc"), type(int("abc"))) # ValueError: invalid literal for int() with base 10: 'abc'
print(int(3.14), type(int(3.14)))
# print(int("3.14"), type(int("3.14"))) # ValueError: invalid literal for int() with base 10: '3.14' > 실수형 문자열은 형변환 불가
print()
print(float(True), type(float(True)))
print(float("1"), type(float("1")))
# print(float("abc"), type(float("abc"))) # ValueError: could not convert string to float: 'abc'
print(float(3.14), type(float(3.14)))
print()
print(bool("True"), type(bool("True")))
print(bool("False"), type(bool("False")))
print(bool(""), type(bool(""))) # 문자열은 "" 이 False, 값이 있는경우 True
print(bool("abc"), type(bool("abc")))
print(bool(1), type(bool(1))) # 숫자형은 0 이 Fasle, 0을 제외한 나머지 True 
print(bool(0), type(bool(0)))
print(bool(-5), type(bool(-5)))
print(bool("1"), type(bool("1")))
print(bool(3.14), type(bool(3.14)))
print(bool("3.14"), type(bool("3.14")))
