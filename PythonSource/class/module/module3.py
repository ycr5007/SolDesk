# 사용자 정의 함수 사용 ( prints )

# import prints
from prints import prt1 as eng, prt2 as kor

# prints.prt1()
# prints.prt2()

# kor()
# eng()


import mod1 as cal

# print(cal.sum(2, 2))
# print(cal.sub(2, 4))
# print(cal.mul(2, 6))
# print(cal.div(2, 8))

print(cal.safe_sum(1, 6))
print(cal.safe_sum(1, "6"))

# import calc

from calc import FourCal

cal = FourCal(3, 5)
print(cal.add())
print(cal.sub())
print(cal.mul())
print(cal.div())
print(cal.power_mul())
