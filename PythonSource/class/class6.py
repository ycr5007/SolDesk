# Class FourCal 작성
# 숫자 2개 입력 받아, 사칙연산 실행


# class FourCal:
#     def __init__(self, x, y):
#         self.x = x
#         self.y = y

#     def add(self):
#         return self.x + self.y

#     def sub(self):
#         return self.x - self.y

#     def mul(self):
#         return self.x * self.y

#     def div(self):
#         return self.x / self.y


# x = int(input("x : "))
# y = int(input("y : "))
# calculator = FourCal(x, y)

# op = input("op : ")
# if op == "+":
#     print(calculator.add())
# elif op == "-":
#     print(calculator.sub())
# elif op == "*":
#     print(calculator.mul())
# elif op == "/":
#     print(calculator.div())


# Audio Class 생성
# Power, Volumne 멤버변수 ( init 초기화 )
# switch 메소드 ( on_off 매개 변수를 받아 power 변경 )
# set_volume 메소드 ( volume 매개 변수를 받아 volume 변경 )
# tune 메소드 ( power 값이 True 인 경우 " 음 악 실 행 " )
#                           False 인 경우 " 전원을 켜주세요 "
class Audio:
    def __init__(self, volume, power=False):
        self.volume = volume
        self.power = power

    def switch(self, on_off=None):
        if on_off != None:
            self.power = on_off
        else:
            power = not power

    def set_volume(self, volume):
        self.volume = volume

    def tune(self):
        if self.power == True:
            print("욘마하뚜브레이커 ~")
        else:
            print("전원을 켜주세요")


audio = Audio(10)
audio.switch(True)
audio.set_volume(15)
audio.tune()
