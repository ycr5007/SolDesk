# 최대 수익 알고리즘
# 어떤 주식에 대해 특정 기간동안의 가격 변화가 이루어 졌을 때 그 주식 한 주를 사고 팔아 얻을 수 있는 최대 수익을 계산하는 알고리즘
import random
import time


def max_profit1(stock):
    size = len(stock)
    max_profit = 0

    for i in range(size - 1):
        for j in range(i + 1, size):
            profit = stock[j] - stock[i]
            if profit > max_profit:
                max_profit = profit
    return max_profit


def max_profit2(stock):
    size = len(stock)
    max_profit = 0

    # 첫째날의 주가를 최소값으로 시작
    min_price = stock[0]

    for i in range(1, size):
        profit = stock[i] - min_price
        if profit > max_profit:
            max_profit = profit
        if stock[i] < min_price:
            min_price = stock[i]
    return max_profit


def test(n):
    # 주가에 해당하는 랜덤 숫자 생성
    stock = []
    for i in range(0, n):
        stock.append(random.randint(5000, 20000))

    # O(n^2) 알고리즘
    start = time.time()
    mps = max_profit1(stock)
    end = time.time()
    time_slow = end - start
    # O() 알고리즘
    start = time.time()
    mpf = max_profit2(stock)
    end = time.time()
    time_fast = end - start

    print("입력크기, mps, mpf :: ", n, mps, mpf)
    diff = 0
    if time_fast > 0:
        diff = time_slow / time_fast

    print("%d %.5f %.5f %.2f" % (n, time_slow, time_fast, diff))


if __name__ == "__main__":
    # stock = [10300, 9600, 9800, 8200, 7800, 8300, 9500, 9800, 10200, 9500]
    # print("최대 수익 : ", max_profit1(stock))
    # print("최대 수익 : ", max_profit2(stock))
    test(100)
    test(10000)
