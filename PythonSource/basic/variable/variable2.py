# 변수 - 타입 X (할당하면 타입이 생성)
"""
    문자형 : "" , ''
"""
from ntpath import join
from operator import index


str1 = "Life is Good"
str2 = "Life is Good"
str3 = """
Life is to short, You need Python
"""
str4 = '''
Life is to short, You need Python
'''
str5 = "Python's favorite food"

print(str1)
print(str2)
print(str3)
print(str4)

# 연산
# + : 문자열 연결
head = "Python"
tail = " is fun"

print(head + tail)

# * : 문자열 반복
a = "python"
print(a * 2)

print("*" * 50)
print("My Program")
print("*" * 50)

# 문자열 인덱싱
str1 = "Life is too short" # 배열형태로 조회가 가능
print("str1[3] :", str1[3]) # 양수 : 왼쪽 기준으로 조회 ( 가장 왼쪽 : 0 )
print("str1[-3] :", str1[-3]) # 음수 : 오른쪽 기준으로 조회 ( 가장 오른쪽 : -1 )

print()
print("str1[0:4] :", str1[0:4]) # Life
print("str1[4:8] :", str1[4:8]) #  is
print("str1[9:] :", str1[9:]) # oo short
print("str1[:17] :", str1[:17]) # Life is too short
print("str1[0:-4] :", str1[0:-4]) # Life is too s

# 실습
str2 = "20220520Sunny"
# date 변수에 날짜만 담기
date = str2[:-5]
print(date)
# weather 변수에 날씨만 담기
weather = str2[-5:]
print(weather)
# date 변수에 있는 값을 2022-05-20 으로 출력
print(date[0:4], date[4:6], date[6:8], sep="-")
# date, weather 출력 2022-05-20 Sunny
print(date[0:4], date[4:6], date[6:8], sep="-", end=" ")
print(weather)


# 문자열 관련 함수 
"""
    len('문자열') : 문자열의 길이
    count('찾을문자') : 문자열에 포함된 특정 문자의 수
    find('찾을문자', [시작위치]) : 특정 문자가 시작되는 첫번째 위치 반환 ( 없는 경우 : -1 반환 )
    index() : find() 와 같은 역할을 하나, 없는 문자가 있을 경우 Error 발생 ( ValueError: substring not found )
    startwith('문자') : 시작하는 문자 확인 ( bool 형태 반환 )
    endwith('문자') : 끝나는 문자 확인
    join() : 문자열 삽입
    upper() / lower() : 대소문자 변경 
    swapcase() : 대소문자를 상호 변환 ( 대문자 -> 소문자, 소문자 -> 대문자 )
    title() : 각 단어의 첫 문자를 대문자로 변환
    strip(), lstrip(), rstrip() : 공백제거
    replace() : 문자열 바꾸기
    split('구분자') : 문자열 나누기 ( default 구분자 : " " 공백 ) >> 배열형태로 반환
    splitlines() : 줄바꿈(엔터) 를 기준으로 나눔

    =====================================================================================================
문자열 구성파악 ( bool 형태 반환 )
    isdigit() : 숫자
    isalpha() : 알파벳
    isalnum() : 알파벳 + 숫자
    islower() : 소문자
    isupper() : 대문자
"""

print("문자열의 길이 : ", len(str1))

print("문자열에 포함된 특정 문자의 수 ( i ) :", str1.count('i'))
print("문자열에 포함된 특정 문자의 수 ( i ) : %d " % str1.count('i'))
print("문자열에 포함된 특정 문자의 수 ( i ) : {} ".format(str1.count('i')))

print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.find("i"))
print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.find("k"))
print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.find("i", 4))

print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.index("i"))
# print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.index("k")) # ValueError: substring not found 
print("특정 문자가 시작되는 첫번째 문자 위치 반환 ( i ) :", str1.index("i", 4))

print(str1.startswith("L"))
print(str1.startswith("l"))
print(str1.endswith("T"))
print(str1.endswith("t"))

a = ","
print(a.join("abcde"))
print(a.join(["abcde", "fg"]))

a = "abcde"
print("소문자를 대문자로 변경 : ", a.upper())
a = "ABCDE"
print("대문자를 소문자로 변경 : ", a.lower())
a = "Python is Easy"
print(a.swapcase())
a = "python is easy"
print(a.title())

a = "   h  i   "
b = " bye"
print(a.strip() + b) # 양쪽 공백 제거
print(a.lstrip() + b) # 왼쪽 공백 제거
print(a.rstrip() + b) # 오른쪽 공백 제거

print(str1.replace("Life", "Your leg"))

print(str1.split())
a = "a:b:c:d:e"
print(a.split(":"))
print(str1.splitlines())
a = "흑 \n ㅠ \n ㅜ"
print(a.splitlines())

print("1234".isdigit())
print("abcd".isalpha())
print("abc123".isalnum())
print("ABCD".isupper())
print("abcd".islower())

# 실습 : 암호생성
# http://naver.com
# 규칙 1 : http:// 제외
# 규칙 2 : 처음 만나는 . 이후 부분 제외
# 규칙 3 : 남은 글자중 처음 3자리 + 글자 개수 + 글자 내 e 문자 개수 + ! 로 구성
# 결과 : nav51!
data = "http://naver.com"
data = data[7:].split(".")[0]
password = data[:3] + str(len(data)) + str(data.count('e')) + "!"
print(password)

# 문자 + 숫자 : TypeError: 'int' object is not callable : 문자열과 숫자를 자동으로 연결하지 못한다

url = "http://naver.com"
url = url.replace("http://", "")
url = url[:url.find(".")]
e_cnt = url.count('e')
password = url[:3] + str(len(url)) + str(e_cnt) + "!"
print(password)