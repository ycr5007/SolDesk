import requests
from bs4 import BeautifulSoup
import urllib.request as req

res = requests.get(
    "https://ko.wikipedia.org/wiki/%EC%84%9C%EC%9A%B8_%EC%A7%80%ED%95%98%EC%B2%A0"
)
soup = BeautifulSoup(res.text, "lxml")

# print(soup.prettify())

# Elements 탭에서 Selector Copy 가능

# 사진 저장
img1 = soup.select_one(
    "#mw-content-text > div.mw-parser-output > table.infobox > tbody > tr:nth-child(1) > td > a > img"
)

# print(img1)
# print(img1["src"])

# 이미지 다운로드 - urlretrieve


# img_url = "https:" + img1["src"]

path = "./RPAbasic/crawl/download/beautifulsoup/"

# try:
#     img, header = req.urlretrieve(img_url, path + "subway.png")
# except Exception as e:
#     print(e)
# else:
#     print(header)

img2 = soup.select_one(
    "#mw-content-text > div.mw-parser-output > div.thumb.tright > div > a > img"
)


img_url = "https:" + img2["src"]

try:
    img, header = req.urlretrieve(img_url, path + "subway_post.png")
except Exception as e:
    print(e)
else:
    print(header)
