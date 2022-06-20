# CSS 선택자를 이용한 요소 찾기 : select, select_one ...

from bs4 import BeautifulSoup as bs

# 문서 가져오기
with open("./RPAbasic/crawl/beautifulsoup/story.html", "r") as f:
    html = f.read()

soup = bs(html, "lxml")

# 타이틀 태그 가져오기
title = soup.select_one("p.title")
print(title)

# id 가 link1 인 태그 요소 가져오기
link1 = soup.select_one("#link1")
print(link1)

# data- 속성 가져오기
link2 = soup.select_one("a[data-io='tillie']")
print(link2)

# p 클래스의 자식태그 모두 가져오기
p_child = soup.select("p.story > a")
print(p_child) # 리스트 형태 반환
