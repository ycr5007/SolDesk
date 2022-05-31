"""
https://sqlitebrowser.org/dl/

sqlitebrowser
    내장 DB ( 가벼움 )
	python, spring boot 에서 사용가능 
"""
# DB 연동
import sqlite3
from datetime import datetime

# print(sqlite3.version)
# print(sqlite3.sqlite_version)

# 날짜 생성 방법
now = datetime.now()
# print("now : ", now)
now_date_time = now.strftime("%Y-%m-%d %H:%M:%S")  # 날짜 포맷 지정
# print("now_date_time : ", now_date_time)

# DB 생성
conn = sqlite3.connect("data/database.db", isolation_level=None)

# 커서
cursor = conn.cursor()
print(type(cursor))  # <class 'sqlite3.Cursor'>

# 테이블 생성
cursor.execute(
    "CREATE TABLE IF NOT EXISTS users(id integer primary key, username text, phone text, website text, regdate text)"
)

# Oracle DB 와 타입이 다름
# Integer : 숫자형
# text : 문자형

# IF NOT EXISTS : 첫 실행 한번만 생성될 수 있도록 조건 처리

# cursor.execute(
#     "INSERT INTO users VALUES(1, 'KIM', '010-1234-1234', 'kim.com', ?)",
#     (now_date_time,)
# )

# 바인딩의 경우 tuple 자료구조로 삽입한다

# cursor.execute(
#     "INSERT INTO users VALUES(?, ?, ?, ?, ?)",
#     (2, "HONG", "010-4567-1123", "hong.com", now_date_time),
# )


# 여래개의 ROW 를 한번에 삽입
user_list = (
    (3, "CHOI", "010-1111-2222", "choi.com", now_date_time),
    (4, "PARK", "010-8509-7764", "park.com", now_date_time),
    (5, "YUN", "010-9595-7312", "yun.com", now_date_time),
)

cursor.executemany("INSERT INTO users VALUES(?, ?, ?, ?, ?)", user_list)
