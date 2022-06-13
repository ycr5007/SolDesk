# requests 에서 json 처리

import requests

# https://jsonplaceholder.typicode.com/ JSON 연습용 사이트

# url = "https://jsonplaceholder.typicode.com/todos/1"

# res = requests.get(url)
# print(res.text)
# print(res.content)  # binary 형식으로 가져올 때

# print(res.json())  # json ==> dict
# print(res.json().keys())
# print(res.json().values())

"""
JSON 데이터 반환
{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}
"""

# JSON 데이터가 여러개 일 떄
url = "https://jsonplaceholder.typicode.com/users"

res = requests.get(url)

for data in res.json():
    print(data)
