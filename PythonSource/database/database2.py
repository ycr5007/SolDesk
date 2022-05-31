from ast import Param
import sqlite3

conn = sqlite3.connect("data/database.db", isolation_level=None)

cursor = conn.cursor()

# 조회 (Select)
# sql = """
#     select * from users
# """
# cursor.execute(sql)


# fetchone() : select 결과로 나온 가장 첫번쨰 행 반환 ( Tuple 구조 )
# fetchmany() : select 결과로 나온 값을 지정된 값 만큼 반환 ( List 구조, 개별 행은 Tuple )
# fetchall() : 앞에서 조회한 one, many 에서 조회하지 않은 나머지 조회 값 반환 ( List 구조, 개별 행은 Tuple )

# print("1 ", cursor.fetchone())
# print("3 ", cursor.fetchmany(size=3))
# print("all ", cursor.fetchall())


# sql = """
#     select * from users order by desc name
# """
# cursor.execute(sql)


# sql = """
#     select * from users where id = ?
# """
# cursor.execute(sql, (3,))


# sql = """
#     select * from users where id = %s
# """
# param = 4
# cursor.execute(sql % param)


# sql = """
#     select * from users where id = :id
# """
# cursor.execute(sql, {"id": 5})


sql = """
    select * from users where id in (?, ?)
"""
param = (3, 5)
cursor.execute(sql, param)


for row in cursor.fetchall():
    print("rows : ", row)
