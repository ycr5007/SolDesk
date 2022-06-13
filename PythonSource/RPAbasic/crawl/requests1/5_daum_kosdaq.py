import requests as req
from fake_useragent import UserAgent
import csv

headers = {"user-agent": UserAgent().chrome, "referer": "https://finance.daum.net/"}
path = "./RPAbasic/crawl/download/"
data = []
try:
    url = "https://finance.daum.net/api/search/ranks"
    res = req.get(url, headers=headers, params={"limit": 10})
    # print(res.text)  # JSON 형태로 반환

    # print(res.json())
    for item in res.json()["data"]:
        # print(
        #     "순위 {}, 금액 {}, 회사명 {}".format(
        #         item["rank"], item["tradePrice"], item["name"]
        #     )
        # )
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
