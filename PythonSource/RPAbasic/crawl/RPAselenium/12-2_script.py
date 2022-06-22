from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("http://www.naver.com")
time.sleep(1)

browser.find_element(By.CSS_SELECTOR, "li.nav_item > a.shop").click()
time.sleep(1)

search_btn = browser.find_element(By.CLASS_NAME, "_searchInput_search_input_QXUFf")
search_btn.send_keys("마우스")
search_btn.send_keys(Keys.ENTER)
time.sleep(1)

# 스크롤 이동 ( Script : window.scrollTo(x, y) )
# for i in range(1, 5):
#     browser.execute_script(f"window.scrollTo(0, {i * 1080})")
#     time.sleep(1)

# 브라우저 끝으로 이동 ( document.body.scrollHeight ( 현재 문서의 끝 ))
# for i in range(1, 10):
#     browser.execute_script("window.scrollTo(0, document.body.scrollHeight)")
#     time.sleep(1)

# 동적 페이지 스크롤링

interval = 2  # 2 초에 한번 스크롤

# 현재 문서의 높이
prev_height = browser.execute_script("window.scrollTo(0, document.body.scrollHeight)")

while True:
    # 스크롤 이동
    browser.execute_script("window.scrollTo(0, document.body.scrollHeight)")
    time.sleep(interval)

    # 스크롤이 진행된 후 현재 문서 높이
    curr_height = browser.execute_script("return document.body.scrollHeight")

    if curr_height == prev_height:
        break
    prev_height = curr_height

# 브라우저 처음으로 이동
browser.execute_script("window.scrollTo(0, 0)")
time.sleep(2)
browser.quit()
