# 재귀호출 : 함수 안에서 자기 자신을 부르는 것

# 잘못된 예제
def hello():
    print("HELLO")
    hello()


hello()
# RecursionError: maximum recursion depth exceeded while calling a Python object :: 재귀함수 에러


