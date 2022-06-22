# 구글 이미지 다운로드

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from urllib.request import urlretrieve
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.google.co.kr/imghp?hl=ko&tab=ri&ogbl")
time.sleep(1)

search = browser.find_element(By.NAME, "q")
search.clear()
search.send_keys("아이유")
search.send_keys(Keys.ENTER)

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
        try:
            # 더보기 버튼 ( 비동기식, 버튼 )
            browser.find_element(By.CLASS_NAME, "mye4qd").click()
        except:
            break
    prev_height = curr_height

# 화면에 나온 작은 이미지
images = browser.find_elements(By.CSS_SELECTOR, "div.bRMDJf.islir > img")
count = 1

for image in images:
    try:
        # 이미지 저장 작업
        image.click()
        time.sleep(1)

        # 큰 이미지 요소 찾기
        img = browser.find_element(
            By.XPATH,
            '//*[@id="Sva75c"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img',
        ).get_attribute("src")
        urlretrieve(img, f"./RPAbasic/crawl/download/seleniumImg/{count}_.jpg")
        count += 1
    except Exception as e:
        print(f"이미지 저장 실패 >> {e}")

time.sleep(2)
browser.quit()
