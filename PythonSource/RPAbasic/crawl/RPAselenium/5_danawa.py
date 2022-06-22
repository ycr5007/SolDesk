from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time


browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.danawa.com/")

time.sleep(1)

login_btn = browser.find_element(By.CLASS_NAME, "btn_user--login")
login_btn.click()

time.sleep(1)
id_input = browser.find_element(By.ID, "danawa-member-login-input-id")
id_input.clear()
id_input.send_keys("ycr5007")

pw_input = browser.find_element(By.ID, "danawa-member-login-input-pwd")
pw_input.clear()
pw_input.send_keys("9fdee295")
pw_input.send_keys(Keys.ENTER)


time.sleep(3)
browser.quit()
