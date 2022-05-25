# 파일 읽기
"""
    read() : 파일 전체 읽어오기
    readline() : 줄단위로 읽어오기 (매개변수 값을 넣을 경우, 해당 줄에서 인덱싱 처리)
    readlines() : 전체 글을 List 형태로 읽어오기 ( Enter 를 기준으로 요소 구분, 매개변수 값을 넣을 경우, 리스트의 인덱싱 처리 )
"""
# with open("data/review.txt", "r", encoding="UTF-8") as f :
#     print(f.read())

# with open("data/review.txt", "r", encoding="UTF-8") as f:
#     line = f.readline()
#     while line:
#         print(line, end="")
#         line = f.readline()

# ---------------- 파일에 있는 내용을 리스트로 가져오기 ----------------
# with open("data/review.txt", "r", encoding="UTF-8") as f:
#   print(f.readlines())

# score.txt 읽어서 평균 출력
# with open("data/score.txt", "r", encoding="UTF-8") as f:
#     sum = 0
#     avg = 0
#     list = f.readlines()
#     for str in list:
#         sum += int(str.replace("\n", ""))
#         avg = sum / len(list)
#     print(avg)

# 총합과 평균을 result.txt 파일로 작성
# 총합 : xxx
# 평균 : xx.xx
# score = []
# with open("data/score.txt", "r", encoding="UTF-8") as f:
#     for num in f:
#         score.append(int(num))
#     print(score)
# with open("data/result.txt", "w", encoding="UTF-8") as result:
#     result.write("총합 : %d\n평균 : %.2f" % (sum(score), (sum(score) / len(score))))

# health_info 텍스트를 읽어 bmi 지수 계산 후 화면 출력
# 이름 : 나바
# 몸무게 : 96
# 키 : 140
# BMI : 계산 값
# 결과 : 저체중

# BMI = weight / (height / 100) ** 2
# 결과 : BMI 지수가 25 이상 과체중, 18.5 정상, 나머지 저체중
# def result(bmi):
#     if bmi >= 25:
#         return "과체중"
#     elif bmi >= 18.5:
#         return "정상"
#     else:
#         return "저체중"


# with open("data/health_info.txt", "r", encoding="UTF-8") as f:
#     for person in f:
#         data = person.split("\t")
#         print("이름 : {}".format(data[0]))
#         print("몸무게 : {}".format(data[1]))
#         print("키 : {}".format(data[2].replace("\n", "")))
#         bmi = int(data[1]) / (int(data[2]) / 100) ** 2
#         print("BMI : {0:.2f}".format(bmi))
#         print("결과 : {}".format(result(bmi)), end="\n\n")


# 원본 파일을 읽은 후 암호화, 암호화된 파일은 복호화

# content = ""

# while True:
#     no = int(input("1.암호화 | 2.복호화 | 3.종료 중 메뉴 입력 "))

#     if no == 1:
#         # origin 파일을 읽은 후 content 라는 변수에 읽어온 내용 담기
#         with open("data/origin.txt", "r", encoding="UTF-8") as f:
#             content = f.read()
#         # encryption.txt 작성
#         with open("data/encryption.txt", "w", encoding="UTF-8") as enc:
#             enc_list = []
#             for char in list(content):
#                 if char != "\n":
#                     char = chr(ord(char) + 100)
#                 enc_list.append(char)
#             enc.writelines(enc_list)
#         # 읽어온 내용 암호화 ord("c") : 99, (코드값 + 100) => 문자로 변경 chr(99) = c
#         # chr(ord("안") + 100)
#     elif no == 2:
#         with open("data/encryption.txt", "r", encoding="UTF-8") as dec:
#             content = dec.read()
#             for i in range(0, len(content)):
#                 if content[i] != "\n":
#                     print(chr(ord(content[i]) - 100), end="")
#                 else:
#                     print()
#         # 원래 있던 내용으로 출력
#     else:
#         print("프로그램 종료")
#         break
#     print()

data = None
with open("c:\\windows\\notepad.exe", "rb") as f:
    data = f.read()

with open("data/notepad.exe", "wb") as f:
    f.write(data)
