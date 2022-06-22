from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import time

from bs4 import BeautifulSoup

browser = webdriver.Chrome()
browser.get("http://www.python.org")
browser.maximize_window()

# 특정 element 가져오기 ( .find_element(검색조건, 검색태그속성) )
element = browser.find_element(By.ID, "id-search-field")

# 검색창 초기화 ( 자동완성 기능 방지 )
element.clear()
# 검색 keyword 입력
element.send_keys("python")
# ENTER 입력
element.send_keys(Keys.ENTER)
time.sleep(1)

# 결과페이지에서 원하는 요소 추출
# titles = browser.find_elements(By.TAG_NAME, "h3")

# BeautifulSoup 이용
res = BeautifulSoup(browser.page_source, "lxml")
titles = res.find_all("h3")

for title in titles:
    print(title.text)

time.sleep(3)
browser.quit()
