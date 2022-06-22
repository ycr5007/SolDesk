# 검색어 넣고 검색 결과 출력

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

from bs4 import BeautifulSoup

options = webdriver.ChromeOptions()
options.headless = True  # 브라우저 창을 띄우지 않음 ( 결과만 터미널에 출력 )

browser = webdriver.Chrome(options=options)
browser.maximize_window()
browser.get("https://www.youtube.com/")
time.sleep(2)

search = browser.find_element(By.NAME, "search_query")
search.send_keys("파이썬 셀레니움")
search.send_keys(Keys.ENTER)
time.sleep(2)

res = BeautifulSoup(browser.page_source, "lxml")
titles = res.find_all("h3")

for title in titles:
    print(title.text)

time.sleep(2)
browser.quit()
