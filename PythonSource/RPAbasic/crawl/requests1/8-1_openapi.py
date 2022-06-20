# naver open api 활용

import requests
from openpyxl import Workbook
from datetime import datetime

wb = Workbook()
ws = wb.active

ws.title = "키보드 1000"
ws.column_dimensions["B"].width = 60
ws.column_dimensions["C"].width = 80
ws.column_dimensions["D"].width = 15

ws.append(["번호", "결과", "링크", "최저가"])

client_id = "Dm27eyZkH2rWyqw6dAS1"
client_secret = "0Td5OQndQk"


headers = {"X-Naver-Client-Id": client_id, "X-Naver-Client-Secret": client_secret}

query = input("무엇을 ? ")
num = 1
for idx in range(1, 902, 100):
    url = f"https://openapi.naver.com/v1/search/shop.json?query={query}&display=100&start={str(idx)}"

    print(url)

    res = requests.get(url, headers=headers)

    # Json 데이터 확인
    # print(res.json())

    for item in res.json()["items"]:
        ws.append([num, item["title"], item["link"], item["lprice"]])
        ws.cell(row=num + 1, column=3).hyperlink = item["link"]
        num += 1


today = datetime.now().strftime("%y%m%d")
filename = f"naverAPI_{today}.xlsx"

wb.save("./RPAbasic/crawl/download/" + filename)
