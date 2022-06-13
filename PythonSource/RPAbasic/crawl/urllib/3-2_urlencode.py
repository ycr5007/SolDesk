from urllib.request import urlopen
from urllib.parse import urlencode


param = {"query": "영화"}
encode_param = urlencode(param)

# print(encode_param) # query=%EC%98%81%ED%99%94

# 네이버 검색 :: 검색어 > 영화 URL
url = (
    "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&"
    + encode_param
)

try:
    res = urlopen(url).read().decode("UTF-8")
except:
    # "영화" 인코딩 안되어 에러 발생
    print("URL ERROR")
else:
    print(res)
