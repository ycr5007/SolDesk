import sqlite3

conn = sqlite3.connect("data/database.db", isolation_level=None)
cursor = conn.cursor()

# 수정 (Update)

# id 가 2번인 유저의 이름을 cho 로 변경
# sql = """
#     update users set username = ? where id = ?
# """
# cursor.execute(sql, ("CHO", "2"))


# sql = """
#     update users set username = :username where id = :id
# """
# cursor.execute(sql, {"username": "HONG", "id": "2"})


sql = """
    update users set username = '%s' where id = '%s'
"""
cursor.execute(sql % ("CHO", "2"))


conn.commit()
