from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("http://www.naver.com")
time.sleep(1)

# 두번째 탭을 연 후에 daum 접속
# Script 새 창 열기 ( .execute_script :: 스크립트 문장 입력 함수)
browser.execute_script("window.open('http://www.daum.net')")

print(f"tab1 : title :: {browser.title}")
# naver 반환 > 최초 접근한 browser 를 벗어나지 않음

tabs = browser.window_handles

browser.switch_to.window(tabs[1])  # 탭 전환
print(f"tab2 : title :: {browser.title}")

daum_element = browser.find_element(By.NAME, "q")
daum_element.send_keys("이어폰")
daum_element.send_keys(Keys.ENTER)

time.sleep(1)

browser.switch_to.window(tabs[0])
naver_element = browser.find_element(By.NAME, "query")
naver_element.send_keys("헤드셋")
naver_element.send_keys(Keys.ENTER)

time.sleep(2)
browser.quit()
