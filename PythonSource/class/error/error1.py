# 예외 처리 ( Exception )

# 문법 에러
# print('test)

# SyntaxError: unterminated string literal (detected at line 4)

# a, b = 10, 15
# print(a, b, c)

# NameError: name 'c' is not defined


# print(10 / 0)

# ZeroDivisionError: division by zero ==> Runtime Error


# x = [10, 20, 30]
# print(x[3])

# IndexError: list index out of range ==> Runtime Error


# dict1 = {"name": "hong", "age": 25, "city": "seoul"}
# print(dict1["addr"]) # Error
# print(dict1.get("addr"))

# KeyError: 'addr' ==> Runtime Error


# x.index(40)

# ValueError: 40 is not in list ==> Runtime Error


# f = open("data/111.txt", "r")

# FileNotFoundError: [Errno 2] No such file or directory: 'data/111.txt' ==> Runtime Error


# x = [1, 2]
# y = (1, 2)
# print(x + y)

# TypeError: can only concatenate list (not "tuple") to list ==> Runtime Error


# 오류 처리 방법 ( try ~ except )
# 오류 처리 방법 ( try ~ except 발생오류 )
# 오류 처리 방법 ( try ~ except ~ else )
# 오류 처리 방법 ( try ~ except Exception ) => 어떤 오류가 나는지 모를 때
# 오류 처리 방법 ( try ~ except Exception as e ) => 에러메세지 별칭 부여
# 오류 처리 방법 ( try ~ except ~ finally ) => 오류 발생여부와 상관 없이 무조건 실행


try:
    print(10 / 0)
except ZeroDivisionError:
    print("비상비상 오류발생 ( ZeroDivisionError )")

name = ["kim", "park", "choi"]

try:
    z = "let"
    x = name.index(z)
    print("{} Found it! in name {}".format(z, x + 1))
except:  # ValueError
    print("비상비상 오류발생 ( ValueError )")


# try:
#     number = int(input("정수 입력 >> "))

#     print("원 반지름 : ", number)
#     print("원 둘레 : ", 2 * 3.14 * number)
#     print("원 넓이 : ", 3.14 * (number**2))
# except ValueError:
#     print("비상비상 오류발생 ( ValueError )")

try:
    number = int(input("정수 입력 >> "))
except ValueError:
    print("비상비상 오류발생 ( ValueError )")
else:
    print("원 반지름 : ", number)
    print("원 둘레 : ", 2 * 3.14 * number)
    print("원 넓이 : ", 3.14 * (number**2))


try:  # 에러 발생 가능성이 있는 코드
    a = int(input("??"))
except:  # 에러가 발생했을 때 실행
    print("저런 ...")
else:  # 에러가 발생하지 않은경우 실행
    print("휴 ...")
finally:  # 에러 여부와 상관없이 반드시 실행 ( 자원 해제 등 )
    print("잘했네 ㅋ")

try:
    4 / 0
except Exception as e:  # 에러 메세지 별칭 부여
    print(e)

try:
    f = open("data/info.txt", "r")

finally:
    f.close()
