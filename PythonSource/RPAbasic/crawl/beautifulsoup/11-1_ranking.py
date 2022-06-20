# nate 뉴스 ranking
# https://news.nate.com/rank/interest?sc=ent 랭킹 뉴스 추출
# 제목, 기사제공자, 날짜 ( 1 ~ 50 위)

import requests
from bs4 import BeautifulSoup

res = requests.get("https://news.nate.com/rank/interest?sc=ent")
soup = BeautifulSoup(res.text, "lxml")

top = soup.select(".mduSubjectList > div")
# print(top)

for idx, data in enumerate(top, 1):
    # 타이틀
    title = data.select_one("a strong")
    media = data.select_one("span.medium")
    print("{} . {} :: {}".format(idx, title.get_text(), media.get_text()[:-10]))

row = soup.select(".mduSubject > li")
# print(top)

for idx, data in enumerate(row, 1):
    # 타이틀
    title = data.select_one("a")
    media = data.select_one("span.medium")
    print("{} . {} :: {}".format(idx + 5, title.get_text(), media.get_text()))
