# 입력 : input()

# msg = input()
# print(msg)

# msg = input("이름 입력 : ")
# print(msg)

# num1 = input("num1 : ") 
# num2 = input("num2 : ")
# print(num1 + num2) # 515 >> str 형태로 값을 받아온다
# num1 = int(input("num1 : ")) 
# num2 = int(input("num2 : "))
# print(num1 + num2) 

# 실습
# 년 / 월 / 일 형태로 입력받은 후 10년 후 날짜를 출력하기
# ex ) 2022/05/20 => 2032년05월20일
date = input("xxxx/xx/xx >> ")
date = date.split('/')
date[0] = str(int(date[0]) + 10)
print(date[0] + "년" + date[1] + "월" + date[2] + "일")
print("%04d 년 %02d 월 %02d 일" % (int(date[0]), int(date[1]), int(date[2])))