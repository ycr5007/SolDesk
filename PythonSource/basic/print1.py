# print() 
'''
option 
    ① sep 속성 > , 로 들어오는 문자열의 구분자 지정 ( default : ' ' 공백 )
    ② end 속성 > 줄바꿈을 하지 않고, 다음 줄과 연결하여 출력 ( default : '개행' 줄바꿈 - '' 공백으로 지정 시, 개행 없이 공백 한칸을 추가한다.)
'''
print("Hello")
print('Python')
print(100)
print("100")
print("25.3")
print(25)
print()
# type() : 변수 Type 확인
print(type(100))    # <class 'int'>
print(type("100"))  # <class 'str'>
print(type('100'))  # <class 'str'>
print(type(25.5))   # <class 'float'>
print(type(True))   # <class 'bool'>
print()
print('T', 'E', 'S', 'T') # T E S T
print('T', 'E', 'S', 'T', sep='/') # T/E/S/T
print('2022', '05', '19', sep="-") # 2022-05-19
print()
print("파이썬은 ", end='')
print("쉬운 언어입니다.") # 파이썬은  쉬운 언어입니다.

