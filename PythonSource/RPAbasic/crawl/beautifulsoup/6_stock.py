# 네이버 금융 주식 인기 검색 종목

import requests
from bs4 import BeautifulSoup

res = requests.get("https://finance.naver.com/")
# print(res.text)

soup = BeautifulSoup(res.text, "lxml")

# 인기 검색 종목 - 종목명, 현재 가격

stock_table = soup.select_one(".tbl_home")
# print(stock_table)

stock_title = soup.select("em + a")
# print(stock_title)

stock_price = soup.select(
    "#container > div.aside > div > div.aside_area.aside_popular > table > tbody > tr > td:nth-child(2)"
)
# print(stock_price)


for stock in range(len(stock_title) - 1):
    print(stock_title[stock].text)
    print("\t", stock_price[stock].text)


stock_data = soup.select(
    "#container > div.aside > div > div.aside_area.aside_stock > table > tbody > tr"
)
# print(stock_data)

for stock in stock_data:
    print(stock.find("a").get_text())
    print("\t", stock.find("td").get_text())
