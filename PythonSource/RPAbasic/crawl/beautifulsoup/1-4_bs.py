from bs4 import BeautifulSoup as bs

# 문서 가져오기
with open("./RPAbasic/crawl/beautifulsoup/story.html", "r") as f:
    html = f.read()

soup = bs(html, "lxml")

# print(soup.prettify())

# 2 . find() 함수로 찾기
p1 = soup.find("p", "title")
# print(p1)

# 형제 p 태그 찾기 ( 다음 형제 태그 )
p2 = p1.find_next_sibling("p")
# print("::::: 두번째 p ::::: ")
# print(f"{p2}")
# print(f"내용 : {p2.get_text()}")
# print(f"속성 list : {p2.attrs}")
# print(f"특정 속성 : {p2['class']}")

p3 = p2.find_next_sibling("p")
# print("::::: 세번째 p ::::: ")
# print(f"{p3}")
# print(f"내용 : {p3.get_text()}")
# print(f"속성 list : {p3.attrs}")
# print(f"특정 속성 : {p3['class']}")

# 첫번째 a
a1 = soup.a
# 두번째 a
a2 = a1.find_next_sibling("a")
# print("::::: 두번째 a ::::: ")
# print(f"{a2}")
# print(f"내용 : {a2.get_text()}")
# print(f"속성 list : {a2.attrs}")
# print(f"특정 속성 : {a2['class']}")

p1 = p2.find_previous_sibling("p")

for v in p2.next_element:
    print(v, end="")
