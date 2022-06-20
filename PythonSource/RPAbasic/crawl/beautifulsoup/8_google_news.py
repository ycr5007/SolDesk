# 구글 뉴스

import requests
from bs4 import BeautifulSoup


def main():
    # q = 파이썬
    url = "https://news.google.com/search?q=%ED%8C%8C%EC%9D%B4%EC%8D%AC&hl=ko&gl=KR&ceid=KR%3Ako"

    res = requests.get(url)
    soup = BeautifulSoup(res.text, "lxml")

    news_cliping = data_extract(soup)
    for clip in news_cliping:
        for article in clip.keys():
            print("{} : {}".format(article, clip[article]))
        print()


def data_extract(soup):
    # 원하는 요소 출력
    news_list = []

    # 뉴스 원문 url, 제목, 출처, 등록 일시
    articles = soup.select("div.xrnccd > article")
    for article in articles:
        news_item = {}
        # print(article, end="\n\n\n")
        link_title = article.select_one("h3 > a")
        title = link_title.get_text()
        href = "https://news.google.com" + link_title["href"][1:]
        # company = article.select_one("svg + a").get_text()
        # regist_time = article.select_one("a + time")
        writer_time = article.select_one("div.SVJrMe")
        writer = writer_time.select_one("a").get_text()
        date_time = writer_time.select_one("time")

        if date_time:
            report_date_time = date_time["datetime"].split("T")
            report_date = report_date_time[0]
            report_time = report_date_time[1]
        else:
            report_date = ""
            report_time = ""

        news_item["title"] = title
        news_item["href"] = href
        news_item["writer"] = writer
        news_item["report_date"] = report_date
        news_item["report_time"] = report_time

        news_list.append(news_item)

    return news_list


if __name__ == "__main__":
    main()
