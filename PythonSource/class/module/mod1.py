# 사용자 정의 모듈


def sum(a, b):
    return a + b


def sub(a, b):
    return a - b


def mul(a, b):
    return a * b


def div(a, b):
    return a / b


def safe_sum(a, b):
    if type(a) != type(b):
        print("연산이 불가능 합니다.")
        return  # None return
    else:
        result = sum(a, b)
    return result


if __name__ == "__main__":
    print(safe_sum("a", 15))
    print(safe_sum(15, 15))
