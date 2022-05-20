# format 함수 : 중괄호를 이용해 공간을 지정하고, format 함수를 통해 삽입

"""
    3.x 이후로 format 함수 사용 가능 
    ex ) print("{ }" .format(3))
"""

print("{} and {}" .format('You', 'Me'))
print("{0} and {1} and {0}" .format('You', 'Me')) # format 함수로 감싸진 것은 인덱스 형태로 호출이 가능하다
print()
print("{var1} and {var2}" .format(var1 = 'You', var2='Me'))
print("I ate {number} apples. so I was sick for {day} days" .format(number = 10, day=3))
print("I ate {0} apples. so I was sick for {day} days" .format(5, day=3))
print("Test1 : {0:5d}, Price : {1:4.2f}" .format(776, 6534.123)) # format 함수의 서식지정 ( {Key:서식} § 단 반드시 Key 값이 있어야 함 )
print("Test1 : {a:5d}, Price : {b:4.2f}" .format(a = 776, b = 6534.123))