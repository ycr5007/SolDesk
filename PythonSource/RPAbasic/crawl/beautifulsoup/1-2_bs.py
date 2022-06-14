import requests as req
from bs4 import BeautifulSoup as bs
from fake_useragent import UserAgent

url = "https://n.news.naver.com/article/032/0003152805?cds=news_media_pc"
headers = {"user-agent": UserAgent().chrome}

res = req.get(url, headers=headers)

soup = bs(res.text, "lxml")

# print(soup.h2) # 1 . 가장 처음 나오는 태그만 검색

# find() / find_*() 함수 2 .특정 element 찾기

h2_ele = soup.find("h2", class_="media_end_head_headline")
print(h2_ele)
