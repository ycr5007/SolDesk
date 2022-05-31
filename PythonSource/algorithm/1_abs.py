# 절대값

import math


def abs_sign(val):
    if val >= 0:
        return val
    else:
        return -val


def abs_sqrt(val):
    return math.sqrt(val * val)


if __name__ == "__main__":
    print(abs_sign(15))
    print(abs_sign(-15))

    print(abs_sqrt(3.14))
    print(abs_sqrt(-3.14))
