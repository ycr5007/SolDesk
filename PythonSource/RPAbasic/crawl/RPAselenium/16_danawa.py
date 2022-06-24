from math import prod
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

from openpyxl import Workbook
from openpyxl.drawing.image import Image

import requests
from io import BytesIO

wb = Workbook()
ws = wb.active
ws.title = "danawa_APPLE"
ws.append(["번호", "제품명", "가격", "제품사진", "이미지"])
ws.column_dimensions["B"].width = 40
ws.column_dimensions["C"].width = 15
ws.column_dimensions["D"].width = 95
ws.column_dimensions["E"].width = 20

browser = webdriver.Chrome()
browser.maximize_window()
browser.get("http://prod.danawa.com/list/?cate=112758&15main_11_02")

try:
    # 제조사 더 보기 버튼 클릭
    WebDriverWait(browser, 3).until(
        EC.presence_of_element_located(
            (
                By.CSS_SELECTOR,
                "#dlMaker_simple > dd > div.spec_opt_view > button.btn_spec_view.btn_view_more",
            )
        )
    ).click()

    # APPLE 필터링 설정
    browser.find_element(By.ID, "searchMaker1452").click()
    time.sleep(1)

    curr_page, target_crawl_num = 1, 6
    idx = 1
    # 상품 정보 추출 - 상품명, 가격 ( 최상단 ), 이미지 src
    # 현재페이지 출력
    while curr_page <= target_crawl_num:
        prod_list = browser.find_elements(
            By.CSS_SELECTOR,
            "#productListArea > div.main_prodlist.main_prodlist_list > ul > li:not(.prod_ad_item):not(.product-pot)",
        )
        print(f"==================== Current Page : {curr_page} ====================")
        for item in prod_list:
            item_name = item.find_element(By.CSS_SELECTOR, "p > a").text.strip()
            price = item.find_element(By.CSS_SELECTOR, "p.price_sect > a").text
            img = item.find_element(By.TAG_NAME, "img")
            if img.get_attribute("data-original"):
                img = img.get_attribute("data-original")
            else:
                img = img.get_attribute("src")

            if "http:" not in img:
                img = "http:" + img
            print(f"{idx} : {item_name} :::: {price} >>>> img SRC ( {img} )")
            ws.append([idx, item_name, price, img])

            # 이미지 다운로드 받아 엑셀에 삽입
            res = requests.get(img)
            img_save = BytesIO(res.content)
            img = Image(img_save)
            img.width = 30
            img.height = 20
            ws.add_image(img, "E" + str(idx + 1))
            idx += 1

        browser.save_screenshot(
            f"./RPAbasic/crawl/download/seleniumImg/target_page_{curr_page}.png"
        )

        # 현재 페이지 번호 변경
        curr_page += 1
        if curr_page > target_crawl_num:
            print("Succeed Crawling")
            break
        WebDriverWait(browser, 2).until(
            EC.presence_of_element_located(
                (By.CSS_SELECTOR, f"div.number_wrap > a:nth-child({curr_page})")
            )
        ).click()

        # 다음 페이지 로딩까지 기다림
        time.sleep(2)
except TimeoutException:
    print("시간초과")


time.sleep(3)
browser.quit()

wb.save("./RPAbasic/crawl/download/seleniumImg/danawa_crawling_data.xlsx")
