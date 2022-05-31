# data/word.txt 파일 로드 후, 데이터 단어들 섞기
# 섞은 단어 중 하나 추출 후, 화면에 출력 후 출력된 단어를 보고 빠르게 타이핑하도록 하는 프로그램 작성

import random
import time
import sqlite3
from datetime import datetime

now_date = datetime.now()
formatting_date = now_date.strftime("%Y-%m-%d %H:%M:%S")

conn = sqlite3.connect("data/records.db", isolation_level=None)
cursor = conn.cursor()

sql = """
    CREATE TABLE IF NOT EXISTS records(id integer primary key autoincrement, cnt integer, record text, regdate text)
"""
cursor.execute(sql)

# word 로드 한 후, words list에 단어들 붙여넣기
with open("data/word.txt", "r", encoding="UTF-8") as f:
    list = f.read().split("\n")

# random.shuffle(list)

# start_time = time.time()

# for game in range(int(input("게임할 단어 개수를 입력해주세요 : "))):
#     while True:
#         user = input("%s : " % list[game])
#         if user == list[game]:
#             break

# end_time = time.time()
# result = end_time - start_time

# print("최종 시간 : ", result)


input("Ready? Press Enter Key")
# 시작시간
start = time.time()
# 초단위 return (1970-01-01 0:0:0 기준으로 지난 시간)

# 정답 개수
cnt = 0

n = 1
while n <= 5:
    # 리스트 속의 단어 섞기
    random.shuffle(list)

    # 임의의 단어 추출
    q = random.choice(list)

    print()
    print("Question #{}".format(n))

    # 문제(단어) 보여주기
    print(q)
    # 사용자로부터 입력받기
    x = input()
    # print("입력값 : ", x)

    # 사용자의 입력값과 문제가 일치
    # 일치한다면 Pass 글자 출력, 정답개수 추가
    if q == x:
        print("Pass")
        cnt += 1
    # 일치하지 않는다면 Wrong 출력
    else:
        print("Wrong")

    n += 1
end = time.time()
typing_time = str("{0:.2f}".format(end - start))
print("걸린 시간 : {} 초, 정답개수 : {} 개".format(typing_time, cnt))

if cnt >= 4:
    print("합격")
else:
    print("불합격")


# 기록 삽입 ( 정답 개수, 시간, 오늘 날짜 )
sql = """
    INSERT INTO records(cnt, record, regdate) VALUES(?, ?, ?)
"""
cursor.execute(
    sql,
    (cnt, typing_time, formatting_date),
)
conn.commit()
