from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time

from bs4 import BeautifulSoup

from openpyxl import Workbook

wb = Workbook()
ws = wb.active
ws.title = "용역 입찰공고"
ws.append(
    ["업무", "공고번호-차수", "분류", "공고명", "공고기관", "수요기관", "계약방법", "입력일시", "입찰마감일시", "원문상세주소"]
)
for i in range(1, 4):
    st_date = "2022%2F05%2F22"
    ed_date = "2022%2F06%2F23"
    url = "https://www.g2b.go.kr:8101/ep/tbid/tbidList.do?"
    url += f"area=&bidNm=&bidSearchType=1&fromBidDt={st_date}&fromOpenBidDt="
    url += f"&instNm=&radOrgan=1&regYn=Y&searchDtType=1&searchType=1&taskClCds=&toBidDt={ed_date}"
    url += f"&toOpenBidDt=&currentPageNo={i}&maxPageViewNoByWshan=2&"
    browser = webdriver.Chrome()
    browser.maximize_window()
    browser.get(url)

    # 업무	공고번호-차수	분류	공고명	공고기관	수요기관	계약방법	입력일시    입찰마감일시    원문상세주소

    rows = browser.find_elements(By.CSS_SELECTOR, "tbody > tr")
    for row in rows:
        list = []
        cols = row.find_elements(By.TAG_NAME, "td")
        for data in cols:
            list.append(data.text)
        ws.append(
            [
                list[0],
                list[1],
                list[2],
                list[3],
                list[4],
                list[5],
                list[6],
                list[7].split("\n")[0],
                list[7].split("\n")[1],
                row.find_element(By.CSS_SELECTOR, "a:nth-child(1)").get_attribute(
                    "href"
                ),
            ]
        )
    time.sleep(1)
    browser.quit()

wb.save("./RPAbasic/crawl/download/seleniumImg/goverment.xlsx")
