import requests as req
from bs4 import BeautifulSoup as bs

res = req.get("https://news.v.daum.net/v/20220613080021221")

soup = bs(res.text, "lxml")

# 기사 제목 가져오기
title = soup.select_one("title")
# 기사 작성날짜 / 시간 가져오기
date = soup.select_one("span.num_date")
# 기사 작성자 가져오기
writer = soup.select_one("span.txt_info")
# 기자 첫번째 문단 가져오기
content = soup.select("p")

print(title)
print(date)
print(writer)
for txt in content:
    print(txt)
