# 실습
# 2 개의 인자와 연산자를 받아서 사칙 연산을 수행하는 함수(four_rules) 작성
# 인자와 연산자는 사용자에게 입력받는 형태로 작성

# def four_rules(a, b, op):
#     if op == "+":
#         return a + b
#     elif op == "-":
#         return a - b
#     elif op == "*":
#         return a * b
#     elif op == "/":
#         return a / b
#     else:
#         return "잘못된 입력값입니다."


# a = int(input("a : "))
# b = int(input("b : "))
# op = input("op : ")

# print(four_rules(a, b, op))


# def four_rules(a, b):
#     return {"+": a + b, "-": a - b, "*": a * b, "/": a / b}


# a = int(input("a : "))
# b = int(input("b : "))
# op = input("op : ")
# print(four_rules(a, b).get(op))

# [[1, 2, 3], [4, 5, 6], [7, 8, 9]] 형태의 리스트를 받아 1차원 리스트로 반환


def flatten(data):
    list = []
    for d in data:
        list += d
    return list


# list = []


# def flatten(data):
#     global list
#     for d in data:
#         if type(d) == list:
#             list += flatten(d)
#         else:
#             list.append(d)
#     return list


list1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(flatten(list1))


# 실습
# Lotto 생성기
import random


def get_number():
    return random.randrange(1, 46)


def get_Lotto():
    lotto = []
    while len(lotto) < 6:
        num = get_number()
        if lotto.count(num) == 0:
            lotto.append(num)
    return lotto


print(get_Lotto())
