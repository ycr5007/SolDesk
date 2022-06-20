# clien 팁과강좌 크롤링 + Excel 데이터 저장

import requests
from bs4 import BeautifulSoup
from openpyxl import Workbook
from datetime import datetime

wb = Workbook()

ws = wb.active

# A 컬럼 width 조절
ws.column_dimensions["A"].width = 70
ws.column_dimensions["B"].width = 20

# 시트명 지정
ws.title = "클리앙-팁과 강좌"

# 제목행 지정
ws.append(["글제목", "작성날짜"])

for page_num in range(5):
    if page_num == 0:
        res = requests.get("https://www.clien.net/service/board/lecture")
    res = requests.get(
        "https://www.clien.net/service/board/lecture?&od=T31&category=0&po="
        + str(page_num)
    )
    soup = BeautifulSoup(res.text, "lxml")

    title_list = soup.select("a.list_subject > span.subject_fixed")
    date_list = soup.select(
        "div.list_content > div.list_item > div.list_time > span > span"
    )
    for idx, info in enumerate(title_list):
        # print(info.get_text().strip(), date_list[idx].get_text()[:10])
        ws.append([info.get_text().strip(), date_list[idx].get_text()[:10]])
# 파일명 지정 ( clien_220620.xlsx )
today = datetime.now().strftime("%y%m%d")
filename = f"clien_{today}.xlsx"

# Excel 저장
wb.save("./RPAbasic/crawl/download/beautifulsoup/" + filename)
