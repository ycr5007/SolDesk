from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.get("http://www.daum.net")
browser.maximize_window()

# 원하는 요소 찾기
element = browser.find_element(By.NAME, "q")
# print(element) # <selenium.webdriver.remote.webelement.WebElement (session="49faa039e9d7f359fa44d6cb20b65eaf", element="8c4cdd59-5945-441a-b25d-2eb6dba97a53")>
# 검색어 넣기
element.send_keys("아이폰")
element.send_keys(Keys.ENTER)

# 검색결과 기다리기 ( 페이지 이동시간을 기다려, 작업의 정확도를 올린다 )
time.sleep(1)

# 뒤로 가기
browser.back()

time.sleep(3)
browser.quit()
