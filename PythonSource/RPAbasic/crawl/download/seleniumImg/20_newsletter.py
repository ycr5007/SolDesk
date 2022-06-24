# 네이버에서 뉴스 링크를 추출하여 가입자에게 전송

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.naver.com")

# 새 창 띄우기
browser.execute_script("window.open('https://www.daum.net')")

# 브라우저 2개 리스트 형태로 다루기 위한 처리
tabs = browser.window_handles

time.sleep(3)
browser.quit()
