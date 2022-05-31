# 1 ~ N 까지 연속한 숫자의 제곱 합 구하기


# 복잡도 : O(n)
def sumNSquares1(val):
    sum = 0
    for i in range(1, (val + 1)):
        sum += i**2
    return sum


# 공식 : n(n + 1)(2n + 1) / 6
# 복잡도 : O(1)
def sumNSquares2(val):
    return val * (val + 1) * ((val * 2) + 1) // 6


if __name__ == "__main__":
    print(sumNSquares1(10))
    print(sumNSquares2(10))
