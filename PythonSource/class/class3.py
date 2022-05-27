# 클래스 변수 ( static ? ) - Class 내 반드시 선언이 필요하다 ( ClassName.VarName )


class UserInfo:
    """
    UserInfo Class
        Author : 홍길동
        Date : 2022-05-26
        Description : 클래스 작성법
    """

    user_cnt = 0
    def __init__(self, author, date, description):
        self.author = author
        self.date = date
        self.description = description
        # Class 변수 ( Static ) : CLass 내 변수가 없는경우 에러 발생 ( AttributeError: type object 'UserInfo' has no attribute 'user_cnt' )
        UserInfo.user_cnt += 1

    def __str__(self):
        return "Author : {}, Date : {}, Description : {}".format(
            self.author, self.date, self.description
        )

    def __del__(self): # 객체 삭제 시 호출되는 메소드
        UserInfo.user_cnt -= 1


user1 = UserInfo("홍길동", "2022-05-26", "클래스 작성법")
print(user1)
user2 = UserInfo("성춘향", "2022-03-23", "클래스 사용법")
print(user2)

print("현재 생성된 User {} 명".format(UserInfo.user_cnt))

del user1 # __del__ 호출 
# print(user1) # NameError: name 'user1' is not defined. Did you mean: 'user2'?
print(user2)
print("현재 생성된 User {} 명".format(UserInfo.user_cnt))
