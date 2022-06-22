# 구글 이미지 다운로드

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://news.v.daum.net/v/20220622125002120")
time.sleep(3)

browser.find_element(By.CLASS_NAME, "btn_foldup").click()
time.sleep(1)

try:
    # 댓글 최신순, 클릭 ( 5초 )
    WebDriverWait(browser, 5).until(
        EC.presence_of_element_located(
            (By.XPATH, '//*[@id="alex-area"]/div/div/div/div[3]/ul[1]/li[3]/button')
        )
    ).click()
except TimeoutException:
    print("요소 없음")

loop, count = True, 0
while loop and count < 10:
    try:
        # 더보기 버튼 10회 클릭
        WebDriverWait(browser, 5).until(
            EC.presence_of_element_located(
                (By.XPATH, '//*[@id="alex-area"]/div/div/div/div[3]/div[3]/button')
            )
        ).click()

        count += 1
        time.sleep(2)
    except TimeoutException:
        loop = False

# 댓글영역을 가져온 후 화면 출력
comments = browser.find_elements(By.CSS_SELECTOR, "div.cmt_info > p")
for cmt in comments:
    print(cmt.text)


time.sleep(2)
browser.quit()
