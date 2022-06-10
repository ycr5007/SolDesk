# URL 작업 - urllib 라이브러리 필요

# request - 1) urlretrieve()    > 요청하는 URL 의 정보를 파일로 저장
#                               > Return 값이 Tuple 형태로 반환
#                               > csv 파일, apu 데이터 등 많은 양의 데이터를 한번에 저장

import urllib.request as req

url = "http://google.com"
# 다운로드 받을 경로
path = "./RPAbasic/crawl/download/"

try:
    file1, header1 = req.urlretrieve(url, path + "goolgle.html")
except Exception as e:
    print(e)
else:
    print(header1)
    print("SUCCESS")
