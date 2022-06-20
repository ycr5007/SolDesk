import requests
from bs4 import BeautifulSoup

res = requests.get("https://pythonscraping.com/pages/page3.html")
soup = BeautifulSoup(res.text, "lxml")

# h1 태그 가져오기
h1 = soup.select_one("h1")
# 상단내용 가져오기
content = soup.select_one("#content")
# 모든 이미지 태그 가져오기
img_list = soup.select("img")
# 타이틀 행 가져오기
table_header = soup.select("th")
# 테이블 내용 가져요기
table_content = soup.select(".gift")
# 가격만 가져오기
price_list = soup.select("tr > td:nth-child(3)")

print(h1)
print("======================================")
print(content)
print("======================================")
print(img_list)
print("======================================")
print(table_header)
print("======================================")
print(table_content)
print("======================================")
print(price_list)
