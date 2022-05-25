# 함수 ( Function )
# 반복적으로 수행되는 부분을 함수로 작성
# 단독으로 실행 가능

# def 로 함수 선언
# def Name () :
#   수행할 문장 1
#   수행할 문장 2


# 함수 작성
def hello():
    print("Hello")


# 함수 호출
hello()


def hello2():
    return "Hello"


print(hello2())


def hello3(msg):
    return msg


print(hello3("Hello"))


def add(a, b):
    return a + b


print(add(3, 4))


# 기본 Parameter ( 매개변수에 Default 값 지정 가능 )
def print_n_times(value, n=2):
    for i in range(n):
        print(value)


print_n_times("안녕하세요")
print_n_times("오지마세요", 5)


# def say_myself(name, man=True, old) >> 초기값을 설정하는 변수는 반드시 일반 변수 뒤쪽에 선언해야한다.
def say_myself(name, old, man=True):
    print("나의 이름은 {} 입니다.".format(name))
    print("나의 나이는 {} 입니다.".format(old))
    if man:
        print("남자입니다.")
    else:
        print("여자입니다.")


say_myself("도라에몽", 7)
say_myself("도라미", 4, False)


# Return
def sum_and_mul1(a, b):
    return a + b, a * b  # Tuple 구조에 담아서 반환


def sum_and_mul2(a, b):
    return [a + b, a * b]  # List 형태로 반환


def sum_and_mul3(a, b):
    return {"add": a + b, "mul": a * b}  # Dictionary 형태로 반환


print(sum_and_mul1(3, 4))  # (7, 12) Tuple 형태로 반환

add, mul = sum_and_mul1(7, 6)  # 반환값을 다음과 같은 형태로 변수에 받아올 수 있음
print(add, " \t ", mul)

print(sum_and_mul2(3, 4))  # [7, 12]
print(sum_and_mul3(3, 4))  # {'add': 7, 'mul': 12}


def func_mul(x):
    y1 = x * 100
    y2 = x * 200
    y3 = x * 300
    return y1, y2, y3


print(func_mul(100))
y1, y2, y3 = func_mul(200)
print("{}, {}, {}".format(y1, y2, y3))
# y4, y5 = func_mul(300) # ValueError: too many values to unpack (expected 2)
# print("{}, {}".format(y4, y5))

# 가변 Parameter : *args >> 인자의 개수가 정확하지 않을 때 사용
# TypeError: add_many() takes 1 positional argument but 4 were given ( 가변 설정을 안한 경우 )
# def add_many(*num):  # 가변 매개변수 튜플구조
#     # print(type(num))
#     print(num)


# add_many({"dessert": "macaroon", "wine": "merlot"})
# add_many("35", "24", "15", "36")
# add_many([35, 24, 18, 17])
# add_many(1, 2, 3, 4, 5, 6)
# add_many(1)
# add_many()


def add_many(*num):
    result = 0
    for i in num:  # Tuple 구조이기 때문에 반복문 사용 가능
        result += i
    return result


print("result = ", add_many())
print("result = ", add_many(15, 63, 45, 356, 36, 9, 3))
print("result = ", add_many(27, 35, 56))
print("result = ", add_many(39, 48, 17, 16, 15))

# **KeywordArgs >> 가변 Parameter 를 Dictionary 형태로 처리
def args_func1(**kwargs):
    print("kwargs : ", kwargs)
    # print(type(kwargs)) # Dictionary 타입
    for k in kwargs.keys():
        print(k)
    for v in kwargs.values():
        print(v)
    print()


args_func1(name="kim")
args_func1(name="kim", name2="Park", active="Test")
args_func1(name="kim", age=10, title="Title")
args_func1(name="kim", age=25, addr="Seoul")


def example_mul(arg1, arg2=5, *args, **kwargs):
    print(arg1, arg2, args, kwargs)


example_mul(10, 20)
example_mul(10)
example_mul(10, 20, "park", "Kim", 10, 20)
example_mul(10, 20, "choi", age=25, name="Kim")

# 변수의 효력 범위 (Scope)
# 함수 안에서 선언된 변수의 효력 범위는 함수 내에서만 존재 ( 지역변수 )
a = 1


# def var_test(a):
#     a = a + 1
#     return a


# a = var_test(a)
# print(a)


def var_test():
    global a # 함수 밖에 있는 변수를 호출(사용)
    a = a + 1


var_test()
print(a)
