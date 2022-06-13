# get(), post(), delete(), put() == REST 방식 ( Ajax )

import requests

# https://httpbin.org 크롤링 연습용 사이트

# ================================== GET ==================================
url = "https://httpbin.org/get"
param = {"name": "yang"}
# Parameter(QueryString) 없을 때
# res = requests.get(url)

# Parameter(QueryString) 있을 때
res = requests.get(url, params=param)
print(res.url)  # https://httpbin.org/get?name=yang
print(res.headers)  # Headers 내 args 로 데이터 전송
print(res.text)

# ================================== POST ==================================
# url = "https://httpbin.org/post"
# data = {"name": "hong"}  # form 안에 데이터를 넣는 과정

# res = requests.post(url, data=data)
# print(res.text)

# ================================== DELETE ==================================
# url = "https://httpbin.org/delete"

# res = requests.delete(url)
# print(res.text)

# ================================== PUT ==================================
# url = "https://httpbin.org/put"
# data = {"name": "kim"}

# res = requests.put(url, data=data)
# print(res.text)
