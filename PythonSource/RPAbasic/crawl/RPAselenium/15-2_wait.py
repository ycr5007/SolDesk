# 구글 이미지 다운로드

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("https://flight.naver.com/")
time.sleep(1)

try:
    # 목적지 버튼 클릭
    browser.find_element(By.CSS_SELECTOR, "button.end").click()
    # 목적지 1차분류
    WebDriverWait(browser, 3).until(
        EC.presence_of_element_located(
            (
                By.CSS_SELECTOR,
                "div.autocomplete_content__3RhAZ > section > section > button:nth-child(1)",
            )
        )
    ).click()
    # 목적지 2차분류
    WebDriverWait(browser, 3).until(
        EC.presence_of_element_located(
            (
                By.CSS_SELECTOR,
                "div.autocomplete_content__3RhAZ > section > section > div > button:nth-child(2)",
            )
        )
    ).click()

    # 날짜 버튼 클릭
    browser.find_element(
        By.CSS_SELECTOR, "div.tabContent_options__KwvIB > button"
    ).click()
    time.sleep(1)

    # 가는 날짜 선택
    WebDriverWait(browser, 3).until(
        EC.presence_of_element_located(
            (
                By.XPATH,
                '//*[@id="__next"]/div/div[1]/div[9]/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[5]/td[2]/button',
            )
        )
    ).click()
    time.sleep(1)

    # 오는 날짜 선택
    WebDriverWait(browser, 3).until(
        EC.presence_of_element_located(
            (
                By.XPATH,
                '//*[@id="__next"]/div/div[1]/div[9]/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[5]/td[4]/button',
            )
        )
    ).click()
    time.sleep(1)

    # 검색 버튼 클릭
    browser.find_element(
        By.CSS_SELECTOR, "div.main_searchbox__3vrV3 > div > div > button"
    ).click()

    # 검색 결과 출력
    airline = WebDriverWait(browser, 15).until(
        EC.presence_of_element_located(
            (By.CSS_SELECTOR, "div.domestic_results__yNAgI > div:nth-child(2)")
        )
    )

    print(airline.text)
except Exception as e:
    print(e)

time.sleep(2)
browser.quit()
