from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.get("http://www.daum.net")
browser.maximize_window()
time.sleep(1)

search = browser.find_element(By.ID, "q")
search.clear()
search.send_keys("방탄소년단")
search.send_keys(Keys.ENTER)
time.sleep(1)

# 관련 검색어 추출
element = browser.find_elements(By.CSS_SELECTOR, "#netizen_lists_top > span.wsn")

for keyword in element:
    print(keyword.text)

# 현재화면 캡쳐 ( selenium 기본 이미지 파일 .png , 다른 확장자도 가능하나 경고문 )
browser.save_screenshot("./RPAbasic/crawl/download/seleniumImg/image.png")

time.sleep(2)
browser.quit()
