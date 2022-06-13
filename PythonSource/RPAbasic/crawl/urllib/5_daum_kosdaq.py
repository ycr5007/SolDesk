from urllib.request import Request, urlopen
from fake_useragent import UserAgent
import json
import csv

headers = {"user-agent": UserAgent().chrome, "referer": "https://finance.daum.net/"}
path = "./RPAbasic/crawl/download/"
data = []
try:
    url = "https://finance.daum.net/api/search/ranks?limit=10"
    res = urlopen(Request(url, headers=headers)).read().decode("UTF-8")
    # print(res) # JSON 형태로 반환

    # JSON To Dictionary
    rank_json = json.loads(res)["data"]

    for item in rank_json:
        print(
            "순위 {}, 금액 {}, 회사명 {}".format(
                item["rank"], item["tradePrice"], item["name"]
            )
        )
        data.append(item)

    # 크롤링 데이터 저장 ( txt 파일 / csv 파일 )
    with open(path + "finance.txt", "a", encoding="UTF-8") as txt:
        with open(path + "finance.csv", "a", encoding="UTF-8", newline="") as csvfile:
            # 텍스트 저장
            txt.write(
                "순위 {}, 금액 {}, 회사명 {}\n".format(
                    item["rank"], item["tradePrice"], item["name"]
                )
            )

            # csv 저장
            output = csv.writer(csvfile)
            # Column 타이틀 (Header)
            output.writerow(data[0].keys())
            for row in data:
                output.writerow(row.values())  # value 저장

except Exception as e:
    print(e)

# 비동기식 데이터 ( Ajax ) 는 값을 가져오지 못하고 있음

# 브라우저 설정 Network 탭 ( F12 )
# DOC : 실제 브라우저 페이지에 대한 요청 정보
# Fetch/XHR : 비동기식 데이터 접근을 위한 요청 정보
#   일부 사이트는 보안상의 문제로 AJax URL 접근을 제한 (Security ...) >> 403 Error 발생
#   데이터 확인 법 ( preview 탭에서 주고받은 데이터 확인 가능 )
#   ( headers 탭 ) referer: https://finance.daum.net/ ( 정상적으로 동작하기 위해서는 : https://finance.daum.net 에서 해당 데이터를 요청해야 함 )
#       referer : 데이터 요청이 들어온 페이지 ( 크롤링 할 때, fake 주소를 지정해서 Ajax 데이터를 조회해야 한다 )
