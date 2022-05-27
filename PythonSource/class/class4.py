class Car:

    # 클래스변수
    car_count = 0

    def __init__(self, count, color, speed):
        self.color = color
        self.speed = speed

        Car.car_count += count

    def upSpeed(self, value):
        self.speed += value

    def downSpeed(self, value):
        self.speed -= value

    def __del__(self):
        Car.car_count -= 1


car1 = Car(1, "Red", 20)
car1.upSpeed(50)
print(
    "Car 1 Speed {} km, Color : {}, 생산된 자동차 : {} 대".format(
        car1.speed, car1.color, Car.car_count
    )
)

car2 = Car(1, "Black", 40)
car2.upSpeed(70)
car2.downSpeed(30)
print(
    "Car 2 Speed {} km, Color : {}, 생산된 자동차 : {} 대".format(
        car2.speed, car2.color, Car.car_count
    )
)
car3 = Car(1, "Green", 120)
car3.downSpeed(50)
print(
    "Car 3 Speed {} km, Color : {}, 생산된 자동차 : {} 대".format(
        car3.speed, car3.color, Car.car_count
    )
)


del car1
print("생산된 자동차 대수 {} 대".format(Car.car_count))
