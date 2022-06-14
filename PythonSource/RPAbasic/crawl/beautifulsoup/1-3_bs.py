from bs4 import BeautifulSoup as bs

# 문서 가져오기
with open("./RPAbasic/crawl/beautifulsoup/story.html", "r") as f:
    html = f.read()

soup = bs(html, "lxml")

# print(soup.prettify())

# 1 . 태그 명으로 찾기
title = soup.title
print("::::: title ::::: \n{}\n".format(title))
print("::::: title 내용 ::::: \n{}\n".format(title.get_text()))
print("::::: title 부모태그 ::::: \n{}\n".format(title.parent))
print("::::: h1 태그 ::::: \n{}\n내용 : {}\n".format(soup.h1, soup.h1.get_text()))
print("::::: h2 태그 ::::: \n{}\n내용 : {}\n".format(soup.h2, soup.h2.get_text()))

p1 = soup.p
print(
    f"::::: p 태그 ::::: \n{p1}\n내용 : {p1.get_text()}\n속성 : {p1.attrs}\n특정 속성 값 : {p1['class']}\n"
)

b = soup.b
print(f"::::: b 태그 ::::: \n{b}\n내용 : {b.get_text()}\n")
print(f"::::: a 태그 ::::: \n{soup.a}\n")
