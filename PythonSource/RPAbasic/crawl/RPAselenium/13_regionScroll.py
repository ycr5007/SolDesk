# 페이지 내부 스크롤 이동

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.w3schools.com/tags/default.asp")
time.sleep(1)

element = browser.find_element(By.XPATH, '//*[@id="leftmenuinnerinner"]/div/a[56]')

# ActionChain() : 여러 개의 Action을 수행할 경우 차례대로 저장한 후 수행
#               : 마우스 이동, 클릭, key press ...

actions = ActionChains(browser)
actions.move_to_element(element).perform()
# .perform() : action 의 마지막에 입력하며, action 에 저장된 내용을 수행하도록 하는 명령어

time.sleep(2)
browser.quit()
