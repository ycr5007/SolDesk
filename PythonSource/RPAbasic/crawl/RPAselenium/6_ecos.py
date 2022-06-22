# 한국은행 경제 통계시스템 엑셀파일 다운로드

from click import option
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

options = webdriver.ChromeOptions()
options.headless = True
# ElementClickInterceptedException : 버튼을 눌러 다운로드를 실행해야하나, 버튼을 찾을 수 없어 에러 발생
browser = webdriver.Chrome(options=options)
browser.maximize_window()
browser.get("https://ecos.bok.or.kr")
time.sleep(3)

# 100 대 통계 지표 찾기
# Copy XPath    : //*[@id="root"]/div[5]/div/div[2]/div[4]/div[1]/div[3]/ul/li[1]/a
# Copy Selector : #root > div.wrap-body > div > div.main-wrap.clearfix > div.main-row3.clearfix > div.main-left > div.main-icon-menu > ul > li:nth-child(1) > a
link_btn = browser.find_element(
    By.XPATH, '//*[@id="root"]/div[5]/div/div[2]/div[4]/div[1]/div[3]/ul/li[1]/a'
).click()
time.sleep(2)

download_btn = browser.find_element(
    By.CSS_SELECTOR, "div.exelDown.partition-right > button"
).click()

time.sleep(3)
browser.quit()
