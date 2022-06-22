# iframe (Inline Frame) : 하나의 HTML 페이지 내에 다른 html 태그를 갖는 방식
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get(
    "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio"
)
time.sleep(1)

browser.switch_to.frame("iframeResult")
browser.find_element(By.ID, "html").click()
browser.find_element(By.ID, "age2").click()
browser.find_element(By.XPATH, "/html/body/form/input[7]").click()


browser.switch_to.default_content()
out_iframe = browser.find_element(
    By.CSS_SELECTOR,
    "#textareawrapper > div > div.CodeMirror-scroll > div.CodeMirror-sizer > div > div > div > div.CodeMirror-code > pre:nth-child(5) > span > span:nth-child(4)",
)

print(out_iframe.text)

time.sleep(2)
browser.quit()
