# iframe (Inline Frame) : 하나의 HTML 페이지 내에 다른 html 태그를 갖는 방식
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_headers")
time.sleep(1)


# iframe 안의 태그 찾는 방법 : iframe 내부로 들어가서 찾아야한다.
browser.switch_to.frame("iframeResult")

in_iframe = browser.find_element(By.TAG_NAME, "h1")
print(in_iframe.text)

# iframe 밖으로 나오는 방법
browser.switch_to.default_content()
out_iframe = browser.find_element(
    By.XPATH,
    '//*[@id="textareawrapper"]/div/div[6]/div[1]/div/div/div/div[5]/pre[12]/span/span[10]',
)
print(out_iframe.text)

time.sleep(2)
browser.quit()
