# 행정안전부 게시판 목록 가져오기

from urllib.request import urlopen
from urllib.parse import urlencode


params = []

for num in [1001, 1012, 1013, 1014]:
    params.append(dict(ctxCd=num))

print(params)

import time

try:
    for c in params:
        url = "https://www.mois.go.kr/gpms/view/jsp/rss/rss.jsp"
        param = urlencode(c)
        url = url + "?" + param
        print("URL :: {}".format(url))

        data = urlopen(url).read().decode("UTF-8")
        print()
        print(data)
        print()
        time.sleep(3)
except:
    print("Error")
