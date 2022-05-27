# 클래스 메소드


class Test:
    # 매개변수 self 가 없는 경우, 클래스 메소드로서 사용된다.
    # ∴ self :: 인스턴스마다 갖고 있는 정보를 의미
    def function1():
        print("function1 호출")

    # self 변수가 있으므로, 멤버 메소드로서 사용된다.
    def function2(self):
        print("function2 호출")


obj1 = Test()
# obj1.function1() # TypeError: Test.function1() takes 0 positional arguments but 1 was given
Test.function1()
obj1.function2()
# Test.function2() # TypeError: Test.function2() missing 1 required positional argument: 'self'


# 생성자 오버로딩 X ( 함수 매개변수의 초기값 설정으로 관리 )
class UserInfo:
    user_cnt = 0

    def __init__(self, name, age, email=None):
        self.name = name
        self.age = age
        self.email = email
        UserInfo.user_cnt += 1

    def user_info(self):
        return "name : {}, age : {}, email : {}".format(self.name, self.age, self.email)

    def __del__(self):
        UserInfo.user_cnt -= 1


# TypeError: UserInfo.__init__() missing 1 required positional argument: 'email'
user1 = UserInfo("홍길동", 30)
print(user1.user_info())

user2 = UserInfo("성춘향", 20, "sung@naver.com")
print(user2.user_info())
