# 환율변동 자동화
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://www.kebhana.com/cont/mall/mall15/mall1503/index.jsp")
time.sleep(2)

# iframe 활용 페이지 ( frame 변경 필요 )
browser.switch_to.frame("bankIframe")

# 기간환율변동 클릭
browser.find_element(By.CSS_SELECTOR, "#inqType_p + label").click()
# 시작일자 (20220523)
st_date = browser.find_element(By.ID, "tmpInqStrDt_p")
st_date.clear()
st_date.send_keys("20220523")
st_date.send_keys(Keys.ENTER)
# 종료일자 (20220622)
ed_date = browser.find_element(By.ID, "tmpInqEndDt_p")
ed_date.clear()
ed_date.send_keys("20220622")
ed_date.send_keys(Keys.ENTER)


for i in range(2, 50):
    # 통화선택 = 유로클릭
    browser.find_element(By.ID, "curCd").click()
    browser.find_element(By.CSS_SELECTOR, f"#curCd > option:nth-child({i})").click()
    browser.find_element(By.ID, "curCd").send_keys(Keys.ESCAPE)

    # 고시회차 => 최종
    browser.find_element(By.CSS_SELECTOR, "#tmpPbldDvCd_2 + label").click()
    # 조회버튼 클릭
    browser.find_element(By.XPATH, '//*[@id="HANA_CO=[NTENTS_DIV"]/div[2]/a/span').click()
    time.sleep(1)

    # 엑셀 다운로드 클릭
    browser.find_element(By.CLASS_NAME, "excel").click()


time.sleep(3)
browser.quit()
