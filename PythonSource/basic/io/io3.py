# csv 파일 입출력

# csv 파일 reader
import csv

# with open("data/sample1.csv", "r") as f:
#     reader = csv.reader(f)

#     # Header 명 제거
#     next(reader)

#     print(reader)  # <_csv.reader object at 0x00000184B3DED780>
#     print(type(reader))  # <class '_csv.reader'>
#     print(dir(reader))

#     print()
#     for c in reader:
#         print(c)
#         print(type(c)) # list 형태로 열을 가져온다


# with open("data/sample2.csv", "r") as f:
#     reader = csv.reader(f, delimiter="|")
#     # delimiter = "구분자 지정 (Default ( , ))"

#     next(reader)

#     for c in reader:
#         print(c)

# csv ==> dict 형태로 읽어오기
# with open("data/sample1.csv", "r") as f:
#     reader = csv.DictReader(f)  # Dictionary 형태로 읽어오기
#     # {'번호': '1', '이름': '김정수', '가입일시': '2017-01-19 11:30:00', '나이': '25'}
#     for c in reader:
#         # print(c)
#         for k, v in c.items():
#             print(k, v)
#         print()

# with open("data/sample3.csv", "r") as f:
#     reader = csv.reader(f)
#     for c in reader:
#         print(c)

# =========================== csv 파일 쓰기 ===========================
# 1차원 리스트 csv 파일로 저장
# list1 = [1,2,3,4,5]
# list1 = list(range(1, 6))
# with open("data/sample4.csv", "w") as f:
#     writer = csv.writer(f)
#     writer.writerow(list1)


# 2차원 리스트 csv 파일로 저장
# list1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12], [13, 14, 15], [16, 17, 18]]
# with open("data/sample5.csv", "w", newline="") as f:
#     # newline="" >> 한줄 작성 후 처리 ( print 의 (end= ) 와 같은 역할)
#     writer = csv.writer(f)
#     # for row in list1:
#     #     writer.writerow(row)
#     writer.writerows(list1)  # 줄 마다 확인 없이 리스트의 모든 내용을 삽입
