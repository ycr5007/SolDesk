import sqlite3

conn = sqlite3.connect("data/database.db", isolation_level=None)
cursor = conn.cursor()

# 삭제 (delete)
cursor.execute("delete from users where id = ?", (2,))


cursor.execute("delete from users where id = :id", {"id": 3})


cursor.execute("delete from users where id = %s" % 4)

conn.commit()
