# 팩토리얼 구하기


def fact1(n):
    result = 1
    for i in range(1, n + 1):
        result = result * i
    return result

# 재귀 호출
def fact2(n):
    # 기본단계 : 끝내는 부분
    if n == 1:
        return 1
    # 반복단계
    else:
        return n * fact2(n - 1)



if __name__ == "__main__":
    print(fact2(900))
