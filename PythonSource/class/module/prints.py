# 모듈 생성 ( 사용자 정의 모듈 )
"""
    함수와 변수로만 구성된 별도의 .py 파일
"""


def prt1():
    print("Hello !! Everyone !!")


def prt2():
    print("안녕하세요 !! 여러분 !!")


# 모듈에 있는 내용은 호출해서 출력했을 때 내용이 출력되므로, 제한을 두어야 한다
# 모듈 테스트 방법
if __name__ == "__main__":
    prt1()
    prt2()


# import 시 출력
# if True:
#     print("??")
