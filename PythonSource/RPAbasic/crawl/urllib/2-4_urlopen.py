# 영화진흥위원회 어제 날짜(20220608) 박스오피스 파일 저장
import urllib.request as req

url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220608"
path = "./RPAbasic/crawl/download/"

try:
    res = req.urlopen(url)
    content = res.read().decode("utf-8")

    with open(path + "movie.txt", "w", encoding="UTF-8") as f:
        f.write(content)
except Exception as e:
    print(e)
else:
    print("SUCCESS")
