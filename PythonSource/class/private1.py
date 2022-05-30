# private 키워드 ? ( __Property ) : 사용은 가능하나, 변수에 직접 접근 불가

import math


class Circle:
    def __init__(self, radius) -> None:
        self.__radius = radius

    def get_circumference(self):
        return 2 * math.pi * self.__radius

    def get_circle_area(self):
        return math.pi * (self.__radius**2)

    # Getter / Setter
    def get_radius(self):
        return self.__radius

    def set_radius(self, radius):
        self.__radius = radius


circle = Circle(10)
print("__radius : ", circle.get_radius())

circle.set_radius(20)
print("둘레 : ", circle.get_circumference())
print("면적 : ", circle.get_circle_area())
# print("__radius : ", circle.__radius)
# AttributeError: 'Circle' object has no attribute '__radius'
print("__radius : ", circle.get_radius())
