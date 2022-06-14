# pip install beautifulsoup4 ( parsing 작업 - 크롤링 시 가장 많이 쓰이는 방법 )
# pip install lxml ( parser )

# requests + beautifulsoup

# 객체 생성( 페이지 소스, parser )

import requests as req
from bs4 import BeautifulSoup as bs

res = req.get("https://news.v.daum.net/v/20220613080021221")
# print(res.text)

# parser : html.parser ( default, 설치 X ) / lxml ( 설치 필요, parsing 속도가 빠름 )
soup = bs(res.text, "lxml")

# print(soup)
# print(soup.prettify())

# <head> 태그 내용 가져오기
# print(soup.head)

# <body> 태그 내용 가져오기
# print(soup.body)

# <head> 태그 안 <title> 태그 가져오기
# print(soup.title) # 태그 전체
# print(soup.title.name) # 태그 명
# print(soup.title.get_text()) # 태그 내용
# print(soup.title.string) # 태그 내용

# print(soup.form)


# 기사 제목 가져오기
title = soup.find("title")
# 기사 작성날짜 / 시간 가져오기
date = soup.find("span", class_="num_date")
# 기사 작성자 가져오기
writer = soup.find("span", class_="txt_info")
# 기자 첫번째 문단 가져오기
content = soup.find("p", attrs={"dmcf-ptype": "general"})

print(title)
print(date)
print(writer)
print(content)
