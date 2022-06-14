from bs4 import BeautifulSoup as bs

# 문서 가져오기
with open("./RPAbasic/crawl/beautifulsoup/story.html", "r") as f:
    html = f.read()

soup = bs(html, "lxml")

# print(soup.prettify())

# 2 . find() 함수로 찾기
p1 = soup.find("p", "title")
# print(p1)

p2 = soup.find("p", class_="story")
# print("::::: 두번째 p ::::: ")
# print(f"{p2}")
# print(f"내용 : {p2.get_text()}")
# print(f"속성 list : {p2.attrs}")
# print(f"특정 속성 : {p2['class']}")


a2 = soup.find("a", id="link2")
# print("::::: 두번째 a ::::: ")
# print(f"{a2}")
# print(f"내용 : {a2.get_text()}")
# print(f"속성 list : {a2.attrs}")
# print(f"특정 속성 : {a2['id']}")


a3 = soup.find("a", id="link3")
a3 = soup.find("a", attrs={"class": "sister", "id": "link3", "data-io": "tillie"})
# print("::::: 세번째 a ::::: ")
# print(f"{a3}")
# print(f"내용 : {a3.get_text()}")
# print(f"속성 list : {a3.attrs}")
# print(f"특정 속성 : {a3['id']}")
# print(f"특정 속성 : {a3['href']}")


# find_all() : 모두 가져오기 ( list 반환 )

a = soup.find_all("a")

b = soup.find_all("b")
# print(b)

# limit 개수 제한 > 앞에서부터 n 개 만큼 반환
a = soup.find_all("a", limit=2)

a = soup.find_all("a", class_="sister", limit=2)

# 텍스트 노드값 이용해서 가져오기 ( 문자열이 전부 일치 해야함 )
a = soup.find_all("a", string=["Elsie", "Lacie"])
print(a)
