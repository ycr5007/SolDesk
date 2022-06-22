from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.get("http://www.python.org")
browser.maximize_window()
time.sleep(1)
# 결과 페이지에서 원하는 요소 찾기
# find_element()    : 하나의 요소를 찾을 때
# find_elements()   : 여러개의 요소를 찾을 때 ( 반환 : List )

# 요소 검색 기준 ( By )
# By.NAME
# By.ID
# By.CLASS_NAME
# By.CSS_SELECTOR
# By.LINK_TEXT
# By.PARTIAL_LINK_TEXT
# By.TAG_NAME
# By.XPATH : XPath란 XML Path Language를 의미합니다. XPath는 XML 문서의 특정 요소나 속성에 접근하기 위한 경로를 지정하는 언어

# 아이디 값 찾기
element = browser.find_element(By.ID, "id-search-field")
# 클래스 이름으로 찾기
element = browser.find_element(By.CLASS_NAME, "search-field")
# CSS 선택자로 찾기
element = browser.find_element(By.CSS_SELECTOR, "#id-search-field")
# XPATH 로 찾기
element = browser.find_element(By.XPATH, '//*[@id="id-search-field"]')

element.send_keys("python")
element.send_keys(Keys.ENTER)

time.sleep(2)
browser.quit()
