import requests as req
from bs4 import BeautifulSoup as bs

url = "https://www.gmarket.co.kr/?jaehuid=200011415&cosemkid=go16169957343895414&gclid=CjwKCAjwnZaVBhA6EiwAVVyv9HuSOnv%5FJbgt6vHxC8GD0F8Nl4fPXHPnBwkI2Dyh2QlWBPVwjZ3Y1BoCZzkQAvD%5FBwE"

res = req.get(url)
soup = bs(res.text, "lxml")


# 1 차 카테고리
depth1 = soup.find_all("li", class_="list-item__1depth", limit=9)

for dep1 in depth1:
    print(dep1.find("a").get_text())
    depth2 = dep1("li", class_="list-item__2depth", limit=69)
    for dep2 in depth2:
        print("\t", dep2.find("a").get_text(), "URL : ", dep2.find("a")["href"])

# 2차 카테고리
# depth2 = soup.find_all("a", class_="link__2depth-item")
# for dep2 in depth2:
#     print(dep2.get_text())

# depth2 = soup.find_all("li", class_="list-item__2depth", limit=69)
# for depth in depth2:
#     href = depth.find("a")
#     print(href)
