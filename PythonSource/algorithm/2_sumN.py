# 1 ~ 10 까지 합 : 55
# 1 ~ 100 까지 합 : 5050


def sumN1(val):
    sum = 0
    for i in range(1, val + 1):
        sum += i
    return sum


def sumN2(val):
    sum = 0
    for i in range(1, (val + 1) // 2):
        sum += i + ((val + 1) - i)
    return sum + (val + 1)


# 가우스
def sumN3(val):
    return val * (val + 1) // 2


if __name__ == "__main__":
    import time

    start = time.time()
    print(sumN1(100000000))
    end = time.time()
    print(end - start)
    start = time.time()
    print(sumN2(100000000))
    end = time.time()
    print(end - start)
    start = time.time()
    print(sumN3(100000000))
    end = time.time()
    print(end - start)
