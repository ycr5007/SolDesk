# 네이버에서 뉴스 링크를 추출하여 가입자에게 전송

from unittest import result
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time

import requests

import pyperclip

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.naver.com")

# 새 창 띄우기
browser.execute_script("window.open('https://www.daum.net')")

# 브라우저 2개 리스트 형태로 다루기 위한 처리
tabs = browser.window_handles

# 첫번째 탭 선택
browser.switch_to.window(tabs[0])

# 검색어 넣기
keyword = "RPA 파이썬"
browser.find_element(By.NAME, "query").send_keys(keyword)
browser.find_element(By.ID, "search_btn").click()

time.sleep(1)

# 뉴스탭 클릭
browser.find_element(By.XPATH, '//*[@id="lnb"]/div[1]/div/ul/li[8]/a').click()
time.sleep(1)
# 최신순 정렬
browser.find_element(By.XPATH, '//*[@id="snb"]/div[1]/div/div[1]/a[2]').click()
time.sleep(1)

# Naver API
client_id = "Dm27eyZkH2rWyqw6dAS1"
client_secret = "0Td5OQndQk"

headers = {"X-Naver-Client-Id": client_id, "X-Naver-Client-Secret": client_secret}
url = "https://openapi.naver.com/v1/search/news.json"
param = {"query": keyword}

res = requests.get(url, headers=headers, params=param)
result = res.json()

# 조회일 기준 뉴스 건 수 가져오기
new_total_cnt = result["total"]

# 뉴스 총 건수를 파일로 저장
with open("./RPAbasic/crawl/RPAselenium/20_totalCnt.txt", "r") as f:
    # 기존 뉴스 건수를 읽어와 변수에 저장 ( 20_totalCnt.txt 파일 내 데이터 )
    prev_total_cnt = f.read()

    # new_total_cnt 와 기존 뉴스건수 비교 ( new_total_cnt - prev_total_cnt = new_add_cnt )
    if new_total_cnt > int(prev_total_cnt):
        new_add_cnt = int(new_total_cnt) - int(prev_total_cnt)
    else:
        new_add_cnt = 0

    # new_add_cnt 파일에 데이터 저장
    with open("./RPAbasic/crawl/RPAselenium/20_totalCnt.txt", "w") as new_f:
        new_f.write(str(new_add_cnt))

# 반복할 페이지수 계산
if new_add_cnt == 0:
    page_cnt = 0
else:
    page_cnt = new_add_cnt // 10 + 1

# 페이지 수 만큼 반복 Crawling
start, num = 1, 1
result = ""

if page_cnt > 0:
    for i in range(page_cnt):
        start = 1 + (i * 10)
        search_url = f"https://search.naver.com/search.naver?where=news&sm=tab_pge&query={keyword}&sort=1"
        search_url += "&photo=0&field=0&pd=0&ds=&de=&mynews=0"
        search_url += f"&office_type=0&office_section_code=0&news_office_checked=&nso=so:dd,p:all,a:all&start={str(start)}"
        browser.get(search_url)

        # 뉴스 크롤링
        # 뉴스 제목 / 매체 / 등록일 / 원문 주소
        news_list = browser.find_elements(
            By.XPATH, '//*[@id="main_pack"]/section/div/div[2]/ul/li'
        )
        for news in news_list:
            tag_a = news.find_element(By.CSS_SELECTOR, "div.news_area > a")
            title = tag_a.text
            company = news.find_element(
                By.CSS_SELECTOR, "div.news_info > div.info_group > a"
            ).text
            reg_date = news.find_element(
                By.CSS_SELECTOR, "div.news_info > div.info_group > span"
            ).text
            href = tag_a.get_attribute("href")

            # print(f"{title} : {company} / {reg_date} ( {href} )")
            result += "<div><p><a href='" + href + "'>" + title + "</a> "
            result += company + " " + reg_date + "</p></div>"


time.sleep(1)
# 다음에서 이메일 전송 작업
browser.switch_to.window(tabs[1])
time.sleep(1)
# 다음 로그인
browser.find_element(By.CLASS_NAME, "link_daumid").click()
time.sleep(1)
# 아이디 입력
browser.find_element(By.ID, "id").send_keys("ycr5007")
# 비밀번호 입력
browser.find_element(By.ID, "inputPwd").send_keys("qpxmffpt1!!@#")
# 로그인 버튼클릭
browser.find_element(By.ID, "loginBtn").click()
time.sleep(1)

browser.find_element(By.CLASS_NAME, "link_num").click()
time.sleep(1)

# 메일 내용 복사
pyperclip.copy(result)

# 메일 쓰기 클릭
browser.find_element(By.CLASS_NAME, "btn_write").click()
time.sleep(1)
# 받는사람 이메일 주소 입력
browser.find_element(By.ID, "toTextarea").send_keys("ycr5007@naver.com")
browser.find_element(By.ID, "toTextarea").send_keys(Keys.ENTER)
time.sleep(2)
# 제목 입력 ( 20_newsletter 파이썬 실습 )
browser.find_element(By.ID, "mailSubject").send_keys("20_newsletter 파이썬 실습")
browser.find_element(By.ID, "mailSubject").send_keys(Keys.ENTER)
time.sleep(1)
# 내용 입력 전 HTML 형태로 입력 후, Editor 탭으로 다시 전환
browser.find_element(By.CLASS_NAME, "btn_html").click()
time.sleep(1)

browser.find_element(
    By.CSS_SELECTOR, "#tx_canvas_source_holderc185 > textarea"
).send_keys(Keys.CONTROL, "v")
time.sleep(1)

# 전송버튼 클릭
browser.find_element( 
    By.XPATH, '//*[@id="composer"]/div/div[1]/div[2]/div/div/button[1]'
).click()
time.sleep(2)

time.sleep(3)
browser.quit()
