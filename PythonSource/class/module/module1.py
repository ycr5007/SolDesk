# Module : 함수나 변수 또는 클래스들을 모아 놓은 파일

# import sys

# print(sys.builtin_module_names)
"""
    ('_abc', '_ast', '_bisect', '_blake2', '_codecs', '_codecs_cn', '_codecs_hk', '_codecs_iso2022', '_codecs_jp', '_codecs_kr', '_codecs_tw',
    '_collections', '_contextvars', '_csv', '_datetime', '_functools', '_heapq', '_imp', '_io', '_json', '_locale', '_lsprof', '_md5',
    '_multibytecodec', '_opcode','_operator', '_pickle', '_random', '_sha1', '_sha256', '_sha3', '_sha512', '_signal', '_sre', '_stat',
    '_statistics', '_string', '_struct', '_symtable', '_thread', '_tracemalloc', '_warnings', '_weakref', '_winapi', '_xxsubinterpreters',
    'array', 'atexit', 'audioop', 'binascii', 'builtins', 'cmath', 'errno', 'faulthandler', 'gc', 'itertools', 'marshal', 'math', 'mmap',
    'msvcrt', 'nt', 'sys', 'time', 'winreg', 'xxsubtype', 'zlib')
"""


import math  # math 안에 있는 모든 것들이 import

# print(dir(math))
"""
    ['__doc__', '__loader__', '__name__', '__package__', '__spec__', 'acos', 'acosh', 'asin', 'asinh', 'atan', 'atan2', 'atanh',
    'ceil', 'comb', 'copysign', 'cos', 'cosh', 'degrees', 'dist', 'e', 'erf', 'erfc', 'exp', 'expm1', 'fabs', 'factorial', 'floor',
    'fmod', 'frexp', 'fsum', 'gamma', 'gcd', 'hypot', 'inf', 'isclose', 'isfinite', 'isinf', 'isnan', 'isqrt', 'lcm', 'ldexp', 'lgamma',
    'log', 'log10', 'log1p', 'log2', 'modf', 'nan', 'nextafter', 'perm', 'pi', 'pow', 'prod', 'radians', 'remainder', 'sin', 'sinh', 'sqrt',
    'tan', 'tanh', 'tau', 'trunc', 'ulp']
"""

# print(math.__doc__)
"""
    This module provides access to the mathematical functions
    defined by the C standard.
"""

# print(math.ceil(3.14)) # 4
# print(math.sin(1)) # 0.8414709848078965
# print(math.cos(1)) # 0.5403023058681398
# print(math.floor(2.4)) # 2


# import random

# # 0 ~ 1 사이 무작위 수(유리수) return
# print(random.random())

# # 지정한 범위 사이의 임의의 수(유리수) return
# print(random.uniform(10, 20))
# # range 범위에서 임의의 수 1개 return
# print(random.randrange(10, 20, 2))

# # 지정된 리스트 안에서의 임의의 값 return
# print(random.choice([1, 2, 3, 4, 5, 6, "a", "b", "c", "d"]))

# # 지정된 리스트 내부 요소 모두 섞기
# shuffle_list = [1, 2, 3, 4, 5, 6, "a", "b", "c", "d"]
# print(shuffle_list)
# random.shuffle(shuffle_list)
# print(shuffle_list)

# # 리스트 요소 중 지정한 값 만큼 추출
# print(random.sample([1, 2, 3, 4, 5, 6, "a", "b", "c", "d"], k=4))


import time

print("지금부터 5초간 정지 sleep")
time.sleep(5)
print("프로그램 종료")
