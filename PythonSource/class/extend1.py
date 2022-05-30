# Class 상속


# class Parent:
#     def __init__(self) -> None:
#         self.value = "test"
#         print("Parent Class __init__")

#     def test(self):
#         print("Parent Class test")


# class Child(Parent):
#     def __init__(self) -> None:
#         Parent.__init__(self)  # 부모의 객체가 생성될 수 있도록 명시
#         print("Child Class __init__")


# child = Child()
# child.test()  # Parent 클래스의 Method 호출
# print(child.value)
# AttributeError: 'Child' object has no attribute 'value' ( 자식 클래스에서 부모 클래스의 생성자를 호출하여 해결)

"""
    동작 순서

        Parent Class __init__
        Child Class __init__
        Parent Class test   
        test
"""


# class Car:

#     speed = 0

#     def up_speed(self, value):
#         self.speed = self.speed + value

#     def down_speed(self, value):
#         self.speed = self.speed - value


# class Sedan(Car):
#     seatNum = 0

#     def getSeatNum(self):
#         return self.seatNum


# class Truck(Car):
#     capacity = 0

#     def getCapacity(self):
#         return self.capacity


# sedan1, truck1 = Sedan(), Truck()

# sedan1.up_speed(100)
# truck1.up_speed(80)

# sedan1.seatNum = 5
# truck1.capacity = 50

# print("승용차의 속도는 {}km, 좌석수는 {} 개 입니다".format(sedan1.speed, sedan1.getSeatNum()))
# print("승용차의 속도는 {}km, 중량은 {}t 입니다".format(truck1.speed, truck1.getCapacity()))


class AudioVisual:
    def __init__(self, volume, power=False):
        self.volume = volume
        self.power = power

    def switch(self, on_off=None):
        if on_off != None:
            self.power = on_off
        else:
            self.power = not self.power

    def set_volume(self, volume):
        self.volume = volume


class Audio(AudioVisual):
    def __init__(self, volume, power=False):
        super().__init__(volume, power)

    def tune(self):
        if self.power == True:
            print("욘마하~~~~트! 브레이커 ~")
        else:
            print("전원을 켜주세요")


class TV(AudioVisual):
    def __init__(self, volume, size, power=False):
        super().__init__(volume, power)
        self.size = size

    def watch(self):
        if self.power == True:
            print("전구우우욱 ~ 노래자랑 ~ 빠빠바빠바빠빠~")
        else:
            print("전원을 켜주세요")


tv1 = TV(12, 55)
tv1.switch()
tv1.watch()

audio1 = Audio(199)
audio1.switch()
audio1.tune()
