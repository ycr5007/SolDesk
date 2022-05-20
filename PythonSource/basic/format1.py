# format ()
"""
    Java ( printf 와 같은 개념 )
        %c : 문자 하나 대입
        %f : 실수형
        %d : 정수형
        %s : 문자열(만능)
"""

print('%d' % 100)
print('%5d' % 100)
print('%05d' % 100)
print()
print('%s' % "ho")
print('%5s' % "ho")
print()
print('%8.2f' % 12.21)
print('%-8.2f' % 12.21)
print('%-8.2f' % 12.2134567)
print()
print('I eat %d apples' % 3)
print('I eat %s apples' % 3)
number = 4
print('I eat %s apples' % number)
print('I eat', number, 'apples')
print()

print('%d : %s' % (1, '홍길동')) # 두 개 이상의 서식문자가 있는 경우, ( ) 괄호로 묶어 대입한다. 
print('%d : %s - %f' % (2, '홍록기', 93.2))
print('Test1 : %5d Price : %4.2f' % (776, 5634.123))
print()
print('i eat %s apples' % 3)
print('i eat %s apples' % 3.156)
print('i eat %s apples' % "3")
print()
print('Error is %d%%' % 98) # Escape 문자 % ( % 표현 : %% )

