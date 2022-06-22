# Gmarket 접속하고 상품명 입력한 후 결과 페이지 이동

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.gmarket.co.kr/")
time.sleep(1)

search = browser.find_element(By.NAME, "keyword")
search.clear()
search.send_keys("이어폰")
search.send_keys(Keys.ENTER)

time.sleep(2)
browser.quit()
