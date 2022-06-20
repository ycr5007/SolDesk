# 도서명, 링크, 출판사(publisher), 출간일

import requests
from openpyxl import Workbook
from datetime import datetime

wb = Workbook()
ws = wb.active

ws.column_dimensions["B"].width = 20
ws.column_dimensions["C"].width = 50
ws.column_dimensions["D"].width = 20
ws.column_dimensions["E"].width = 20

ws.append(["번호", "도서명", "링크", "출판사", "출간일"])

client_id = "Dm27eyZkH2rWyqw6dAS1"
client_secret = "0Td5OQndQk"

headers = {"X-Naver-Client-Id": client_id, "X-Naver-Client-Secret": client_secret}

num = 1
keyword = input("검색어 ? ")
for idx in range(1, 902, 100):
    url = f"https://openapi.naver.com/v1/search/book.json?query={keyword}&display=100&start={idx}"

    res = requests.get(url, headers=headers)

    for book in res.json()["items"]:
        title = book["title"]
        link = book["link"]
        publisher = book["publisher"]
        pubdate = book["pubdate"]
        ws.append([num, title, link, publisher, pubdate])
        ws.cell(row=num, column=3).hyperlink = link
        num += 1

today = datetime.now().strftime("%y%m%d")
filename = f"BookSearch_{today}.xlsx"
wb.save(f"./RPAbasic/crawl/download/{filename}")
