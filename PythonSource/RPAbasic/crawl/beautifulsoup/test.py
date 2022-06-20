import requests
from bs4 import BeautifulSoup
import urllib.request as req

res = requests.get(
    "https://mall.epost.go.kr/fo/search/search.do?searchTerm=%EC%9E%A5%EB%82%9C%EA%B0%90"
)
soup = BeautifulSoup(res.text, "lxml")

img_list = soup.select("img")
print(img_list)


path = "./RPAbasic/crawl/download/beautifulsoup/"
idx = 1
for img in img_list:

    print(img["src"])
    try:
        img, header = req.urlretrieve(img["src"], path + "img" + str(idx) + ".png")
    except Exception as e:
        print(e)
    else:
        print(header)
    idx += 1
