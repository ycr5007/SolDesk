# 최대공약수


def gcd1(a, b):
    if a > b:
        temp = a
        a = b
        b = temp

    if b % a == 0:
        return a

    for i in range(a, 0, -1):
        if (b % i == 0) & (a % i == 0):
            return i


# 유클리드 호제법
# a 와 b의 최대공약수는 b 와 a 를 b로 나눈 나머지의 최대공약수와 같다
#               gcd(a, b) == gcd(b, a % b)
# 어떤 수와 0의 최대 공약수는 자기 자신

# gcd(60, 24) ==> gcd(24, 60%24) ==> gcd(24, 12) ==> gcd(12, 24%12) ==> gcd(12, 0) :: 최대공약수 : 12
def gcd2(a, b):
    if b == 0:
        return a
    else:
        return gcd2(b, a % b)


if __name__ == "__main__":
    print(gcd2(1, 5))
    print(gcd2(3, 39))
    print(gcd2(60, 72))
    print(gcd2(84, 98))
    print(gcd2(10, 2))
