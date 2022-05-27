class UserInfo:
    """
    UserInfo Class
        Author : 홍길동
        Date : 2022-05-26
        Description : 클래스 작성법
    """

    def user_info(self):
        print("user_info 메소드 실행")

    # Default 생성자와 동일
    def __init__(self):
        self.author = "홍길동"
        self.date = "2022-05-26"
        self.description = "클래스 작성법"

    # self ( 멤버 변수가 없는 경우 에러 발생 ) : AttributeError: 'UserInfo' object has no attribute 'author'
    def __str__(self):
        return "Author : {}, Date : {}, Description : {}".format(
            self.author, self.date, self.description
        )


# user1 = UserInfo()

# user1.user_info()

# user1 = UserInfo()
# print(user1)


class Car:
    def __init__(self):
        self.color = "White"
        self.speed = 0

    def upSpeed(self, value):
        self.speed += value

    def downSpeed(self, value):
        self.speed -= value


car1 = Car()
car1.speed = 0
car2 = Car()
car2.speed = 0
car2.color = "Black"
# car3 = Car()
# car3.speed = 0
# car3.color = "Gray"

car1.upSpeed(30)
print("car1 색상 : {}, 속도 : {}km".format(car1.color, car1.speed))
car2.upSpeed(130)
car2.downSpeed(-20)
print("car2 색상 : {}, 속도 : {}km".format(car2.color, car2.speed))
# car3.upSpeed(1130)
# print("car3 색상 : {}, 속도 : {}km".format(car3.color, car3.speed))

print(UserInfo.__doc__) # 주석 Print 하는 것 ( 주석 """  """ )
# __xxx__ : 파이썬에서 기본적으로 제공하는 정의된 함수

